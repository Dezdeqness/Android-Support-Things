package com.dezdeqness.ast.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.buttons.AppIconButton
import com.dezdeqness.core.ui.views.buttons.AppIconFilledButton
import com.dezdeqness.core.ui.views.buttons.AppOutlinedButton

val iconButtonDefault = ViewCase(
    title = "iconButtonDefault",
    content = {
        val buttonTypeState = rememberViewCaseState("icon_btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 50f)

        when (buttonTypeState.value) {
            0 -> AppIconFilledButton(
                icon = Icons.Default.Settings,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {},
            )

            1 -> AppOutlinedButton(
                icon = Icons.Default.Settings,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {},
            )

            2 -> AppIconButton(
                icon = Icons.Default.Settings,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {},
            )
        }
    },
    parameters = {
        val buttonTypeState = rememberViewCaseState("icon_btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)

        listOf(
            ViewParameter.ChoiceParameter(
                label = "Button Style",
                options = listOf("Filled", "Outlined", "Standard"),
                selectedIndex = buttonTypeState.value,
                onChange = { buttonTypeState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 50f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)

val iconFilledButtonDefault = ViewCase(
    title = "iconFilledButtonDefault",
    content = {
        val cornerRadiusState = rememberViewCaseState("icon_filled_corner", 50f)

        AppIconFilledButton(
            icon = Icons.Default.Settings,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            onClick = {},
        )
    },
    parameters = {
        val cornerRadiusState = rememberViewCaseState("icon_filled_corner", 50f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 50f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)

val iconOutlinedButtonDefault = ViewCase(
    title = "iconOutlinedButtonDefault",
    content = {
        val cornerRadiusState = rememberViewCaseState("icon_outlined_corner", 50f)

        AppOutlinedButton(
            icon = Icons.Default.Settings,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            onClick = {},
        )
    },
    parameters = {
        val cornerRadiusState = rememberViewCaseState("icon_outlined_corner", 50f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 50f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)
