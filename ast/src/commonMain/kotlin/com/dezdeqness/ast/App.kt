package com.dezdeqness.ast

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import com.dezdeqness.ast.viewbook.core.ViewBook
import com.dezdeqness.ast.viewbook.core.ViewBookState
import com.dezdeqness.ast.views.appSectionDefault
import com.dezdeqness.ast.views.buttonDefault
import com.dezdeqness.ast.views.buttonOutlined
import com.dezdeqness.ast.views.buttonText
import com.dezdeqness.ast.views.chipDefault
import com.dezdeqness.ast.views.headerDefault
import com.dezdeqness.ast.views.headerIconLess
import com.dezdeqness.ast.views.headerSettingsColor
import com.dezdeqness.ast.views.headerSettingsDefault
import com.dezdeqness.ast.views.headerShaped
import com.dezdeqness.ast.views.iconButtonDefault
import com.dezdeqness.ast.views.iconFilledButtonDefault
import com.dezdeqness.ast.views.iconOutlinedButtonDefault
import com.dezdeqness.ast.views.progressSettingsDefault
import com.dezdeqness.ast.views.switchSettingsDefault
import com.dezdeqness.ast.views.switchSettingsDisabled
import com.dezdeqness.ast.views.switchSettingsFull
import com.dezdeqness.ast.views.textSettingsDefault
import com.dezdeqness.ast.views.textSettingsDisabled
import com.dezdeqness.ast.views.textSettingsFull
import com.dezdeqness.ast.views.textSettingsPrefix
import com.dezdeqness.ast.views.textSettingsSuffix
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
                textSettingsDefault,
                textSettingsDisabled,
                textSettingsPrefix,
                textSettingsSuffix,
                textSettingsFull,
                headerSettingsDefault,
                headerSettingsColor,
                switchSettingsDefault,
                switchSettingsDisabled,
                switchSettingsFull,
                progressSettingsDefault,
                appSectionDefault,
                headerDefault,
                headerIconLess,
                headerShaped,
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
