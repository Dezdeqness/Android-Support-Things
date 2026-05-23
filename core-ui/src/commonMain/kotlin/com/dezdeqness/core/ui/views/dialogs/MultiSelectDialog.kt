package com.dezdeqness.core.ui.views.dialogs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun <T> MultiSelectDialog(
    title: String,
    items: List<T>,
    selectedItems: List<T>,
    itemText: @Composable (T) -> String,
    onConfirm: (List<T>) -> Unit,
    onDismiss: () -> Unit,
    confirmLabel: String = "OK",
    dismissLabel: String = "Cancel",
) {
    val currentSelection = remember { mutableStateListOf<T>().apply { addAll(selectedItems) } }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = title,
                style = AppTheme.typography.titleLarge,
                color = AppTheme.colors.textPrimary,
            )
        },
        text = {
            LazyColumn {
                items(items.size) { index ->
                    val item = items[index]
                    val isSelected = currentSelection.contains(item)

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                if (isSelected) {
                                    currentSelection.remove(item)
                                } else {
                                    currentSelection.add(item)
                                }
                            }
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Checkbox(
                            checked = isSelected,
                            onCheckedChange = null,
                        )
                        Text(
                            text = itemText(item),
                            style = AppTheme.typography.bodyMedium,
                            color = AppTheme.colors.textPrimary,
                            modifier = Modifier.padding(start = 12.dp),
                        )
                    }
                }
            }
        },
        confirmButton = {
            TextButton(onClick = { onConfirm(currentSelection.toList()) }) {
                Text(confirmLabel, color = AppTheme.colors.primary)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(dismissLabel, color = AppTheme.colors.textSecondary)
            }
        },
        containerColor = AppTheme.colors.background,
    )
}
