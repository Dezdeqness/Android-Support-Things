package com.dezdeqness.core.ui.views.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.buttons.AppButton
import com.dezdeqness.core.ui.views.buttons.AppOutlinedButton
import com.dezdeqness.core.ui.views.buttons.AppTextButton

@Composable
fun StateButtonsRow(
    modifier: Modifier = Modifier,
    buttons: List<StateButtonConfig>,
    horizontalArrangement: Arrangement.Horizontal = Arrangement.spacedBy(12.dp),
) {
    Row(
        modifier = modifier,
        horizontalArrangement = horizontalArrangement,
    ) {
        buttons.forEach { config ->
            when (config.style) {
                StateButtonStyle.Primary -> {
                    AppButton(
                        modifier = config.modifier,
                        title = config.title,
                        titleStyle = AppTheme.typography.titleMedium,
                        onClick = config.onClick,
                    )
                }

                StateButtonStyle.Secondary -> {
                    AppOutlinedButton(
                        modifier = config.modifier,
                        title = config.title,
                        titleStyle = AppTheme.typography.titleMedium,
                        onClick = config.onClick,
                    )
                }

                StateButtonStyle.Text -> {
                    AppTextButton(
                        modifier = config.modifier,
                        title = config.title,
                        titleStyle = AppTheme.typography.titleMedium,
                        onClick = config.onClick,
                    )
                }
            }
        }
    }
}

enum class StateButtonStyle {
    Primary,
    Secondary,
    Text,
}

data class StateButtonConfig(
    val title: String,
    val onClick: () -> Unit,
    val style: StateButtonStyle = StateButtonStyle.Primary,
    val modifier: Modifier = Modifier,
)
