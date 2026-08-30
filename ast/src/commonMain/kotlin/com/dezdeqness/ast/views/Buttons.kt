@file:Folder("Buttons")

package com.dezdeqness.ast.views

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.buttons.AppAccentButton
import com.dezdeqness.core.ui.views.buttons.AppErrorButton
import com.dezdeqness.core.ui.views.buttons.AppPrimaryButton
import com.dezdeqness.core.ui.views.buttons.AppSecondaryButton
import com.dezdeqness.core.ui.views.buttons.AppTextButton

@ViewCaseEntry(name = "Button Default")
val buttonDefault = ViewCase(
    title = "buttonDefault",
    content = {
        val buttonTextState = rememberViewCaseState("btn_text", "Authorize")
        val buttonTypeState = rememberViewCaseState("btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)
        val enabledState = rememberViewCaseState("btn_enabled", true)
        val loadingState = rememberViewCaseState("btn_loading", false)
        val leadingIconState = rememberViewCaseState("btn_leading", false)
        val trailingIconState = rememberViewCaseState("btn_trailing", false)

        val leadingIcon: @androidx.compose.runtime.Composable (() -> Unit)? =
            if (leadingIconState.value) {
                { Icon(Icons.Default.Add, contentDescription = null) }
            } else null

        val trailingIcon: @androidx.compose.runtime.Composable (() -> Unit)? =
            if (trailingIconState.value) {
                { Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null) }
            } else null

        when (buttonTypeState.value) {
            0 -> AppPrimaryButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                enabled = enabledState.value,
                isLoading = loadingState.value,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onClick = {}
            )

            1 -> AppSecondaryButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                enabled = enabledState.value,
                isLoading = loadingState.value,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onClick = {}
            )

            2 -> AppTextButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                enabled = enabledState.value,
                isLoading = loadingState.value,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onClick = {}
            )

            3 -> AppAccentButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                enabled = enabledState.value,
                isLoading = loadingState.value,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onClick = {}
            )

            4 -> AppErrorButton(
                title = buttonTextState.value,
                shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
                enabled = enabledState.value,
                isLoading = loadingState.value,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                onClick = {}
            )
        }
    },
    parameters = {
        val buttonTextState = rememberViewCaseState("btn_text", "Authorize")
        val buttonTypeState = rememberViewCaseState("btn_type", 0)
        val cornerRadiusState = rememberViewCaseState("tile_corner", 12f)
        val enabledState = rememberViewCaseState("btn_enabled", true)
        val loadingState = rememberViewCaseState("btn_loading", false)
        val leadingIconState = rememberViewCaseState("btn_leading", false)
        val trailingIconState = rememberViewCaseState("btn_trailing", false)

        listOf(
            ViewParameter.ChoiceParameter(
                label = "Button Type",
                options = listOf("Primary", "Secondary", "Text", "Accent", "Error"),
                selectedValue = buttonTypeState.value,
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
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Loading",
                value = loadingState.value,
                onChange = { loadingState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Leading Icon",
                value = leadingIconState.value,
                onChange = { leadingIconState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Trailing Icon",
                value = trailingIconState.value,
                onChange = { trailingIconState.value = it }
            ),
        )
    }
)

@ViewCaseEntry(name = "Button Outlined")
val buttonOutlined = ViewCase(
    title = "buttonOutlined",
    content = {
        val buttonTextState = rememberViewCaseState("btn_out_text", "Authorize")
        val cornerRadiusState = rememberViewCaseState("btn_out_corner", 12f)
        val enabledState = rememberViewCaseState("btn_out_enabled", true)
        val loadingState = rememberViewCaseState("btn_out_loading", false)

        AppSecondaryButton(
            title = buttonTextState.value,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            enabled = enabledState.value,
            isLoading = loadingState.value,
            onClick = {}
        )
    },
    parameters = {
        val buttonTextState = rememberViewCaseState("btn_out_text", "Authorize")
        val cornerRadiusState = rememberViewCaseState("btn_out_corner", 12f)
        val enabledState = rememberViewCaseState("btn_out_enabled", true)
        val loadingState = rememberViewCaseState("btn_out_loading", false)

        listOf(
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
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Loading",
                value = loadingState.value,
                onChange = { loadingState.value = it }
            ),
        )
    }
)

@ViewCaseEntry(name = "Button Text")
val buttonText = ViewCase(
    title = "buttonText",
    content = {
        val buttonTextState = rememberViewCaseState("btn_txt_text", "Authorize")
        val cornerRadiusState = rememberViewCaseState("btn_txt_corner", 12f)
        val enabledState = rememberViewCaseState("btn_txt_enabled", true)
        val loadingState = rememberViewCaseState("btn_txt_loading", false)

        AppTextButton(
            title = buttonTextState.value,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            enabled = enabledState.value,
            isLoading = loadingState.value,
            onClick = {}
        )
    },
    parameters = {
        val buttonTextState = rememberViewCaseState("btn_txt_text", "Authorize")
        val cornerRadiusState = rememberViewCaseState("btn_txt_corner", 12f)
        val enabledState = rememberViewCaseState("btn_txt_enabled", true)
        val loadingState = rememberViewCaseState("btn_txt_loading", false)

        listOf(
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
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Loading",
                value = loadingState.value,
                onChange = { loadingState.value = it }
            ),
        )
    }
)
