package com.dezdeqness.ast.viewbook.core.viewcase

import androidx.compose.runtime.Composable

data class ViewCase(
    val title: String,
    val content: @Composable ViewCase.() -> Unit,
)