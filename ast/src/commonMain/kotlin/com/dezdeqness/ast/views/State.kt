package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.state.StateButtonConfig
import com.dezdeqness.core.ui.views.state.StateButtonStyle
import com.dezdeqness.core.ui.views.state.StateView

val errorStateDefault = ViewCase(
    title = "errorStateDefault",
    content = {
        val titleState = rememberViewCaseState(
            "err_title",
            "Failed to load this section.",
        )
        val messageState = rememberViewCaseState(
            "err_message",
            "Looks like there is some problem from our end, please reload and try again.",
        )
        val showHomeState = rememberViewCaseState("err_show_home", true)
        val showReloadState = rememberViewCaseState("err_show_reload", true)

        StateView(
            modifier = Modifier
                .width(420.dp)
                .clip(RoundedCornerShape(24.dp)),
            title = titleState.value,
            message = messageState.value.ifBlank { null },
            image = {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = null,
                    tint = AppTheme.colors.accent,
                    modifier = Modifier.width(96.dp),
                )
            },
            buttons = buildList {
                if (showHomeState.value) {
                    add(
                        StateButtonConfig(
                            title = "Open Home",
                            style = StateButtonStyle.Secondary,
                            onClick = {},
                        )
                    )
                }
                if (showReloadState.value) {
                    add(
                        StateButtonConfig(
                            title = "Reload",
                            style = StateButtonStyle.Primary,
                            onClick = {},
                        )
                    )
                }
            },
        )
    },
    parameters = {
        val titleState = rememberViewCaseState(
            "err_title",
            "Failed to load this section.",
        )
        val messageState = rememberViewCaseState(
            "err_message",
            "Looks like there is some problem from our end, please reload and try again.",
        )
        val showHomeState = rememberViewCaseState("err_show_home", true)
        val showReloadState = rememberViewCaseState("err_show_reload", true)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it },
            ),
            ViewParameter.StringParameter(
                label = "Message",
                value = messageState.value,
                onChange = { messageState.value = it },
            ),
            ViewParameter.BooleanParameter(
                label = "Show Home button",
                value = showHomeState.value,
                onChange = { showHomeState.value = it },
            ),
            ViewParameter.BooleanParameter(
                label = "Show Reload button",
                value = showReloadState.value,
                onChange = { showReloadState.value = it },
            ),
        )
    },
)

val emptyStateDefault = ViewCase(
    title = "emptyStateDefault",
    content = {
        val titleState = rememberViewCaseState("empty_title", "Inbox empty")
        val messageState = rememberViewCaseState(
            "empty_message",
            "You have no messages yet. Be the first to start a conversation.",
        )
        val buttonTitleState = rememberViewCaseState("empty_btn_title", "Go back")

        StateView(
            modifier = Modifier
                .width(420.dp)
                .clip(RoundedCornerShape(24.dp)),
            title = titleState.value,
            message = messageState.value.ifBlank { null },
            image = {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                    tint = AppTheme.colors.accent,
                    modifier = Modifier.width(96.dp),
                )
            },
            buttons = listOf(
                StateButtonConfig(
                    title = buttonTitleState.value,
                    style = StateButtonStyle.Primary,
                    onClick = {},
                ),
            ),
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("empty_title", "Inbox empty")
        val messageState = rememberViewCaseState(
            "empty_message",
            "You have no messages yet. Be the first to start a conversation.",
        )
        val buttonTitleState = rememberViewCaseState("empty_btn_title", "Go back")

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it },
            ),
            ViewParameter.StringParameter(
                label = "Message",
                value = messageState.value,
                onChange = { messageState.value = it },
            ),
            ViewParameter.StringParameter(
                label = "Button title",
                value = buttonTitleState.value,
                onChange = { buttonTitleState.value = it },
            ),
        )
    },
)