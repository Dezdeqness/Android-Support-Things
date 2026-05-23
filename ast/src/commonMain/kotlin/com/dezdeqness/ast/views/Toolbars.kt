package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.toolbar.AppToolbar

private val titleColorOptions = listOf("Primary", "Secondary", "Accent", "Error")

@OptIn(ExperimentalMaterial3Api::class)
val toolbarDefault = ViewCase(
    title = "toolbarDefault",
    content = {
        val titleState = rememberViewCaseState("toolbar_title", "Screen Title")
        val widthState = rememberViewCaseState("toolbar_width", 400f)
        val showNavIconState = rememberViewCaseState("toolbar_nav_icon", true)
        val navIconTypeState = rememberViewCaseState("toolbar_nav_type", 0)
        val showActionsState = rememberViewCaseState("toolbar_actions", false)
        val titleColorState = rememberViewCaseState("toolbar_title_color", 0)

        val navIcon = if (showNavIconState.value) {
            when (navIconTypeState.value) {
                0 -> Icons.AutoMirrored.Filled.ArrowBack
                1 -> Icons.Filled.Close
                2 -> Icons.Filled.Menu
                else -> Icons.AutoMirrored.Filled.ArrowBack
            }
        } else null

        val titleColor = when (titleColorState.value) {
            0 -> AppTheme.colors.textPrimary
            1 -> AppTheme.colors.textSecondary
            2 -> AppTheme.colors.accent
            3 -> AppTheme.colors.error
            else -> AppTheme.colors.textPrimary
        }

        AppToolbar(
            modifier = Modifier.width(widthState.value.toInt().dp),
            title = titleState.value,
            titleColor = titleColor,
            navigationIcon = navIcon,
            actions = {
                if (showActionsState.value) {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Search, contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Share, contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.MoreVert, contentDescription = null)
                    }
                }
            },
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("toolbar_title", "Screen Title")
        val widthState = rememberViewCaseState("toolbar_width", 400f)
        val showNavIconState = rememberViewCaseState("toolbar_nav_icon", true)
        val navIconTypeState = rememberViewCaseState("toolbar_nav_type", 0)
        val showActionsState = rememberViewCaseState("toolbar_actions", false)
        val titleColorState = rememberViewCaseState("toolbar_title_color", 0)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 250f,
                max = 600f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Show Navigation Icon",
                value = showNavIconState.value,
                onChange = { showNavIconState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Navigation Icon",
                options = listOf("Arrow Back", "Close", "Menu"),
                selectedValue = navIconTypeState.value,
                onChange = { navIconTypeState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Show Actions",
                value = showActionsState.value,
                onChange = { showActionsState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Title Color",
                options = titleColorOptions,
                selectedValue = titleColorState.value,
                onChange = { titleColorState.value = it }
            ),
        )
    }
)
