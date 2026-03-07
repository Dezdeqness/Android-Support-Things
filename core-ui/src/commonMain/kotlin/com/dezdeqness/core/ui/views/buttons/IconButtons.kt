package com.dezdeqness.core.ui.views.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun AppIconFilledButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    contentColor: Color = AppTheme.colors.onPrimary,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        contentColor = contentColor,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconFilledButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    contentColor: Color = AppTheme.colors.onPrimary,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        contentColor = contentColor,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconOutlinedButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    borderStroke: BorderStroke = BorderStroke(1.dp, AppTheme.colors.secondary),
    contentColor: Color = AppTheme.colors.onPrimary,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        borderStroke = borderStroke,
        contentColor = contentColor,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconOutlinedButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    borderStroke: BorderStroke = BorderStroke(1.dp, AppTheme.colors.secondary),
    contentColor: Color = AppTheme.colors.onPrimary,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        borderStroke = borderStroke,
        contentColor = contentColor,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    onClick: () -> Unit,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        shape = shape,
        contentColor = null,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    icon: Painter,
    onClick: () -> Unit,
    enabled: Boolean = true,
    tint: Color = AppTheme.colors.onSurface,
    shape: Shape = CircleShape,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    contentDescription: String? = null,
) {
    AppIconButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        contentColor = null,
        contentPadding = contentPadding,
    ) {
        Icon(icon, contentDescription = contentDescription, tint = tint)
    }
}

@Composable
fun AppIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    borderStroke: BorderStroke = BorderStroke(0.dp, Color.Transparent),
    contentColor: Color? = null,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    content: @Composable () -> Unit,
) {
    val alpha = if (enabled) 1f else 0.38f
    val backgroundModifier = if (contentColor != null) {
        Modifier.background(contentColor.copy(alpha = alpha))
    } else {
        Modifier
    }
    Box(
        modifier = modifier
            .clip(shape)
            .border(border = borderStroke, shape = shape)
            .then(backgroundModifier)
            .then(
                if (enabled) {
                    Modifier.clickable(
                        onClick = onClick,
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(color = AppTheme.colors.ripple),
                    )
                } else {
                    Modifier
                }
            )
            .padding(contentPadding)
    ) {
        content()
    }
}
