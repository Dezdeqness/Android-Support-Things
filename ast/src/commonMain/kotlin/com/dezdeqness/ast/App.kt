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
import com.dezdeqness.ast.views.iconButtonDefault
import com.dezdeqness.ast.views.iconFilledButtonDefault
import com.dezdeqness.ast.views.iconOutlinedButtonDefault
import com.dezdeqness.ast.views.tileDefault
import com.dezdeqness.ast.views.tileFull
import com.dezdeqness.ast.views.tileNoShape
import com.dezdeqness.ast.views.tilePrefix
import com.dezdeqness.ast.views.tileSuffix
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun App() {
    val viewBookState = remember {
        ViewBookState(
            listOf(
                chipDefault,
                buttonDefault,
                buttonOutlined,
                buttonText,
                tileDefault,
                tilePrefix,
                tileSuffix,
                tileFull,
                tileNoShape,
                iconFilledButtonDefault,
                iconOutlinedButtonDefault,
                iconButtonDefault,
            )
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
