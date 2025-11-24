package com.dezdeqness.ast.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.buttons.AppButton
import com.dezdeqness.core.ui.views.buttons.AppOutlinedButton
import com.dezdeqness.core.ui.views.buttons.AppTextButton

val buttonDefault = ViewCase(
    title = "buttonDefault",
    content = {
        val buttonTextState = rememberViewCaseState("btn_text", "Authorize")
        val buttonTypeState = rememberViewCaseState("btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)

        when (buttonTypeState.value) {
            0 -> AppButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {}
            )

            1 -> AppOutlinedButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {}
            )

            2 -> AppTextButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                onClick = {}
            )
        }
    },
    parameters = {
        val buttonTextState = rememberViewCaseState("btn_text", "Authorize")
        val buttonTypeState = rememberViewCaseState("btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)

        listOf(
            ViewParameter.ChoiceParameter(
                label = "Button Type",
                options = listOf("Filled", "Outlined", "Text"),
                selectedIndex = buttonTypeState.value,
                onChange = { buttonTypeState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Button Text",
                value = buttonTextState.value,
                onChange = { buttonTextState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 4f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)
