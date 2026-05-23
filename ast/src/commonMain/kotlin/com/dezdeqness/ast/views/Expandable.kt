package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.buttons.AppPrimaryButton
import com.dezdeqness.core.ui.views.expandable.ExpandableContent
import com.dezdeqness.core.ui.views.expandable.ExpandableText

private val textStyleOptions = listOf(
    "Body Small", "Body Medium", "Body Large",
    "Title Small", "Title Medium", "Title Large",
    "Label Small", "Label Medium", "Label Large",
)

@Composable
private fun resolveTextStyle(index: Int): TextStyle {
    return when (index) {
        0 -> AppTheme.typography.bodySmall
        1 -> AppTheme.typography.bodyMedium
        2 -> AppTheme.typography.bodyLarge
        3 -> AppTheme.typography.titleSmall
        4 -> AppTheme.typography.titleMedium
        5 -> AppTheme.typography.titleLarge
        6 -> AppTheme.typography.labelSmall
        7 -> AppTheme.typography.labelMedium
        8 -> AppTheme.typography.labelLarge
        else -> AppTheme.typography.bodyMedium
    }
}

private const val SAMPLE_TEXT =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
            "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
            "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
            "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. " +
            "Curabitur pretium tincidunt lacus. Nulla gravida orci a odio. Nullam varius, turpis et commodo pharetra."

val expandableContentDefault = ViewCase(
    title = "expandableContentDefault",
    content = {
        val isVisibleState = rememberViewCaseState("ec_visible", true)
        val widthState = rememberViewCaseState("ec_width", 350f)

        Column(
            modifier = Modifier.width(widthState.value.toInt().dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            AppPrimaryButton(
                title = if (isVisibleState.value) "Hide" else "Show",
                onClick = { isVisibleState.value = !isVisibleState.value },
            )

            ExpandableContent(isVisible = isVisibleState.value) {
                Column(
                    modifier = Modifier.fillMaxWidth().padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Text("First item", color = AppTheme.colors.textPrimary)
                    Text("Second item", color = AppTheme.colors.textPrimary)
                    Text("Third item", color = AppTheme.colors.textPrimary)
                    Text("Fourth item", color = AppTheme.colors.textPrimary)
                }
            }
        }
    },
    parameters = {
        val isVisibleState = rememberViewCaseState("ec_visible", true)
        val widthState = rememberViewCaseState("ec_width", 350f)

        listOf(
            ViewParameter.BooleanParameter(
                label = "Visible",
                value = isVisibleState.value,
                onChange = { isVisibleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 150f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
        )
    }
)

val expandableTextDefault = ViewCase(
    title = "expandableTextDefault",
    content = {
        val textState = rememberViewCaseState("exp_text", SAMPLE_TEXT)
        val maxLinesState = rememberViewCaseState("exp_max_lines", 3)
        val widthState = rememberViewCaseState("exp_width", 350f)
        val showMoreState = rememberViewCaseState("exp_show_more", "...")
        val showLessState = rememberViewCaseState("exp_show_less", " Show less")
        val textStyleState = rememberViewCaseState("exp_text_style", 1)

        ExpandableText(
            modifier = Modifier.width(widthState.value.toInt().dp),
            text = textState.value,
            maxLinesCollapsed = maxLinesState.value,
            textStyle = resolveTextStyle(textStyleState.value),
            textColor = AppTheme.colors.textPrimary,
            showMoreLabel = showMoreState.value,
            showLessLabel = showLessState.value,
        )
    },
    parameters = {
        val textState = rememberViewCaseState("exp_text", SAMPLE_TEXT)
        val maxLinesState = rememberViewCaseState("exp_max_lines", 3)
        val widthState = rememberViewCaseState("exp_width", 350f)
        val showMoreState = rememberViewCaseState("exp_show_more", "...")
        val showLessState = rememberViewCaseState("exp_show_less", " Show less")
        val textStyleState = rememberViewCaseState("exp_text_style", 1)

        listOf(
            ViewParameter.StringParameter(
                label = "Text",
                value = textState.value,
                onChange = { textState.value = it }
            ),
            ViewParameter.IntParameter(
                label = "Max Lines Collapsed",
                value = maxLinesState.value,
                min = 1,
                max = 10,
                onChange = { maxLinesState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 150f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Text Style",
                options = textStyleOptions,
                selectedValue = textStyleState.value,
                onChange = { textStyleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Show More Label",
                value = showMoreState.value,
                onChange = { showMoreState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Show Less Label",
                value = showLessState.value,
                onChange = { showLessState.value = it }
            ),
        )
    }
)
