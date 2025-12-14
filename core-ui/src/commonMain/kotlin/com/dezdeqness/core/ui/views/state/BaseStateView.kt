package com.dezdeqness.core.ui.views.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BaseStateView(
    modifier: Modifier = Modifier,
    image: (@Composable () -> Unit),
    title: @Composable (() -> Unit),
    message: @Composable (() -> Unit)? = null,
    buttonsContent: (@Composable () -> Unit)? = null,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        image.invoke()
        title.invoke()
        message?.invoke()
        buttonsContent?.invoke()
    }
}
