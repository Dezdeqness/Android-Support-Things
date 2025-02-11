package com.dezdeqness.core.ui.theme.base

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

interface BaseTypography {
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle
    val headlineLarge: TextStyle
    val headlineMedium: TextStyle
    val headlineSmall: TextStyle
    val titleLarge: TextStyle
    val titleMedium: TextStyle
    val titleSmall: TextStyle
    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
    val bodySmall: TextStyle
    val labelLarge: TextStyle
    val labelMedium: TextStyle
    val labelSmall: TextStyle
}

internal val LocalTypography = staticCompositionLocalOf<BaseTypography> {
    throw UnsupportedOperationException()
}
