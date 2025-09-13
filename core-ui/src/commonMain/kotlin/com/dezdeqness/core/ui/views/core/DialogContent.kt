package com.dezdeqness.core.ui.views.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.header.Header

@Composable
fun <T> DialogContent(
    title: String? = null,
    selectedValue: T,
    valueText: @Composable (T) -> String,
    values: List<T>,
    onValueSelected: (T) -> Unit,
    contentColor: Color = AppTheme.colors.background,
) {
    Column(
        modifier = Modifier.background(contentColor),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (title != null) {
            Header(
                title = title,
                contentColor = contentColor,
            )
        }

        LazyColumn {
            items(values.size) { index ->
                val value = values[index]
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(8.dp))
                        .clickable {
                            onValueSelected(value)
                        }
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    RadioButton(
                        selected = value == selectedValue,
                        onClick = null
                    )

                    Text(
                        text = valueText(value),
                        style = AppTheme.typography.bodyMedium,
                        color = AppTheme.colors.textPrimary,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    }
}
