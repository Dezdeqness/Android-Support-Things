package com.dezdeqness.core.ui.views.settings

import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun SwitchSettingsView(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    enabled: Boolean = true,
    prefixIcon: (@Composable (Modifier) -> Unit)? = null,
    checked: Boolean = false,
    contentColor: Color = AppTheme.colors.background,
    onCheckedChanged: (Boolean) -> Unit,
) {
    TextSettingsView(
        modifier = modifier,
        title = title,
        subtitle = subtitle,
        onClick = { onCheckedChanged(!checked) },
        enabled = enabled,
        contentColor = contentColor,
        prefixIcon = prefixIcon,
        suffixIcon = {
            Switch(
                checked = checked,
                onCheckedChange = null,
            )
        },
    )
}
