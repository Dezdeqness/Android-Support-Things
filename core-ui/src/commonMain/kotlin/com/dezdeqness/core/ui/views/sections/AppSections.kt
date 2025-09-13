package com.dezdeqness.core.ui.views.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun <T> AppSections(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    items: List<T>,
    contentColor: Color = AppTheme.colors.onPrimary,
    contentListPadding: PaddingValues = PaddingValues(horizontal = 16.dp),
    contentItemPadding: Dp = 4.dp,
    key: ((T) -> Any)? = null,
    itemContent: @Composable (item: T) -> Unit,
) {
    Column(modifier = modifier.background(contentColor)) {
        header()

        LazyRow(contentPadding = contentListPadding) {
            items(
                count = items.size,
                key = { index -> key?.invoke(items[index]) ?: index },
            ) { index ->
                val item = items[index]

                val paddingStart = if (index == 0) 0.dp else contentItemPadding
                val paddingEnd = if (index < items.size - 1) contentItemPadding else 0.dp

                Box(
                    modifier = Modifier.padding(start = paddingStart, end = paddingEnd),
                    contentAlignment = Alignment.Center,
                ) {
                    itemContent(item)
                }
            }
        }
    }
}
