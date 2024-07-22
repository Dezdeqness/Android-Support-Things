package com.dezdeqness.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.dezdeqness.core.ui.theme.base.BaseColors

@Immutable
class AppColors(
    val onPrimaryColor: Color,
    val onSecondaryColor: Color,
    val textPrimaryColor: Color,
    val textSecondaryColor: Color,
    val rippleColor: Color,
    val errorColor: Color,
    val isLightTheme: Boolean
) : BaseColors(
    _onPrimaryColor = onPrimaryColor,
    _onSecondaryColor = onSecondaryColor,
    _textPrimaryColor = textPrimaryColor,
    _textSecondaryColor = textSecondaryColor,
    _rippleColor = rippleColor,
    _errorColor = errorColor,
    _isLightTheme = isLightTheme,
)

fun lightColors(
    onPrimary: Color = white,
    onSecondary: Color = black,
    textPrimary: Color = black,
    textSecondary: Color = white,
    ripple: Color = black,
    error: Color = white,
): AppColors = AppColors(
    onPrimaryColor = onPrimary,
    onSecondaryColor = onSecondary,
    textPrimaryColor = textPrimary,
    textSecondaryColor = textSecondary,
    rippleColor = ripple,
    errorColor = error,
    isLightTheme = true
)

fun darkColors(
    onPrimary: Color = black,
    onSecondary: Color = white,
    textPrimary: Color = white,
    textSecondary: Color = black,
    ripple: Color = white,
    error: Color = black,
): AppColors = AppColors(
    onPrimaryColor = onPrimary,
    onSecondaryColor = onSecondary,
    textPrimaryColor = textPrimary,
    textSecondaryColor = textSecondary,
    rippleColor = ripple,
    errorColor = error,
    isLightTheme = false
)
