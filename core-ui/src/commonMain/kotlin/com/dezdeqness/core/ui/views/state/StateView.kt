package com.dezdeqness.core.ui.views.state

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun StateView(
    modifier: Modifier = Modifier,
    title: String,
    message: String? = null,
    image: @Composable () -> Unit,
    buttons: List<StateButtonConfig>,
    spacing: Dp = 16.dp,
) {
    StateView(
        modifier = modifier,
        title = title,
        image = image,
        message = message,
        buttonsContent = buttons
            .takeIf { it.isNotEmpty() }
            ?.let { list ->
                { StateButtonsRow(buttons = list) }
            },
        spacing = spacing,
    )
}

@Composable
fun StateView(
    modifier: Modifier = Modifier,
    title: String,
    message: String? = null,
    image: @Composable () -> Unit,
    buttonsContent: (@Composable () -> Unit)? = null,
    spacing: Dp = 16.dp,
) {
    BaseStateView(
        modifier = modifier,
        image = image,
        title = {
            Text(
                text = title,
                style = AppTheme.typography.titleLarge,
                color = AppTheme.colors.textPrimary,
                textAlign = TextAlign.Center,
            )
        },
        message = message
            ?.takeIf { it.isNotEmpty() }
            ?.let {
                {
                    Text(
                        text = it,
                        style = AppTheme.typography.bodyMedium,
                        color = AppTheme.colors.textSecondary,
                        textAlign = TextAlign.Center,
                    )
                }
            },
        buttonsContent = buttonsContent,
        spacing = spacing,
    )
}
