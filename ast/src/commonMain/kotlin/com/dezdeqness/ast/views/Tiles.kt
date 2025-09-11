package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.tiles.AppTile

val tileDefault = ViewCase(
    title = "tileDefault",
    content = {
        AppTile(
            modifier = Modifier.width(250.dp),
            text = "Action",
            onClick = {},
        )
    }
)

val tilePrefix = ViewCase(
    title = "tilePrefix",
    content = {
        AppTile(
            modifier = Modifier.width(250.dp),
            text = "Action",
            prefixTitle = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            onClick = {},
        )
    }
)

val tileSuffix = ViewCase(
    title = "tileSuffix",
    content = {
        AppTile(
            modifier = Modifier.width(250.dp),
            text = "Action",
            suffixTitle = { modifier ->
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            onClick = {},
        )
    }
)

val tileFull = ViewCase(
    title = "tileFull",
    content = {
        AppTile(
            modifier = Modifier.width(250.dp),
            text = "Action",
            prefixTitle = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            suffixTitle = { modifier ->
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            onClick = {},
        )
    }
)

val tileNoShape = ViewCase(
    title = "tileNoShape",
    content = {
        AppTile(
            modifier = Modifier.width(250.dp),
            text = "Action",
            shape = null,
            prefixTitle = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            suffixTitle = { modifier ->
                Icon(
                    Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            onClick = {},
        )
    }
)

