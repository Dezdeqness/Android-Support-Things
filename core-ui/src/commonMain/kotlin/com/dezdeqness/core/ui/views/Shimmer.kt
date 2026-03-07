package com.dezdeqness.core.ui.views

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.positionInRoot
import com.dezdeqness.core.ui.theme.AppTheme

private const val DEFAULT_WIDTH_SHADOW_BRUSH = 700
private const val DEFAULT_DURATION = 1500
private const val DEFAULT_ONE_WAVE_DURATION = 2300
private const val DEFAULT_ANGLE_AXIS_Y = 270f
private val DEFAULT_COLOR = Color.LightGray

@Composable
fun Modifier.shimmer(
    shape: Shape = AppTheme.shapes.medium,
    widthOfShadowBrush: Int = DEFAULT_WIDTH_SHADOW_BRUSH,
    angleOfAxisY: Float = DEFAULT_ANGLE_AXIS_Y,
    durationMillis: Int = DEFAULT_DURATION,
    color: Color = Color.Unspecified
): Modifier = composed {
    val shimmerBaseColor = if (color == Color.Unspecified) {
        DEFAULT_COLOR
    } else {
        color
    }
    val shimmerColors = listOf(
        shimmerBaseColor.copy(alpha = 0.3f),
        shimmerBaseColor.copy(alpha = 0.5f),
        shimmerBaseColor.copy(alpha = 1.0f),
        shimmerBaseColor.copy(alpha = 0.5f),
        shimmerBaseColor.copy(alpha = 0.3f),
    )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    return@composed this.then(
        this.background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(x = translateAnimation - widthOfShadowBrush, y = 0.0f),
                end = Offset(x = translateAnimation, y = angleOfAxisY),
            ),
            shape = shape
        )
    )
}

@Composable
fun rememberShimmerOffset(
    widthOfShadowBrush: Int = DEFAULT_WIDTH_SHADOW_BRUSH,
    durationMillis: Int = DEFAULT_ONE_WAVE_DURATION
): State<Float> {
    val transition = rememberInfiniteTransition(label = "shimmer")

    return transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Restart
        ),
        label = "shimmerOffset"
    )
}

@Composable
fun Modifier.shimmer(
    shimmerOffset: Float,
    shape: Shape = AppTheme.shapes.medium,
    widthOfShadowBrush: Int = DEFAULT_WIDTH_SHADOW_BRUSH,
    angleOfAxisY: Float = DEFAULT_ANGLE_AXIS_Y,
    color: Color = Color.Unspecified
): Modifier = composed {

    var offsetX by remember { mutableStateOf(0f) }

    val shimmerBaseColor = if (color == Color.Unspecified) {
        DEFAULT_COLOR
    } else color

    val shimmerColors = listOf(
        shimmerBaseColor.copy(alpha = 0.3f),
        shimmerBaseColor.copy(alpha = 0.5f),
        shimmerBaseColor.copy(alpha = 1f),
        shimmerBaseColor.copy(alpha = 0.5f),
        shimmerBaseColor.copy(alpha = 0.3f),
    )

    this
        .onGloballyPositioned {
            offsetX = it.positionInRoot().x
        }
        .background(
            brush = Brush.linearGradient(
                colors = shimmerColors,
                start = Offset(x = shimmerOffset - widthOfShadowBrush - offsetX, y = 0f),
                end = Offset(x = shimmerOffset - offsetX, y = angleOfAxisY)
            ), shape = shape
        )
}
