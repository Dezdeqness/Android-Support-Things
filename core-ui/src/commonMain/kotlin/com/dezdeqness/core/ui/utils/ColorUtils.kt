package com.dezdeqness.core.ui.utils

import androidx.compose.ui.graphics.Color

fun Color.lighten(factor: Float): Color {
    val r = (red + (1 - red) * factor).coerceIn(0f, 1f)
    val g = (green + (1 - green) * factor).coerceIn(0f, 1f)
    val b = (blue + (1 - blue) * factor).coerceIn(0f, 1f)
    return Color(r, g, b, alpha)
}

fun Color.darken(factor: Float): Color {
    val r = (red * (1 - factor)).coerceIn(0f, 1f)
    val g = (green * (1 - factor)).coerceIn(0f, 1f)
    val b = (blue * (1 - factor)).coerceIn(0f, 1f)
    return Color(r, g, b, alpha)
}
