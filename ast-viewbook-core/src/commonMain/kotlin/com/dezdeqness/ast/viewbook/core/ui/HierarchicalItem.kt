package com.dezdeqness.ast.viewbook.core.ui

sealed class HierarchicalItem<T> {
    abstract val id: String
    abstract val displayName: String
    abstract val level: Int

    data class Folder<T>(
        override val id: String,
        override val displayName: String,
        override val level: Int = 0,
        val children: List<HierarchicalItem<T>> = emptyList(),
        val isExpanded: Boolean = false,
    ) : HierarchicalItem<T>()

    data class Item<T>(
        override val id: String,
        override val displayName: String,
        override val level: Int = 0,
        val value: T,
    ) : HierarchicalItem<T>()
}
