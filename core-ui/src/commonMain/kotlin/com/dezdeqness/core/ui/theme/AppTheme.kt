package com.dezdeqness.core.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

object AppTheme {
    val colors: AppColors
        @Composable
        get() = LocalColors.current

    val typography: AppTypography
        @Composable
        get() = LocalTypography.current

    val shapes: AppShapes
        @Composable
        get() = LocalShapes.current
}


@Composable
fun AppTheme(
    colors: AppColors = if (isSystemInDarkTheme()) darkColors() else lightColors(),
    materialDefaultTheme: ColorScheme = if (isSystemInDarkTheme()) toDarkMaterialScheme() else toLightMaterialScheme(),
    typography: AppTypography = AppTypography(),
    shapes: AppShapes = AppShapes(),
    content: @Composable () -> Unit
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalTypography provides typography,
        LocalShapes provides shapes,
    ) {
        MaterialTheme(colorScheme = materialDefaultTheme) {
            content()
        }
    }
}

fun toLightMaterialScheme(): ColorScheme = lightColorScheme(
    primary = LightColors.Primary,
    onPrimary = LightColors.OnPrimary,
    secondary = LightColors.Secondary,
    onSecondary = LightColors.OnSecondary,
    background = LightColors.Background,
    onBackground = LightColors.OnBackground,
    surface = LightColors.Surface,
    onSurface = LightColors.OnSurface,
    surfaceVariant = LightColors.SurfaceVariant,
    error = LightColors.Error,
)

fun toDarkMaterialScheme(): ColorScheme = darkColorScheme(
    primary = DarkColors.Primary,
    onPrimary = DarkColors.OnPrimary,
    secondary = DarkColors.Secondary,
    onSecondary = DarkColors.OnSecondary,
    background = DarkColors.Background,
    onBackground = DarkColors.OnBackground,
    surface = DarkColors.Surface,
    onSurface = DarkColors.OnSurface,
    surfaceVariant = DarkColors.SurfaceVariant,
    error = DarkColors.Error,
)


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
