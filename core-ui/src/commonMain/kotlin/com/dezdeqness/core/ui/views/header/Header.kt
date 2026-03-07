package com.dezdeqness.core.ui.views.header

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.labelLarge.copy(fontSize = 20.sp),
    titleColor: Color = AppTheme.colors.textPrimary,
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
) {
    Header(
        modifier = modifier,
        title = title,
        titleStyle = titleStyle,
        titleColor = titleColor,
        contentColor = contentColor,
        contentPadding = contentPadding,
        onClick = null,
    )
}

@Composable
fun Header(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.labelLarge.copy(fontSize = 20.sp),
    titleColor: Color = AppTheme.colors.textPrimary,
    icon: ImageVector = Icons.AutoMirrored.Default.KeyboardArrowRight,
    iconContentDescription: String? = null,
    iconColor: Color = AppTheme.colors.onSurface,
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .background(contentColor)
            .clickable(
                enabled = onClick != null,
                onClick = onClick ?: {},
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = AppTheme.colors.ripple),
            )
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            title,
            style = titleStyle,
            modifier = Modifier.weight(1f),
            color = titleColor
        )

        if (onClick != null) {
            Icon(
                icon,
                contentDescription = iconContentDescription,
                tint = iconColor,
            )
        }
    }
}
