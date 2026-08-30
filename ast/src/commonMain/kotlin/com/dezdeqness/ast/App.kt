package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun App(items: List<HierarchicalItem<ViewCase>>) {
    val viewBookState = remember { ViewBookState(items) }

    val isDarkTheme by viewBookState.getIsDarkTheme()

    AppTheme(isDarkTheme = false) {
        ViewBook(
            viewBookState = viewBookState,
            isDarkTheme = isDarkTheme,
        )
    }
}
