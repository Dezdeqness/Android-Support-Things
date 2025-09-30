package com.dezdeqness.core.ui.views.toolbar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.dezdeqness.core.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: String = "",
    titleColor: Color = AppTheme.colors.textPrimary,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(containerColor = AppTheme.colors.background),
    navigationIcon: ImageVector? = Icons.AutoMirrored.Filled.ArrowBack,
    navigationColor: Color = AppTheme.colors.onSurface,
    navigationClick: () -> Unit = {},
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(
                title,
                color = titleColor,
            )
        },
        navigationIcon = {
            if (navigationIcon != null) {
                IconButton(onClick = navigationClick) {
                    Icon(
                        navigationIcon,
                        contentDescription = "Back button",
                        tint = navigationColor,
                    )
                }
            }
        },
        colors = colors,
        actions = actions,
        windowInsets = windowInsets,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppToolbar(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit,
    navigation: (@Composable () -> Unit)? = null,
    colors: TopAppBarColors = TopAppBarDefaults.topAppBarColors(containerColor = AppTheme.colors.background),
    windowInsets: WindowInsets = TopAppBarDefaults.windowInsets,
    actions: @Composable RowScope.() -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {
            title()
        },
        navigationIcon = {
            navigation?.invoke()
        },
        colors = colors,
        actions = actions,
        windowInsets = windowInsets,
    )
}
