package com.dezdeqness.ast.viewbook.core.viewcase

import androidx.compose.runtime.Composable

sealed class ViewParameter {
    abstract val label: String

    data class BooleanParameter(
        override val label: String,
        val value: Boolean,
        val onChange: (Boolean) -> Unit
    ) : ViewParameter()

    data class StringParameter(
        override val label: String,
        val value: String,
        val onChange: (String) -> Unit
    ) : ViewParameter()

    data class IntParameter(
        override val label: String,
        val value: Int,
        val min: Int = 0,
        val max: Int = 100,
        val onChange: (Int) -> Unit
    ) : ViewParameter()

    data class FloatParameter(
        override val label: String,
        val value: Float,
        val min: Float = 0f,
        val max: Float = 1f,
        val onChange: (Float) -> Unit
    ) : ViewParameter()

    data class ChoiceParameter(
        override val label: String,
        val options: List<String>,
        val selectedIndex: Int,
        val onChange: (Int) -> Unit
    ) : ViewParameter()

    data class ColorParameter(
        override val label: String,
        val value: String,
        val onChange: (String) -> Unit
    ) : ViewParameter()

    data class DensityParameter(
        override val label: String,
        val value: Float,
        val min: Float = 0f,
        val max: Float = 64f,
        val step: Float = 1f,
        val onChange: (Float) -> Unit
    ) : ViewParameter()

    data class CustomParameter(
        override val label: String,
        val content: @Composable () -> Unit
    ) : ViewParameter()
}
