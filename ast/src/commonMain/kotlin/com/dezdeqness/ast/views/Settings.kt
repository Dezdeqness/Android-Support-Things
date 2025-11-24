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
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.settings.HeaderSettingsView
import com.dezdeqness.core.ui.views.settings.ProgressSettingsView
import com.dezdeqness.core.ui.views.settings.SwitchSettingsView
import com.dezdeqness.core.ui.views.settings.TextSettingsView

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
