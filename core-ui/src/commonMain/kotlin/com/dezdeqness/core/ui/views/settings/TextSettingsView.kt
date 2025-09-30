package com.dezdeqness.core.ui.views.settings

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

private const val SubTitleAlpha = 0.8f

@Composable
fun TextSettingsView(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String? = null,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    prefixIcon: (@Composable (Modifier) -> Unit)? = null,
    suffixIcon: (@Composable (Modifier) -> Unit)? = null,
) {
    BaseSettingsView(
        modifier = modifier,
        title = {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 2,
                style = AppTheme.typography.bodyLarge,
                color = AppTheme.colors.textPrimary,
            )
        },
        subTitle = if (!subtitle.isNullOrBlank()) {
            {
                Text(
                    text = subtitle,
                    modifier = Modifier.alpha(SubTitleAlpha),
                    style = AppTheme.typography.bodySmall,
                    color = AppTheme.colors.textPrimary,
                )
            }
        } else {
            null
        },
        enabled = enabled,
        onClick = if (enabled) onClick else null,
        contentColor = contentColor,
        contentPadding = contentPadding,
        prefixIcon = { iconModifier ->
            prefixIcon?.invoke(iconModifier)
        },
        suffixIcon = { iconModifier ->
            suffixIcon?.invoke(iconModifier)
        },
    )
}


@Composable
fun TextSettingsView(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    subtitle: (@Composable () -> Unit)? = null,
    onClick: (() -> Unit)? = null,
    enabled: Boolean = true,
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    prefixIcon: (@Composable (Modifier) -> Unit)? = null,
    suffixIcon: (@Composable (Modifier) -> Unit)? = null,
) {
    BaseSettingsView(
        modifier = modifier,
        title = {
            title()
        },
        subTitle = if (subtitle != null) {
            {
                subtitle.invoke()
            }
        } else {
            null
        },
        enabled = enabled,
        onClick = if (enabled) onClick else null,
        contentColor = contentColor,
        contentPadding = contentPadding,
        prefixIcon = { iconModifier ->
            prefixIcon?.invoke(iconModifier)
        },
        suffixIcon = { iconModifier ->
            suffixIcon?.invoke(iconModifier)
        },
    )
}

