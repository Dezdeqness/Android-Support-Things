package com.dezdeqness.core.ui.views.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun SearchTextField(
    modifier: Modifier = Modifier,
    state: SearchState,
    textStyle: TextStyle = AppTheme.typography.titleMedium.copy(
        fontSize = 18.sp,
        color = AppTheme.colors.textPrimary,
    ),
    onQueryChanged: (String) -> Unit,
    containerColor: Color = AppTheme.colors.surfaceVariant,
    shape: Shape = RoundedCornerShape(16.dp),
    placeholder: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        imeAction = ImeAction.Search,
        keyboardType = KeyboardType.Text,
        capitalization = KeyboardCapitalization.Words,
    ),
    keyboardActions: KeyboardActions = KeyboardActions(
        onSearch = {
            onQueryChanged(state.query)
        },
    ),
    colors: TextFieldColors = OutlinedTextFieldDefaults.colors().copy(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent,
        disabledIndicatorColor = Color.Transparent,
    ),
    isEnabled: Boolean = true,
) {
    val focusRequester = remember { FocusRequester() }

    OutlinedTextField(
        value = state.query,
        onValueChange = {
            state.updateQuery(it)
        },
        placeholder = if (state.editTextFocused) {
            placeholder
        } else {
            null
        },
        modifier = modifier
            .fillMaxWidth()
            .background(containerColor, shape)
            .focusRequester(focusRequester)
            .onFocusChanged {
                state.editTextFocused = it.isFocused
            },
        textStyle = textStyle,
        singleLine = true,
        trailingIcon = if (state.query.isNotBlank()) {
            trailingIcon
        } else {
            null
        },
        leadingIcon = if (state.editTextFocused.not() && state.query.isBlank()) {
            leadingIcon
        } else {
            null
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        colors = colors,
        enabled = isEnabled,
    )
}

class SearchState(
    initialQuery: String = "",
) {
    var query by mutableStateOf(initialQuery)
        private set

    var hasUserInteracted = false

    var editTextFocused by mutableStateOf(false)

    fun updateQuery(query: String) {
        hasUserInteracted = true
        this.query = query
    }

    companion object {
        val Saver: Saver<SearchState, *> = listSaver(
            save = { listOf(it.query, it.hasUserInteracted, it.editTextFocused) },
            restore = {
                SearchState().apply {
                    query = it[0] as String
                    hasUserInteracted = it[1] as Boolean
                    editTextFocused = it[2] as Boolean
                }
            }
        )
    }

}

@Composable
fun rememberSearchState(
    initialQuery: String = "",
) = rememberSaveable(saver = SearchState.Saver) {
    SearchState(initialQuery = initialQuery)
}
