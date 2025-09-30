package com.dezdeqness.core.ui.views.tiles

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun AppTile(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null,
    shape: Shape? = RoundedCornerShape(12.dp),
    contentColor: Color = AppTheme.colors.background,
    contentPadding: PaddingValues = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
    textStyle: TextStyle = AppTheme.typography.labelLarge,
    maxLines: Int = 2,
    prefixTitle: (@Composable (Modifier) -> Unit)? = null,
    suffixTitle: (@Composable (Modifier) -> Unit)? = null,
) {
    Row(
        modifier = modifier
            .clip(shape ?: RoundedCornerShape(0.dp))
            .background(contentColor)
            .clickable(
                onClick = onClick ?: {},
                enabled = onClick != null,
                interactionSource = remember { MutableInteractionSource() },
                indication = ripple(color = AppTheme.colors.ripple)
            )
            .padding(contentPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val iconModifier = Modifier.size(24.dp)

        prefixTitle?.invoke(iconModifier)

        Text(
            text,
            style = textStyle,
            modifier = Modifier.weight(1f),
            maxLines = maxLines,
            textAlign = TextAlign.Start,
            color = AppTheme.colors.textPrimary,
            overflow = TextOverflow.Ellipsis,
        )

        suffixTitle?.invoke(iconModifier)
    }
}
