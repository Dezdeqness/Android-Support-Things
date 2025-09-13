package com.dezdeqness.core.ui.views.dialogs

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.core.DialogContent

@Composable
fun <T> SingleChoiceDialog(
    modifier: Modifier = Modifier,
    title: String? = null,
    selectedValue: T,
    valueText: @Composable (T) -> String,
    values: List<T>,
    onValueSelected: (T) -> Unit,
    contentColor: Color = AppTheme.colors.background,
    onDismiss: () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismiss,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Surface(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
            color = contentColor,
        ) {
            DialogContent(
                title = title,
                selectedValue = selectedValue,
                valueText = valueText,
                values = values,
                onValueSelected = onValueSelected,
                contentColor = contentColor,
            )
        }
    }
}
