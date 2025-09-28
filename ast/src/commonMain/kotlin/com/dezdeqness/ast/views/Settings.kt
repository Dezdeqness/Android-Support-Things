package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.settings.HeaderSettingsView
import com.dezdeqness.core.ui.views.settings.ProgressSettingsView
import com.dezdeqness.core.ui.views.settings.SwitchSettingsView
import com.dezdeqness.core.ui.views.settings.TextSettingsView

val textSettingsDefault = ViewCase(
    title = "textSettingsDefault",
    content = {
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Choose theme",
            onClick = {},
        )
    }
)

val textSettingsDisabled = ViewCase(
    title = "textSettingsDisabled",
    content = {
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            enabled = false,
            title = "Choose theme",
            onClick = {},
        )
    }
)

val textSettingsPrefix = ViewCase(
    title = "textSettingsPrefix",
    content = {
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Choose theme",
            prefixIcon = { modifier ->
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

val textSettingsSuffix = ViewCase(
    title = "textSettingsSuffix",
    content = {
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Choose theme",
            suffixIcon = { modifier ->
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

val textSettingsFull = ViewCase(
    title = "textSettingsFull",
    content = {
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Choose theme",
            subtitle = "Between light or dark",
            prefixIcon = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            suffixIcon = { modifier ->
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

val headerSettingsDefault = ViewCase(
    title = "headerSettingsDefault",
    content = {
        HeaderSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Settings",
        )
    }
)

val headerSettingsColor = ViewCase(
    title = "headerSettingsColor",
    content = {
        HeaderSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Settings",
            titleColor = AppTheme.colors.primary,
        )
    }
)

val switchSettingsDefault = ViewCase(
    title = "switchSettingsDefault",
    content = {
        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Animations",
            prefixIcon = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            checked = false,
            onCheckedChanged = {

            },
        )
    }
)

val switchSettingsDisabled = ViewCase(
    title = "switchSettingsDisabled",
    content = {
        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Animations",
            subtitle = "It can cause poor performance",
            enabled = false,
            prefixIcon = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            checked = true,
            onCheckedChanged = {

            },
        )
    }
)

val switchSettingsFull = ViewCase(
    title = "switchSettingsFull",
    content = {
        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Animations",
            subtitle = "It can cause poor performance",
            prefixIcon = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            checked = true,
            onCheckedChanged = {

            },
        )
    }
)

val progressSettingsDefault = ViewCase(
    title = "progressSettingsDefault",
    content = {
        ProgressSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Cache size",
            subtitle = "128 out 256",
            progress = 0.5f,
        )
    }
)
