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
) {
    var expandedFolders by remember { mutableStateOf(setOf<String>()) }

    fun toggleFolder(folderId: String) {
        expandedFolders = if (expandedFolders.contains(folderId)) {
            expandedFolders - folderId
        } else {
            expandedFolders + folderId
        }
    }

    fun flattenItems(
        items: List<HierarchicalItem<T>>,
        level: Int = 0
    ): List<Pair<HierarchicalItem<T>, Int>> {
        val result = mutableListOf<Pair<HierarchicalItem<T>, Int>>()
        items.forEach { item ->
            result.add(item to level)
            if (item is HierarchicalItem.Folder && expandedFolders.contains(item.id)) {
                result.addAll(flattenItems(item.children, level + 1))
            }
        }
        return result
    }

    val flatItems = flattenItems(items)

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
                        isExpanded = expandedFolders.contains(item.id),
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
            modifier = Modifier.padding(start = 12.dp)
        )
    }
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
