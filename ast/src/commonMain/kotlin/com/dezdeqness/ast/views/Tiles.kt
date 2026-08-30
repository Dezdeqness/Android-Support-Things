@file:Folder("Tiles")

package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.tiles.AppTile

@ViewCaseEntry(name = "Tile Default")
val tileDefault = ViewCase(
    title = "tileDefault",
    content = {
        val textState = rememberViewCaseState("tile_text", "Action")
        val widthState = rememberViewCaseState("tile_width", 250f)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)
        val showPrefixState = rememberViewCaseState("tile_prefix", false)
        val showSuffixState = rememberViewCaseState("tile_suffix", false)
        
        AppTile(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            shape = if (cornerRadiusState.value > 0) RoundedCornerShape(cornerRadiusState.value.toInt().dp) else null,
            prefixTitle = if (showPrefixState.value) {
                { modifier ->
                    Icon(
                        Icons.Default.Settings,
                        modifier = modifier,
                        contentDescription = null,
                        tint = AppTheme.colors.textPrimary,
                    )
                }
            } else null,
            suffixTitle = if (showSuffixState.value) {
                { modifier ->
                    Icon(
                        Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        modifier = modifier,
                        contentDescription = null,
                        tint = AppTheme.colors.textPrimary,
                    )
                }
            } else null,
            onClick = {},
        )
    },
    parameters = {
        val textState = rememberViewCaseState("tile_text", "Action")
        val widthState = rememberViewCaseState("tile_width", 250f)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)
        val showPrefixState = rememberViewCaseState("tile_prefix", false)
        val showSuffixState = rememberViewCaseState("tile_suffix", false)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 4f,
                onChange = { cornerRadiusState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Show Prefix Icon",
                value = showPrefixState.value,
                onChange = { showPrefixState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Show Suffix Icon",
                value = showSuffixState.value,
                onChange = { showSuffixState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Tile Prefix")
val tilePrefix = ViewCase(
    title = "tilePrefix",
    content = {
        val textState = rememberViewCaseState("tile_prefix_text", "Action")
        val widthState = rememberViewCaseState("tile_prefix_width", 250f)

        AppTile(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            shape = RoundedCornerShape(12.dp),
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
    },
    parameters = {
        val textState = rememberViewCaseState("tile_prefix_text", "Action")
        val widthState = rememberViewCaseState("tile_prefix_width", 250f)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Tile Suffix")
val tileSuffix = ViewCase(
    title = "tileSuffix",
    content = {
        val textState = rememberViewCaseState("tile_suffix_text", "Action")
        val widthState = rememberViewCaseState("tile_suffix_width", 250f)

        AppTile(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            shape = RoundedCornerShape(12.dp),
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
    },
    parameters = {
        val textState = rememberViewCaseState("tile_suffix_text", "Action")
        val widthState = rememberViewCaseState("tile_suffix_width", 250f)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Tile Full")
val tileFull = ViewCase(
    title = "tileFull",
    content = {
        val textState = rememberViewCaseState("tile_full_text", "Action")
        val widthState = rememberViewCaseState("tile_full_width", 250f)

        AppTile(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            shape = RoundedCornerShape(12.dp),
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
    },
    parameters = {
        val textState = rememberViewCaseState("tile_full_text", "Action")
        val widthState = rememberViewCaseState("tile_full_width", 250f)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Tile No Shape")
val tileNoShape = ViewCase(
    title = "tileNoShape",
    content = {
        val textState = rememberViewCaseState("tile_no_shape_text", "Action")
        val widthState = rememberViewCaseState("tile_no_shape_width", 250f)

        AppTile(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            shape = null,
            onClick = {},
        )
    },
    parameters = {
        val textState = rememberViewCaseState("tile_no_shape_text", "Action")
        val widthState = rememberViewCaseState("tile_no_shape_width", 250f)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            )
        )
    }
)

