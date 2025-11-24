package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.views.appSectionDefault
import com.dezdeqness.ast.views.buttonDefault
import com.dezdeqness.ast.views.chipDefault
import com.dezdeqness.ast.views.headerDefault
import com.dezdeqness.ast.views.headerSettingsDefault
import com.dezdeqness.ast.views.iconButtonDefault
import com.dezdeqness.ast.views.progressSettingsDefault
import com.dezdeqness.ast.views.singleChoiceBottomSheetDefault
import com.dezdeqness.ast.views.singleChoiceDialogDefault
import com.dezdeqness.ast.views.switchSettingsDefault
import com.dezdeqness.ast.views.textSettingsDefault
import com.dezdeqness.ast.views.tileDefault
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun App() {
    val viewBookState = remember {
        ViewBookState(
            listOf(
                chipDefault,
                buttonDefault,
                iconButtonDefault,
                tileDefault,
                headerDefault,
                textSettingsDefault,
                headerSettingsDefault,
                switchSettingsDefault,
                progressSettingsDefault,
                appSectionDefault,
                singleChoiceDialogDefault,
                singleChoiceBottomSheetDefault,
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
