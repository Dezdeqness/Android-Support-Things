package com.dezdeqness.core.ui.views.expandable

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.dezdeqness.core.ui.theme.AppTheme

private const val MAX_LINES_COLLAPSED = 5

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: AnnotatedString,
    maxLinesCollapsed: Int = MAX_LINES_COLLAPSED,
    textStyle: TextStyle = AppTheme.typography.bodyMedium,
    textColor: Color = AppTheme.colors.textPrimary,
    showMoreLabel: String = "...",
    showLessLabel: String = "",
) {
    val labelStyle = SpanStyle(
        fontWeight = textStyle.fontWeight,
        fontSize = textStyle.fontSize,
        fontStyle = textStyle.fontStyle,
        fontFamily = textStyle.fontFamily,
        color = textColor.copy(alpha = 0.6f),
    )

    var isExpanded by remember { mutableStateOf(false) }
    var clickable by remember { mutableStateOf(false) }
    var lastCharIndex by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier
            .clickable(clickable) { isExpanded = !isExpanded }
            .then(modifier)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                        if (showLessLabel.isNotEmpty()) {
                            withStyle(style = labelStyle) { append(showLessLabel) }
                        }
                    } else {
                        val adjustText = text
                            .substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLast(showMoreLabel.length)
                        append(adjustText)
                        withStyle(style = labelStyle) { append(showMoreLabel) }
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else maxLinesCollapsed,
            onTextLayout = { textLayoutResult ->
                if (!isExpanded && textLayoutResult.hasVisualOverflow) {
                    clickable = true
                    lastCharIndex = textLayoutResult.getLineEnd(maxLinesCollapsed - 1)
                }
            },
            style = textStyle,
            color = textColor,
        )
    }
}

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    text: String,
    maxLinesCollapsed: Int = MAX_LINES_COLLAPSED,
    textStyle: TextStyle = AppTheme.typography.bodyMedium,
    textColor: Color = AppTheme.colors.textPrimary,
    showMoreLabel: String = "...",
    showLessLabel: String = "",
) {
    ExpandableText(
        modifier = modifier,
        text = AnnotatedString(text),
        maxLinesCollapsed = maxLinesCollapsed,
        textStyle = textStyle,
        textColor = textColor,
        showMoreLabel = showMoreLabel,
        showLessLabel = showLessLabel,
    )
}
