package com.dezdeqness.ast.viewbook.core

import androidx.compose.runtime.mutableStateOf
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase

data class ViewBookState(val viewCases: List<ViewCase>) {
    private var isDarkTheme = mutableStateOf(false)

    fun getIsDarkTheme() = isDarkTheme

    fun switchTheme() {
        this.isDarkTheme.value = !this.isDarkTheme.value
    }
}
