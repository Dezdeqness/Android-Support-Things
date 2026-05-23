package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.textfield.AppTextField
import com.dezdeqness.core.ui.views.textfield.SearchTextField
import com.dezdeqness.core.ui.views.textfield.rememberSearchState

val appTextFieldDefault = ViewCase(
    title = "appTextFieldDefault",
    content = {
        val valueState = rememberViewCaseState("tf_value", "")
        val labelState = rememberViewCaseState("tf_label", "Email")
        val placeholderState = rememberViewCaseState("tf_placeholder", "Enter your email")
        val widthState = rememberViewCaseState("tf_width", 350f)
        val isPasswordState = rememberViewCaseState("tf_password", false)
        val isErrorState = rememberViewCaseState("tf_error", false)
        val cornerRadiusState = rememberViewCaseState("tf_corner", 12f)
        val singleLineState = rememberViewCaseState("tf_single_line", true)

        AppTextField(
            value = valueState.value,
            onValueChange = { valueState.value = it },
            label = labelState.value,
            placeholder = placeholderState.value,
            isPassword = isPasswordState.value,
            isError = isErrorState.value,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            singleLine = singleLineState.value,
            modifier = Modifier.width(widthState.value.toInt().dp),
        )
    },
    parameters = {
        val valueState = rememberViewCaseState("tf_value", "")
        val labelState = rememberViewCaseState("tf_label", "Email")
        val placeholderState = rememberViewCaseState("tf_placeholder", "Enter your email")
        val widthState = rememberViewCaseState("tf_width", 350f)
        val isPasswordState = rememberViewCaseState("tf_password", false)
        val isErrorState = rememberViewCaseState("tf_error", false)
        val cornerRadiusState = rememberViewCaseState("tf_corner", 12f)
        val singleLineState = rememberViewCaseState("tf_single_line", true)

        listOf(
            ViewParameter.StringParameter(
                label = "Value",
                value = valueState.value,
                onChange = { valueState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Label",
                value = labelState.value,
                onChange = { labelState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Placeholder",
                value = placeholderState.value,
                onChange = { placeholderState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Password",
                value = isPasswordState.value,
                onChange = { isPasswordState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Error",
                value = isErrorState.value,
                onChange = { isErrorState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Single Line",
                value = singleLineState.value,
                onChange = { singleLineState.value = it }
            ),
        )
    }
)

val searchTextFieldDefault = ViewCase(
    title = "searchTextFieldDefault",
    content = {
        val widthState = rememberViewCaseState("stf_width", 350f)
        val enabledState = rememberViewCaseState("stf_enabled", true)
        val cornerRadiusState = rememberViewCaseState("stf_corner", 16f)
        val searchState = rememberSearchState()

        SearchTextField(
            modifier = Modifier.width(widthState.value.toInt().dp),
            state = searchState,
            onQueryChanged = {},
            isEnabled = enabledState.value,
            shape = RoundedCornerShape(cornerRadiusState.value.toInt().dp),
            placeholder = {
                Text(
                    text = "Search...",
                    color = AppTheme.colors.textSecondary,
                )
            },
            leadingIcon = {
                Icon(
                    Icons.Filled.Search,
                    contentDescription = null,
                    tint = AppTheme.colors.textSecondary,
                )
            },
            trailingIcon = {
                IconButton(onClick = { searchState.updateQuery("") }) {
                    Icon(
                        Icons.Filled.Clear,
                        contentDescription = null,
                        tint = AppTheme.colors.textSecondary,
                    )
                }
            },
        )
    },
    parameters = {
        val widthState = rememberViewCaseState("stf_width", 350f)
        val enabledState = rememberViewCaseState("stf_enabled", true)
        val cornerRadiusState = rememberViewCaseState("stf_corner", 16f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Enabled",
                value = enabledState.value,
                onChange = { enabledState.value = it }
            ),
        )
    }
)
