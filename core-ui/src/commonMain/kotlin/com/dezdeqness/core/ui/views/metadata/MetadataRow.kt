package com.dezdeqness.core.ui.views.metadata

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun MetadataRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
    labelColor: Color = AppTheme.colors.textSecondary,
    valueColor: Color = AppTheme.colors.textPrimary,
    labelStyle: TextStyle = TextStyle(fontSize = 14.sp),
    valueStyle: TextStyle = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            label,
            style = labelStyle,
            color = labelColor,
            modifier = Modifier.weight(1f),
        )
        Text(
            value,
            style = valueStyle,
            color = valueColor,
        )
    }
}
