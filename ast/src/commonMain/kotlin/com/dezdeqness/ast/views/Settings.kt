@file:Folder("Settings")

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
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.settings.HeaderSettingsView
import com.dezdeqness.core.ui.views.settings.ProgressSettingsView
import com.dezdeqness.core.ui.views.settings.SwitchSettingsView
import com.dezdeqness.core.ui.views.settings.TextSettingsView

@ViewCaseEntry(name = "Text Settings Default", path = ["Text Settings"])
val textSettingsDefault = ViewCase(
    title = "textSettingsDefault",
    content = {
        val titleState = rememberViewCaseState("text_set_title", "Choose theme")
        val subtitleState = rememberViewCaseState("text_set_subtitle", "")
        val enabledState = rememberViewCaseState("text_set_enabled", true)
        val showPrefixState = rememberViewCaseState("text_set_prefix", false)
        val showSuffixState = rememberViewCaseState("text_set_suffix", false)
        
        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = subtitleState.value.ifBlank { null },
            enabled = enabledState.value,
            prefixIcon = if (showPrefixState.value) {
                { modifier ->
                    Icon(
                        Icons.Default.Settings,
                        modifier = modifier,
                        contentDescription = null,
                        tint = AppTheme.colors.textPrimary,
                    )
                }
            } else null,
            suffixIcon = if (showSuffixState.value) {
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
        val titleState = rememberViewCaseState("text_set_title", "Choose theme")
        val subtitleState = rememberViewCaseState("text_set_subtitle", "")
        val enabledState = rememberViewCaseState("text_set_enabled", true)
        val showPrefixState = rememberViewCaseState("text_set_prefix", false)
        val showSuffixState = rememberViewCaseState("text_set_suffix", false)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Subtitle",
                value = subtitleState.value,
                onChange = { subtitleState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
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

@ViewCaseEntry(name = "Header Settings Default", path = ["Header Settings"])
val headerSettingsDefault = ViewCase(
    title = "headerSettingsDefault",
    content = {
        val titleState = rememberViewCaseState("hdr_set_title", "Settings")
        val colorState = rememberViewCaseState("hdr_set_color", "#FF6200EE")
        val useCustomColorState = rememberViewCaseState("hdr_set_custom", false)

        HeaderSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            titleColor = if (useCustomColorState.value) {
                parseHexColor(colorState.value)
            } else {
                AppTheme.colors.textPrimary
            }
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("hdr_set_title", "Settings")
        val colorState = rememberViewCaseState("hdr_set_color", "#FF6200EE")
        val useCustomColorState = rememberViewCaseState("hdr_set_custom", false)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Custom Color",
                value = useCustomColorState.value,
                onChange = { useCustomColorState.value = it }
            ),
            ViewParameter.ColorParameter(
                label = "Title Color",
                value = colorState.value,
                onChange = { colorState.value = it }
            )
        )
    }
)

private fun parseHexColor(hex: String): androidx.compose.ui.graphics.Color {
    return try {
        val cleanHex = hex.removePrefix("#")
        when (cleanHex.length) {
            6 -> {
                val r = cleanHex.substring(0, 2).toInt(16)
                val g = cleanHex.substring(2, 4).toInt(16)
                val b = cleanHex.substring(4, 6).toInt(16)
                androidx.compose.ui.graphics.Color(r, g, b)
            }

            8 -> {
                val a = cleanHex.substring(0, 2).toInt(16)
                val r = cleanHex.substring(2, 4).toInt(16)
                val g = cleanHex.substring(4, 6).toInt(16)
                val b = cleanHex.substring(6, 8).toInt(16)
                androidx.compose.ui.graphics.Color(r, g, b, a)
            }

            else -> androidx.compose.ui.graphics.Color.Magenta
        }
    } catch (e: Exception) {
        androidx.compose.ui.graphics.Color.Magenta
    }
}

@ViewCaseEntry(name = "Switch Settings Default", path = ["Switch Settings"])
val switchSettingsDefault = ViewCase(
    title = "switchSettingsDefault",
    content = {
        val titleState = rememberViewCaseState("sw_set_title", "Animations")
        val subtitleState = rememberViewCaseState("sw_set_subtitle", "")
        val checkedState = rememberViewCaseState("sw_set_checked", false)
        val enabledState = rememberViewCaseState("sw_set_enabled", true)
        val showPrefixState = rememberViewCaseState("sw_set_prefix", true)
        
        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = subtitleState.value.ifBlank { null },
            prefixIcon = if (showPrefixState.value) {
                { modifier ->
                    Icon(
                        Icons.Default.Settings,
                        modifier = modifier,
                        contentDescription = null,
                        tint = AppTheme.colors.textPrimary,
                    )
                }
            } else null,
            checked = checkedState.value,
            enabled = enabledState.value,
            onCheckedChanged = {
                checkedState.value = it
            },
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("sw_set_title", "Animations")
        val subtitleState = rememberViewCaseState("sw_set_subtitle", "")
        val checkedState = rememberViewCaseState("sw_set_checked", false)
        val enabledState = rememberViewCaseState("sw_set_enabled", true)
        val showPrefixState = rememberViewCaseState("sw_set_prefix", true)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Subtitle",
                value = subtitleState.value,
                onChange = { subtitleState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Show Prefix Icon",
                value = showPrefixState.value,
                onChange = { showPrefixState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Checked",
                value = checkedState.value,
                onChange = { checkedState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Progress Settings Default")
val progressSettingsDefault = ViewCase(
    title = "progressSettingsDefault",
    content = {
        val progressState = rememberViewCaseState("prog_set_value", 0.5f)

        val current = (progressState.value * 256).toInt()
        ProgressSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = "Cache size",
            subtitle = "$current out 256",
            progress = progressState.value,
        )
    },
    parameters = {
        val progressState = rememberViewCaseState("prog_set_value", 0.5f)

        listOf(
            ViewParameter.FloatParameter(
                label = "Progress",
                value = progressState.value,
                min = 0f,
                max = 1f,
                onChange = { progressState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Text Settings Disabled", path = ["Text Settings"])
val textSettingsDisabled = ViewCase(
    title = "textSettingsDisabled",
    content = {
        val titleState = rememberViewCaseState("text_set_dis_title", "Choose theme")

        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = null,
            enabled = false,
            onClick = {},
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("text_set_dis_title", "Choose theme")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Text Settings Prefix", path = ["Text Settings"])
val textSettingsPrefix = ViewCase(
    title = "textSettingsPrefix",
    content = {
        val titleState = rememberViewCaseState("text_set_pre_title", "Choose theme")

        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = null,
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
    },
    parameters = {
        val titleState = rememberViewCaseState("text_set_pre_title", "Choose theme")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Text Settings Suffix", path = ["Text Settings"])
val textSettingsSuffix = ViewCase(
    title = "textSettingsSuffix",
    content = {
        val titleState = rememberViewCaseState("text_set_suf_title", "Choose theme")

        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = null,
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
    },
    parameters = {
        val titleState = rememberViewCaseState("text_set_suf_title", "Choose theme")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Text Settings Full", path = ["Text Settings"])
val textSettingsFull = ViewCase(
    title = "textSettingsFull",
    content = {
        val titleState = rememberViewCaseState("text_set_full_title", "Choose theme")
        val subtitleState = rememberViewCaseState("text_set_full_subtitle", "Dark mode")

        TextSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = subtitleState.value,
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
    },
    parameters = {
        val titleState = rememberViewCaseState("text_set_full_title", "Choose theme")
        val subtitleState = rememberViewCaseState("text_set_full_subtitle", "Dark mode")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Subtitle",
                value = subtitleState.value,
                onChange = { subtitleState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Header Settings Color", path = ["Header Settings"])
val headerSettingsColor = ViewCase(
    title = "headerSettingsColor",
    content = {
        val titleState = rememberViewCaseState("hdr_set_col_title", "Settings")
        val colorState = rememberViewCaseState("hdr_set_col_color", "#FFFF5722")

        HeaderSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            titleColor = parseHexColor(colorState.value)
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("hdr_set_col_title", "Settings")
        val colorState = rememberViewCaseState("hdr_set_col_color", "#FFFF5722")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.ColorParameter(
                label = "Title Color",
                value = colorState.value,
                onChange = { colorState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Switch Settings Disabled", path = ["Switch Settings"])
val switchSettingsDisabled = ViewCase(
    title = "switchSettingsDisabled",
    content = {
        val titleState = rememberViewCaseState("sw_set_dis_title", "Animations")
        val checkedState = rememberViewCaseState("sw_set_dis_checked", false)

        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = null,
            checked = checkedState.value,
            enabled = false,
            onCheckedChanged = {
                checkedState.value = it
            },
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("sw_set_dis_title", "Animations")
        val checkedState = rememberViewCaseState("sw_set_dis_checked", false)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Checked",
                value = checkedState.value,
                onChange = { checkedState.value = it }
            )
        )
    }
)

@ViewCaseEntry(name = "Switch Settings Full", path = ["Switch Settings"])
val switchSettingsFull = ViewCase(
    title = "switchSettingsFull",
    content = {
        val titleState = rememberViewCaseState("sw_set_full_title", "Animations")
        val subtitleState =
            rememberViewCaseState("sw_set_full_subtitle", "Enable smooth animations")
        val checkedState = rememberViewCaseState("sw_set_full_checked", true)

        SwitchSettingsView(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            title = titleState.value,
            subtitle = subtitleState.value,
            prefixIcon = { modifier ->
                Icon(
                    Icons.Default.Settings,
                    modifier = modifier,
                    contentDescription = null,
                    tint = AppTheme.colors.textPrimary,
                )
            },
            checked = checkedState.value,
            enabled = true,
            onCheckedChanged = {
                checkedState.value = it
            },
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("sw_set_full_title", "Animations")
        val subtitleState =
            rememberViewCaseState("sw_set_full_subtitle", "Enable smooth animations")
        val checkedState = rememberViewCaseState("sw_set_full_checked", true)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Subtitle",
                value = subtitleState.value,
                onChange = { subtitleState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Checked",
                value = checkedState.value,
                onChange = { checkedState.value = it }
            )
        )
    }
)
