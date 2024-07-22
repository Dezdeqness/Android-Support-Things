package com.dezdeqness.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.dezdeqness.core.ui.theme.base.BaseColors
import com.dezdeqness.core.ui.theme.base.BaseShapes
import com.dezdeqness.core.ui.theme.base.BaseTypography
import com.dezdeqness.core.ui.theme.base.LocalColors
import com.dezdeqness.core.ui.theme.base.LocalShapes
import com.dezdeqness.core.ui.theme.base.LocalTypography

object AppTheme {
    val colors: BaseColors
        @Composable
        get() = LocalColors.current

    val typography: BaseTypography
        @Composable
        get() = LocalTypography.current

    val shapes: BaseShapes
        @Composable
        get() = LocalShapes.current
}

@Composable
fun AppTheme(
    colors: BaseColors = if (isSystemInDarkTheme()) darkColors() else lightColors(),
    typography: BaseTypography = AppTypography(),
    shapes: BaseShapes = AppShapes(),
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        content()
    }
}

@Composable
fun AppCustomTheme(
    colors: AppColors,
    typography: AppTypography,
    shapes: AppShapes,
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        content()
    }
}
