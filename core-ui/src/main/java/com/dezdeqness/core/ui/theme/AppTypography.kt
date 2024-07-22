package com.dezdeqness.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import com.dezdeqness.core.ui.theme.base.BaseTypography

private val defaultTypography = Typography()

@Immutable
data class AppTypography(
    override val displayLarge: TextStyle = defaultTypography.displayLarge,
    override val displayMedium: TextStyle = defaultTypography.displayMedium,
    override val displaySmall: TextStyle = defaultTypography.displaySmall,
    override val headlineLarge: TextStyle = defaultTypography.headlineLarge,
    override val headlineMedium: TextStyle = defaultTypography.headlineMedium,
    override val headlineSmall: TextStyle = defaultTypography.headlineSmall,
    override val titleLarge: TextStyle = defaultTypography.titleLarge,
    override val titleMedium: TextStyle = defaultTypography.titleMedium,
    override val titleSmall: TextStyle = defaultTypography.titleSmall,
    override val bodyLarge: TextStyle = defaultTypography.bodyLarge,
    override val bodyMedium: TextStyle = defaultTypography.bodyMedium,
    override val bodySmall: TextStyle = defaultTypography.bodySmall,
    override val labelLarge: TextStyle = defaultTypography.labelLarge,
    override val labelMedium: TextStyle = defaultTypography.labelMedium,
    override val labelSmall: TextStyle = defaultTypography.labelSmall,
) : BaseTypography
