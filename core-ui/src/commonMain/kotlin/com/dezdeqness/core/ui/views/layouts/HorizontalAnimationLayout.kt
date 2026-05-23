package com.dezdeqness.core.ui.views.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.Measurable
import androidx.compose.ui.layout.MeasurePolicy
import androidx.compose.ui.layout.MeasureResult
import androidx.compose.ui.layout.MeasureScope
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalAnimationLayout(
    modifier: Modifier = Modifier,
    progress: Float,
    content: @Composable () -> Unit,
) {
    val measurePolicy = remember(progress) {
        object : MeasurePolicy {
            override fun MeasureScope.measure(
                measurables: List<Measurable>,
                constraints: Constraints,
            ): MeasureResult {
                require(measurables.size == 2)

                val leadingPlaceable = measurables.first().measure(constraints.copy(minWidth = 0))
                val trailingPlaceable = measurables.last().measure(
                    Constraints.fixedWidth(
                        (constraints.maxWidth - leadingPlaceable.width * progress).toInt()
                    )
                )

                return layout(constraints.maxWidth, trailingPlaceable.height) {
                    val width = leadingPlaceable.width
                    val leftPadding = 16.dp.roundToPx()

                    leadingPlaceable.placeRelative(
                        x = (-(width + leftPadding) * (1 - progress)).toInt(),
                        y = 0,
                    )
                    trailingPlaceable.placeRelative(
                        x = (width * progress).toInt(),
                        y = 0,
                    )
                }
            }
        }
    }

    Layout(
        modifier = modifier,
        measurePolicy = measurePolicy,
        content = content,
    )
}
