package com.dezdeqness.core.ui.views.bottomsheet

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.core.DialogContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <T> SingleChoiceBottomSheet(
    modifier: Modifier = Modifier,
    state: SheetState,
    title: String? = null,
    selectedValue: T,
    valueText: @Composable (T) -> String,
    values: List<T>,
    onValueSelected: (T) -> Unit,
    contentColor: Color = AppTheme.colors.background,
    onDismiss: () -> Unit,
) {
    ModalBottomSheet(
        sheetState = state,
        onDismissRequest = onDismiss,
        containerColor = contentColor,
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
