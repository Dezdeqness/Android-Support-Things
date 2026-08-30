@file:Folder("Loading")

package com.dezdeqness.ast.views

import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.loading.AnimatedLoadingBars

@ViewCaseEntry(name = "Animated Loading Bars")
val animatedLoadingBarsDefault = ViewCase(
    title = "animatedLoadingBarsDefault",
    content = {
        val barCountState = rememberViewCaseState("loading_count", 3)
        val isPlayingState = rememberViewCaseState("loading_playing", true)
        val barWidthState = rememberViewCaseState("loading_bar_width", 6f)
        val maxBarHeightState = rememberViewCaseState("loading_max_height", 16f)

        AnimatedLoadingBars(
            barCount = barCountState.value,
            isPlaying = isPlayingState.value,
            barWidth = barWidthState.value.toInt().dp,
            maxBarHeight = maxBarHeightState.value.toInt().dp,
            barColor = AppTheme.colors.accent,
        )
    },
    parameters = {
        val barCountState = rememberViewCaseState("loading_count", 3)
        val isPlayingState = rememberViewCaseState("loading_playing", true)
        val barWidthState = rememberViewCaseState("loading_bar_width", 6f)
        val maxBarHeightState = rememberViewCaseState("loading_max_height", 16f)

        listOf(
            ViewParameter.IntParameter(
                label = "Bar Count",
                value = barCountState.value,
                min = 2,
                max = 8,
                onChange = { barCountState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Playing",
                value = isPlayingState.value,
                onChange = { isPlayingState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Bar Width",
                value = barWidthState.value,
                min = 2f,
                max = 16f,
                step = 2f,
                onChange = { barWidthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Max Bar Height",
                value = maxBarHeightState.value,
                min = 8f,
                max = 48f,
                step = 4f,
                onChange = { maxBarHeightState.value = it }
            ),
        )
    }
)
