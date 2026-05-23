package com.dezdeqness.core.ui.views.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun AnimatedLoadingBars(
    modifier: Modifier = Modifier,
    isPlaying: Boolean = true,
    barCount: Int = 3,
    barWidth: Dp = 6.dp,
    maxBarHeight: Dp = 16.dp,
    barColor: Color = Color.White,
) {
    val animatedList = remember(barCount) {
        List(barCount) { Animatable(0.1f) }
    }

    if (isPlaying) {
        LaunchedEffect(Unit) {
            animatedList.forEach { item ->
                launch {
                    while (true) {
                        item.animateTo(Random.nextFloat())
                        delay(100)
                    }
                }
            }
        }
    } else {
        LaunchedEffect(Unit) {
            animatedList.forEach { item ->
                launch {
                    item.animateTo(0.1f)
                    delay(100)
                }
            }
        }
    }

    Row(
        horizontalArrangement = Arrangement.spacedBy(2.dp),
        verticalAlignment = Alignment.Bottom,
        modifier = modifier.size(barCount * barWidth + (barCount - 1) * 2.dp, maxBarHeight),
    ) {
        animatedList.forEach { item ->
            Box(
                modifier = Modifier
                    .width(barWidth)
                    .height(item.value * maxBarHeight)
                    .clip(RoundedCornerShape(2.dp))
                    .background(barColor)
            )
        }
    }
}
