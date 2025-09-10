package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.views.buttonDefault
import com.dezdeqness.ast.views.buttonOutlined
import com.dezdeqness.ast.views.buttonText
import com.dezdeqness.ast.views.chipDefault
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun App() {
    val viewBookState = remember {
        ViewBookState(
            listOf(chipDefault, buttonDefault, buttonOutlined, buttonText)
        )
    }

    val isDarkTheme by viewBookState.getIsDarkTheme()

    AppTheme(isDarkTheme = isDarkTheme) {
        ViewBook(
            viewBookState = viewBookState,
            isDarkTheme = isDarkTheme,
        )
    }
}
