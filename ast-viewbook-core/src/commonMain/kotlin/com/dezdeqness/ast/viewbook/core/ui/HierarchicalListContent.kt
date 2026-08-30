package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun <T> HierarchicalListContent(
    items: List<HierarchicalItem<T>>,
    selectedValue: T?,
    onValueSelected: (T) -> Unit,
    contentColor: Color = AppTheme.colors.background,
    filterQuery: String = "",
) {
    var expandedFolders by remember { mutableStateOf(setOf<String>()) }

    fun toggleFolder(folderId: String) {
        expandedFolders = if (expandedFolders.contains(folderId)) {
            expandedFolders - folderId
        } else {
            expandedFolders + folderId
        }
    }

    val isFiltering = filterQuery.isNotBlank()
    val visibleItems = remember(items, filterQuery) { filterItems(items, filterQuery) }

    fun flattenItems(
        items: List<HierarchicalItem<T>>,
        level: Int = 0
    ): List<Pair<HierarchicalItem<T>, Int>> {
        val result = mutableListOf<Pair<HierarchicalItem<T>, Int>>()
        items.forEach { item ->
            result.add(item to level)
            val expanded = isFiltering || expandedFolders.contains(item.id)
            if (item is HierarchicalItem.Folder && expanded) {
                result.addAll(flattenItems(item.children, level + 1))
            }
        }
        return result
    }

    val flatItems = flattenItems(visibleItems)

    LazyColumn(
        modifier = Modifier.background(contentColor)
    ) {
        items(flatItems.size) { index ->
            val (item, level) = flatItems[index]

            when (item) {
                is HierarchicalItem.Folder -> {
                    FolderRow(
                        folder = item,
                        level = level,
                        isExpanded = isFiltering || expandedFolders.contains(item.id),
                        count = countItems(item.children),
                        onToggle = { toggleFolder(item.id) }
                    )
                }

                is HierarchicalItem.Item -> {
                    ItemRow(
                        item = item,
                        level = level,
                        isSelected = item.value == selectedValue,
                        onSelected = { onValueSelected(item.value) }
                    )
                }
            }
        }
    }
}

@Composable
private fun <T> FolderRow(
    folder: HierarchicalItem.Folder<T>,
    level: Int,
    isExpanded: Boolean,
    count: Int,
    onToggle: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onToggle() }
            .padding(
                start = (16 + level * 24).dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    ) {
        Icon(
            imageVector = if (isExpanded) {
                Icons.Default.KeyboardArrowDown
            } else {
                Icons.Default.KeyboardArrowRight
            },
            contentDescription = null,
            tint = AppTheme.colors.textSecondary
        )

        Text(
            text = folder.displayName,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.textPrimary,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )

        CountBadge(count = count)
    }
}

@Composable
internal fun CountBadge(count: Int) {
    Text(
        text = count.toString(),
        style = AppTheme.typography.labelSmall,
        color = AppTheme.colors.textSecondary,
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(AppTheme.colors.surfaceVariant)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    )
}

fun <T> countItems(items: List<HierarchicalItem<T>>): Int =
    items.sumOf { item ->
        when (item) {
            is HierarchicalItem.Item -> 1
            is HierarchicalItem.Folder -> countItems(item.children)
        }
    }

fun <T> filterItems(
    items: List<HierarchicalItem<T>>,
    query: String,
): List<HierarchicalItem<T>> {
    if (query.isBlank()) return items
    val q = query.trim()
    return items.mapNotNull { item ->
        when (item) {
            is HierarchicalItem.Item ->
                item.takeIf { it.displayName.contains(q, ignoreCase = true) }

            is HierarchicalItem.Folder -> {
                val children = filterItems(item.children, query)
                if (children.isNotEmpty() || item.displayName.contains(q, ignoreCase = true)) {
                    item.copy(children = children)
                } else {
                    null
                }
            }
        }
    }
}

fun <T> findPath(items: List<HierarchicalItem<T>>, target: T): List<String>? {
    for (item in items) {
        when (item) {
            is HierarchicalItem.Item ->
                if (item.value == target) return listOf(item.displayName)

            is HierarchicalItem.Folder -> {
                val childPath = findPath(item.children, target)
                if (childPath != null) return listOf(item.displayName) + childPath
            }
        }
    }
    return null
}

@Composable
private fun <T> ItemRow(
    item: HierarchicalItem.Item<T>,
    level: Int,
    isSelected: Boolean,
    onSelected: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onSelected() }
            .padding(
                start = (16 + level * 24).dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
    ) {
        RadioButton(
            selected = isSelected,
            onClick = null
        )

        Text(
            text = item.displayName,
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.textPrimary,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}
