package com.dezdeqness.core.ui.theme.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.dezdeqness.core.ui.theme.AppColors

abstract class BaseColors(
    private val _onPrimaryColor: Color,
    private val _onSecondaryColor: Color,
    private val _textPrimaryColor: Color,
    private val _textSecondaryColor: Color,
    private val _rippleColor: Color,
    private val _errorColor: Color,
    private val _isLightTheme: Boolean,
) {

    var onPrimary by mutableStateOf(_onPrimaryColor)
        private set
    var onSecondary by mutableStateOf(_onSecondaryColor)
        private set
    var textPrimary by mutableStateOf(_textPrimaryColor)
        private set
    var textSecondary by mutableStateOf(_textSecondaryColor)
        private set
    var ripple by mutableStateOf(_rippleColor)
        private set
    var error by mutableStateOf(_errorColor)
        private set
    var isLight by mutableStateOf(_isLightTheme)
        internal set

    fun updateColorsFrom(other: BaseColors) {
        onPrimary = other._onPrimaryColor
        onSecondary = other._onSecondaryColor
        textPrimary = other._textPrimaryColor
        textSecondary = other._textSecondaryColor
        ripple = other._rippleColor
        error = other.error
    }

    fun copy(
        onPrimary: Color = this._onPrimaryColor,
        onSecondary: Color = this._onSecondaryColor,
        textPrimary: Color = this._textPrimaryColor,
        textSecondary: Color = this._textSecondaryColor,
        ripple: Color = this._rippleColor,
        error: Color = this._errorColor,
        isLight: Boolean = this._isLightTheme
    ): AppColors = AppColors(
        onPrimary,
        onSecondary,
        textPrimary,
        textSecondary,
        ripple,
        error,
        isLight
    )
}

internal val LocalColors =
    staticCompositionLocalOf<BaseColors> { throw UnsupportedOperationException() }
