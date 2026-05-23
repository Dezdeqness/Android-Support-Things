package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.charts.ChartSegment
import com.dezdeqness.core.ui.views.charts.DiagramChart
import com.dezdeqness.core.ui.views.charts.HorizontalChart
import com.dezdeqness.core.ui.views.charts.HorizontalChartItem

private val barColorOptions = listOf("Accent", "Blue", "Green", "Red", "Orange")
private val barColors = listOf(
    null,
    Color(0xFF2196F3),
    Color(0xFF4CAF50),
    Color(0xFFF44336),
    Color(0xFFFF9800),
)

val diagramChartDefault = ViewCase(
    title = "diagramChartDefault",
    content = {
        val widthState = rememberViewCaseState("diagram_width", 350f)
        val chartHeightState = rememberViewCaseState("diagram_height", 150f)
        val gapState = rememberViewCaseState("diagram_gap", 2f)
        val thicknessState = rememberViewCaseState("diagram_thickness", 10f)

        DiagramChart(
            modifier = Modifier.width(widthState.value.toInt().dp),
            chartHeight = chartHeightState.value.toInt().dp,
            gapDegrees = gapState.value,
            progressThickness = thicknessState.value.toInt().dp,
            segments = listOf(
                ChartSegment(
                    label = "Watching",
                    value = "45",
                    progress = 45f,
                    color = Color(0xFF4CAF50),
                ),
                ChartSegment(
                    label = "Completed",
                    value = "120",
                    progress = 120f,
                    color = Color(0xFF2196F3),
                ),
                ChartSegment(
                    label = "On Hold",
                    value = "15",
                    progress = 15f,
                    color = Color(0xFFFFC107),
                ),
                ChartSegment(
                    label = "Dropped",
                    value = "8",
                    progress = 8f,
                    color = Color(0xFFF44336),
                ),
                ChartSegment(
                    label = "Planned",
                    value = "32",
                    progress = 32f,
                    color = Color(0xFF9C27B0),
                ),
            ),
        )
    },
    parameters = {
        val widthState = rememberViewCaseState("diagram_width", 350f)
        val chartHeightState = rememberViewCaseState("diagram_height", 150f)
        val gapState = rememberViewCaseState("diagram_gap", 2f)
        val thicknessState = rememberViewCaseState("diagram_thickness", 10f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Chart Height",
                value = chartHeightState.value,
                min = 80f,
                max = 300f,
                step = 10f,
                onChange = { chartHeightState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Progress Thickness",
                value = thicknessState.value,
                min = 2f,
                max = 30f,
                step = 2f,
                onChange = { thicknessState.value = it }
            ),
            ViewParameter.FloatParameter(
                label = "Gap Degrees",
                value = gapState.value,
                min = 0f,
                max = 10f,
                onChange = { gapState.value = it }
            ),
        )
    }
)

val horizontalChartDefault = ViewCase(
    title = "horizontalChartDefault",
    content = {
        val widthState = rememberViewCaseState("hchart_width", 350f)
        val barHeightState = rememberViewCaseState("hchart_bar_height", 10f)
        val barColorState = rememberViewCaseState("hchart_bar_color", 0)
        val staggerDelayState = rememberViewCaseState("hchart_stagger", 80f)

        HorizontalChart(
            modifier = Modifier.width(widthState.value.toInt().dp),
            maxProgress = 10f,
            barHeight = barHeightState.value.toInt().dp,
            barColor = barColors[barColorState.value] ?: AppTheme.colors.accent,
            staggerDelayMs = staggerDelayState.value.toLong(),
            items = listOf(
                HorizontalChartItem(label = "10", value = "Masterpiece", progress = 8f),
                HorizontalChartItem(label = "9", value = "Great", progress = 5f),
                HorizontalChartItem(label = "8", value = "Very Good", progress = 10f),
                HorizontalChartItem(label = "7", value = "Good", progress = 7f),
                HorizontalChartItem(label = "6", value = "Fine", progress = 4f),
                HorizontalChartItem(label = "5", value = "Average", progress = 2f),
            ),
        )
    },
    parameters = {
        val widthState = rememberViewCaseState("hchart_width", 350f)
        val barHeightState = rememberViewCaseState("hchart_bar_height", 10f)
        val barColorState = rememberViewCaseState("hchart_bar_color", 0)
        val staggerDelayState = rememberViewCaseState("hchart_stagger", 80f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Bar Height",
                value = barHeightState.value,
                min = 4f,
                max = 24f,
                step = 2f,
                onChange = { barHeightState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Bar Color",
                options = barColorOptions,
                selectedValue = barColorState.value,
                onChange = { barColorState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Stagger Delay (ms)",
                value = staggerDelayState.value,
                min = 0f,
                max = 300f,
                step = 20f,
                onChange = { staggerDelayState.value = it }
            ),
        )
    }
)
