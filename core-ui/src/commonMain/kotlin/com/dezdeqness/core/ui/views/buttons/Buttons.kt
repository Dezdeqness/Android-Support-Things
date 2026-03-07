package com.dezdeqness.core.ui.views.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

private val LoadingIndicatorSize = 20.dp
private val LoadingIndicatorStrokeWidth = 2.dp
private val IconSpacing = 8.dp

@Composable
fun AppPrimaryButton(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    loadingContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled && !isLoading,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
    ) {
        ButtonContent(
            title = title,
            titleStyle = titleStyle,
            isLoading = isLoading,
            indicatorColor = colors.onPrimary,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            loadingContent = loadingContent,
        )
    }
}

@Composable
fun AppPrimaryButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.primary,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
        content = content,
    )
}

@Composable
fun AppSecondaryButton(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    loadingContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    val colors = AppTheme.colors
    OutlinedButton(
        shape = shape,
        modifier = modifier,
        enabled = enabled && !isLoading,
        contentPadding = contentPadding,
        border = BorderStroke(
            1.dp,
            if (enabled && !isLoading) colors.onSurface else colors.onSurface.copy(alpha = 0.12f)
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.onSurface,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
    ) {
        ButtonContent(
            title = title,
            titleStyle = titleStyle,
            isLoading = isLoading,
            indicatorColor = colors.onSurface,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            loadingContent = loadingContent,
        )
    }
}

@Composable
fun AppSecondaryButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val colors = AppTheme.colors
    OutlinedButton(
        shape = shape,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        border = BorderStroke(
            1.dp,
            if (enabled) colors.onSurface else colors.onSurface.copy(alpha = 0.12f)
        ),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.onSurface,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
        content = content,
    )
}

@Composable
fun AppTextButton(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    loadingContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    val colors = AppTheme.colors
    TextButton(
        shape = shape,
        modifier = modifier,
        enabled = enabled && !isLoading,
        contentPadding = contentPadding,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
    ) {
        ButtonContent(
            title = title,
            titleStyle = titleStyle,
            isLoading = isLoading,
            indicatorColor = colors.primary,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            loadingContent = loadingContent,
        )
    }
}

@Composable
fun AppTextButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val colors = AppTheme.colors
    TextButton(
        shape = shape,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.textButtonColors(
            containerColor = Color.Transparent,
            contentColor = colors.primary,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
        content = content,
    )
}

@Composable
fun AppAccentButton(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    loadingContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled && !isLoading,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.accent,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
    ) {
        ButtonContent(
            title = title,
            titleStyle = titleStyle,
            isLoading = isLoading,
            indicatorColor = colors.onPrimary,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            loadingContent = loadingContent,
        )
    }
}

@Composable
fun AppAccentButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.accent,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
        content = content,
    )
}

@Composable
fun AppErrorButton(
    modifier: Modifier = Modifier,
    title: String,
    titleStyle: TextStyle = AppTheme.typography.titleMedium,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    loadingContent: @Composable (() -> Unit)? = null,
    onClick: () -> Unit = {},
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled && !isLoading,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.error,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
    ) {
        ButtonContent(
            title = title,
            titleStyle = titleStyle,
            isLoading = isLoading,
            indicatorColor = colors.onPrimary,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            loadingContent = loadingContent,
        )
    }
}

@Composable
fun AppErrorButton(
    modifier: Modifier = Modifier,
    shape: Shape = AppTheme.shapes.medium,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    onClick: () -> Unit = {},
    content: @Composable RowScope.() -> Unit,
) {
    val colors = AppTheme.colors
    Button(
        shape = shape,
        modifier = modifier,
        enabled = enabled,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.error,
            contentColor = colors.onPrimary,
            disabledContainerColor = colors.onSurface.copy(alpha = 0.12f),
            disabledContentColor = colors.onSurface.copy(alpha = 0.38f),
        ),
        onClick = onClick,
        content = content,
    )
}

@Composable
private fun ButtonContent(
    title: String,
    titleStyle: TextStyle,
    isLoading: Boolean,
    indicatorColor: Color,
    leadingIcon: @Composable (() -> Unit)?,
    trailingIcon: @Composable (() -> Unit)?,
    loadingContent: @Composable (() -> Unit)?,
) {
    Box(contentAlignment = Alignment.Center) {
        if (isLoading) {
            if (loadingContent != null) {
                loadingContent()
            } else {
                CircularProgressIndicator(
                    modifier = Modifier.size(LoadingIndicatorSize),
                    color = indicatorColor,
                    strokeWidth = LoadingIndicatorStrokeWidth,
                )
            }
        }
        Row(
            modifier = Modifier.alpha(if (isLoading) 0f else 1f),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (leadingIcon != null) {
                leadingIcon()
                Spacer(modifier = Modifier.width(IconSpacing))
            }
            Text(
                text = title,
                style = titleStyle,
            )
            if (trailingIcon != null) {
                Spacer(modifier = Modifier.width(IconSpacing))
                trailingIcon()
            }
        }
    }
}
