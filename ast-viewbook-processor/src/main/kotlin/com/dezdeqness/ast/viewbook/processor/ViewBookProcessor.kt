package com.dezdeqness.ast.viewbook.processor

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.Dependencies
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.processing.SymbolProcessorProvider
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSAnnotation
import com.google.devtools.ksp.symbol.KSPropertyDeclaration

private const val ANNOTATION_FQN = "com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry"
private const val GENERATED_PACKAGE = "com.dezdeqness.ast.generated"
private const val GENERATED_FILE = "GeneratedViewBook"

class ViewBookProcessorProvider : SymbolProcessorProvider {
    override fun create(environment: SymbolProcessorEnvironment): SymbolProcessor =
        ViewBookProcessor(environment.codeGenerator)
}

class ViewBookProcessor(
    private val codeGenerator: CodeGenerator,
) : SymbolProcessor {

    private var generated = false

    override fun process(resolver: Resolver): List<KSAnnotated> {
        if (generated) return emptyList()

        val properties = resolver.getSymbolsWithAnnotation(ANNOTATION_FQN)
            .filterIsInstance<KSPropertyDeclaration>()
            .toList()

        if (properties.isEmpty()) return emptyList()

        val entries = properties.mapNotNull { property ->
            val qualified = property.qualifiedName?.asString() ?: return@mapNotNull null
            val annotation = property.annotations.firstOrNull {
                it.shortName.asString() == "ViewCaseEntry"
            } ?: return@mapNotNull null

            val name = (annotation.arg("name") as? String)
                ?.takeIf { it.isNotBlank() }
                ?: property.simpleName.asString().prettify()

            val folderPath = property.containingFile?.annotations
                ?.firstOrNull { it.shortName.asString() == "Folder" }
                ?.let { it.arg("path") as? List<*> }
                .orEmpty().filterIsInstance<String>()
            val entryPath =
                (annotation.arg("path") as? List<*>).orEmpty().filterIsInstance<String>()

            Entry(qualified = qualified, name = name, path = folderPath + entryPath)
        }

        val roots = mutableListOf<Node>()
        entries.forEach { entry -> insert(roots, entry, prefix = emptyList()) }

        val code = render(roots)
        val containingFiles = properties.mapNotNull { it.containingFile }.toTypedArray()

        codeGenerator.createNewFile(
            dependencies = Dependencies(aggregating = true, *containingFiles),
            packageName = GENERATED_PACKAGE,
            fileName = GENERATED_FILE,
        ).bufferedWriter().use { it.write(code) }

        generated = true
        return emptyList()
    }

    private fun KSAnnotation.arg(argName: String): Any? =
        arguments.firstOrNull { it.name?.asString() == argName }?.value

    private data class Entry(
        val qualified: String,
        val name: String,
        val path: List<String>,
    )

    private sealed class Node {
        abstract val id: String
        abstract val name: String
    }

    private class Leaf(
        override val id: String,
        override val name: String,
        val qualified: String,
    ) : Node()

    private class Folder(
        override val id: String,
        override val name: String,
        val children: MutableList<Node> = mutableListOf(),
    ) : Node()

    private fun insert(siblings: MutableList<Node>, entry: Entry, prefix: List<String>) {
        if (entry.path.isEmpty()) {
            siblings += Leaf(
                id = slug(prefix + entry.name),
                name = entry.name,
                qualified = entry.qualified,
            )
            return
        }

        val folderName = entry.path.first()
        val folderPrefix = prefix + folderName
        val folder = siblings.filterIsInstance<Folder>().firstOrNull { it.name == folderName }
            ?: Folder(id = slug(folderPrefix), name = folderName)
                .also { siblings += it }

        insert(folder.children, entry.copy(path = entry.path.drop(1)), folderPrefix)
    }

    private fun render(roots: List<Node>): String = buildString {
        appendLine("package $GENERATED_PACKAGE")
        appendLine()
        appendLine("import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem")
        appendLine("import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase")
        appendLine()
        appendLine("fun generatedViewBookItems(): List<HierarchicalItem<ViewCase>> = listOf(")
        renderNodes(roots, indent = 1)
        appendLine(")")
    }

    private fun StringBuilder.renderNodes(nodes: List<Node>, indent: Int) {
        val pad = "    ".repeat(indent)
        nodes.sortedBy { it.name.lowercase() }.forEach { node ->
            when (node) {
                is Leaf -> {
                    appendLine("${pad}HierarchicalItem.Item(")
                    appendLine("$pad    id = \"${node.id}\",")
                    appendLine("$pad    displayName = ${node.name.quote()},")
                    appendLine("$pad    value = ${node.qualified},")
                    appendLine("$pad),")
                }

                is Folder -> {
                    appendLine("${pad}HierarchicalItem.Folder(")
                    appendLine("$pad    id = \"${node.id}\",")
                    appendLine("$pad    displayName = ${node.name.quote()},")
                    appendLine("$pad    children = listOf(")
                    renderNodes(node.children, indent + 2)
                    appendLine("$pad    ),")
                    appendLine("$pad),")
                }
            }
        }
    }
}

private fun String.prettify(): String =
    replace(Regex("([a-z])([A-Z])"), "$1 $2")
        .replaceFirstChar { it.uppercase() }

private fun String.quote(): String = "\"" + replace("\\", "\\\\").replace("\"", "\\\"") + "\""

private fun slug(parts: List<String>): String =
    parts.joinToString("-") { part ->
        buildString {
            var lastDash = false
            part.lowercase().forEach { ch ->
                if (ch.isLetterOrDigit()) {
                    append(ch)
                    lastDash = false
                } else if (!lastDash) {
                    append('-')
                    lastDash = true
                }
            }
        }.trim('-')
    }
