package com.dezdeqness.core.ui.views.state

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BaseStateView(
    modifier: Modifier = Modifier,
    image: (@Composable () -> Unit),
    title: @Composable (() -> Unit),
    message: @Composable (() -> Unit)? = null,
    buttonsContent: (@Composable () -> Unit)? = null,
    spacing: Dp = 16.dp,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(spacing)
    ) {
        image.invoke()
        title.invoke()
        message?.invoke()
        buttonsContent?.invoke()
    }
}
