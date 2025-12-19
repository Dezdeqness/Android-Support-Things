package com.dezdeqness.ast.views

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.rememberShimmerOffset
import com.dezdeqness.core.ui.views.shimmer

val shimmerDefault = ViewCase(
    title = "shimmerDefault",
    content = {
        val count by rememberViewCaseState("item_count", 6)
        val widthShadowBrush by rememberViewCaseState("width_shadow_brush", 700)
        val duration by rememberViewCaseState("wave_duration", 1500)
        val cornerRadiusState by rememberViewCaseState("shimmer_corner", 12f)
        val angleAxisState by rememberViewCaseState("angle_axis", 270f)

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            repeat(count) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .shimmer(
                            shape = RoundedCornerShape(cornerRadiusState.toInt().dp),
                            widthOfShadowBrush = widthShadowBrush,
                            durationMillis = duration,
                            angleOfAxisY = angleAxisState,
                        )
                )
            }
        }
    },
    parameters = {
        val count = rememberViewCaseState("item_count", 6)
        val widthShadowBrush = rememberViewCaseState("width_shadow_brush", 700)
        val duration = rememberViewCaseState("wave_duration", 1500)
        val cornerRadiusState = rememberViewCaseState("shimmer_corner", 12f)
        val angleAxisState = rememberViewCaseState("angle_axis", 270f)

        listOf(
            ViewParameter.IntParameter(
                label = "Count item",
                value = count.value,
                max = 6,
                onChange = { count.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Animation duration",
                value = duration.value,
                min = 100,
                max = 3000,
                onChange = { duration.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Width of brush",
                value = widthShadowBrush.value,
                min = 100,
                max = 2000,
                onChange = { widthShadowBrush.value = it }
            ),
            ViewParameter.FloatParameter(
                label = "Angle of axis",
                value = angleAxisState.value,
                min = -360f,
                max = 360f,
                onChange = { angleAxisState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 50f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)

val shimmerOneWave = ViewCase(
    title = "shimmerOneWave",
    content = {
        val count by rememberViewCaseState("item_count", 6)
        val widthShadowBrush by rememberViewCaseState("width_shadow_brush", 700)
        val duration by rememberViewCaseState("wave_duration", 2300)
        val cornerRadiusState by rememberViewCaseState("shimmer_corner", 12f)
        val angleAxisState by rememberViewCaseState("angle_axis", 270f)

        val shimmerOffset by rememberShimmerOffset(
            widthOfShadowBrush = widthShadowBrush,
            durationMillis = duration,
        )

        Row(
            modifier = Modifier.horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            repeat(count) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(200.dp)
                        .shimmer(
                            shimmerOffset = shimmerOffset,
                            shape = RoundedCornerShape(cornerRadiusState.toInt().dp),
                            widthOfShadowBrush = widthShadowBrush,
                            angleOfAxisY = angleAxisState,
                        )
                )
            }
        }
    },
    parameters = {
        val count = rememberViewCaseState("item_count", 6)
        val widthShadowBrush = rememberViewCaseState("width_shadow_brush", 700)
        val duration = rememberViewCaseState("wave_duration", 1500)
        val cornerRadiusState = rememberViewCaseState("shimmer_corner", 12f)
        val angleAxisState = rememberViewCaseState("angle_axis", 270f)

        listOf(
            ViewParameter.IntParameter(
                label = "Count item",
                value = count.value,
                max = 6,
                onChange = { count.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Animation duration",
                value = duration.value,
                min = 100,
                max = 3000,
                onChange = { duration.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Width of brush",
                value = widthShadowBrush.value,
                min = 100,
                max = 2000,
                onChange = { widthShadowBrush.value = it }
            ),
            ViewParameter.FloatParameter(
                label = "Angle of axis",
                value = angleAxisState.value,
                min = -360f,
                max = 360f,
                onChange = { angleAxisState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 50f,
                step = 2f,
                onChange = { cornerRadiusState.value = it }
            ),
        )
    }
)