package com.dezdeqness.ast.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.layouts.AdaptiveLayout
import com.dezdeqness.core.ui.views.layouts.AdaptiveViewCollection
import com.dezdeqness.core.ui.views.layouts.LocalLayoutType

val adaptiveLayoutDefault = ViewCase(
    title = "adaptiveLayoutDefault",
    content = {
        val widthState = rememberViewCaseState("al_width", 400f)

        AdaptiveLayout(
            modifier = Modifier.width(widthState.value.toInt().dp),
        ) {
            val layoutType = LocalLayoutType.current

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(AppTheme.colors.onPrimary)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Layout Type: $layoutType",
                    color = AppTheme.colors.textPrimary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                )
                Text(
                    text = "Width: ${widthState.value.toInt()} dp",
                    color = AppTheme.colors.textSecondary,
                )
                Text(
                    text = when (layoutType) {
                        com.dezdeqness.core.ui.views.layouts.LayoutType.Mobile -> "< 600dp"
                        com.dezdeqness.core.ui.views.layouts.LayoutType.Tablet -> "600dp - 1024dp"
                        com.dezdeqness.core.ui.views.layouts.LayoutType.Desktop -> ">= 1024dp"
                    },
                    color = AppTheme.colors.textSecondary,
                )
            }
        }
    },
    parameters = {
        val widthState = rememberViewCaseState("al_width", 400f)

        listOf(
            ViewParameter.DensityParameter(
                label = "Container Width",
                value = widthState.value,
                min = 200f,
                max = 1200f,
                step = 50f,
                onChange = { widthState.value = it }
            ),
        )
    }
)

private data class SampleItem(val id: Int, val title: String)

private val sampleItems = (1..12).map { SampleItem(id = it, title = "Item $it") }

val adaptiveViewCollectionDefault = ViewCase(
    title = "adaptiveViewCollectionDefault",
    content = {
        val widthState = rememberViewCaseState("avc_width", 400f)
        val itemCountState = rememberViewCaseState("avc_count", 12)

        val items = sampleItems.take(itemCountState.value)

        AdaptiveViewCollection(
            items = items,
            key = { it.id },
            modifier = Modifier
                .width(widthState.value.toInt().dp)
                .height(400.dp),
            mobileItem = { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(AppTheme.colors.onPrimary)
                        .padding(16.dp),
                ) {
                    Text(
                        text = item.title,
                        color = AppTheme.colors.textPrimary,
                    )
                }
            },
            wideItem = { item ->
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(AppTheme.colors.onPrimary)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = item.title,
                        color = AppTheme.colors.textPrimary,
                        fontWeight = FontWeight.Medium,
                    )
                }
            },
        )
    },
    parameters = {
        val widthState = rememberViewCaseState("avc_width", 400f)
        val itemCountState = rememberViewCaseState("avc_count", 12)

        listOf(
            ViewParameter.DensityParameter(
                label = "Container Width",
                value = widthState.value,
                min = 200f,
                max = 1200f,
                step = 50f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Item Count",
                value = itemCountState.value,
                min = 1,
                max = 12,
                onChange = { itemCountState.value = it }
            ),
        )
    }
)
