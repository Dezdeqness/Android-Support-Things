package com.dezdeqness.core.ui.theme.base

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.runtime.staticCompositionLocalOf

interface BaseShapes {
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
}

internal val LocalShapes =
    staticCompositionLocalOf<BaseShapes> { throw UnsupportedOperationException() }
