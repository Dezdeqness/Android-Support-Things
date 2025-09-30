package com.dezdeqness.core.ui.views.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun HeaderSettingsView(
    modifier: Modifier = Modifier,
    title: String
) {
    HeaderSettingsView(
        modifier = modifier,
        title = title,
        titleStyle = AppTheme.typography.titleMedium,
        titleColor = AppTheme.colors.textPrimary,
    )
}

@Composable
fun HeaderSettingsView(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    titleColor: Color = AppTheme.colors.textPrimary,
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
) {
    TextSettingsView(
        modifier = modifier,
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = titleStyle,
                color = titleColor,
            )
        },
        contentColor = contentColor,
        contentPadding = contentPadding,
    )
}
