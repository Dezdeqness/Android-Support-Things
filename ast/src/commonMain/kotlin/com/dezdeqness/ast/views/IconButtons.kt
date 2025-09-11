package com.dezdeqness.ast.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.views.buttons.AppIconButton
import com.dezdeqness.core.ui.views.buttons.AppIconFilledButton
import com.dezdeqness.core.ui.views.buttons.AppOutlinedButton

val iconFilledButtonDefault = ViewCase(
    title = "iconFilledButtonDefault",
    content = {
        AppIconFilledButton(
            icon = Icons.Default.Settings,
            onClick = {},
        )
    }
)

val iconOutlinedButtonDefault = ViewCase(
    title = "iconOutlinedButtonDefault",
    content = {
        AppOutlinedButton(
            icon = Icons.Default.Settings,
            onClick = {},
        )
    }
)

val iconButtonDefault = ViewCase(
    title = "iconButtonDefault",
    content = {
        AppIconButton(
            icon = Icons.Default.Settings,
            onClick = {},
        )
    }
)
