package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.metadata.MetadataRow

private val metaTextStyleOptions = listOf(
    "Default (14sp)", "Small (12sp)", "Medium (16sp)", "Large (18sp)",
)

@Composable
private fun resolveMetaLabelStyle(index: Int): TextStyle {
    return when (index) {
        0 -> TextStyle(fontSize = 14.sp)
        1 -> TextStyle(fontSize = 12.sp)
        2 -> TextStyle(fontSize = 16.sp)
        3 -> TextStyle(fontSize = 18.sp)
        else -> TextStyle(fontSize = 14.sp)
    }
}

@Composable
private fun resolveMetaValueStyle(index: Int): TextStyle {
    return when (index) {
        0 -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
        1 -> TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Medium)
        2 -> TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium)
        3 -> TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Medium)
        else -> TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium)
    }
}

val metadataRowDefault = ViewCase(
    title = "metadataRowDefault",
    content = {
        val labelState = rememberViewCaseState("meta_label", "Status")
        val valueState = rememberViewCaseState("meta_value", "Completed")
        val widthState = rememberViewCaseState("meta_width", 350f)
        val textSizeState = rememberViewCaseState("meta_text_size", 0)

        MetadataRow(
            label = labelState.value,
            value = valueState.value,
            modifier = Modifier.width(widthState.value.toInt().dp),
            labelStyle = resolveMetaLabelStyle(textSizeState.value),
            valueStyle = resolveMetaValueStyle(textSizeState.value),
        )
    },
    parameters = {
        val labelState = rememberViewCaseState("meta_label", "Status")
        val valueState = rememberViewCaseState("meta_value", "Completed")
        val widthState = rememberViewCaseState("meta_width", 350f)
        val textSizeState = rememberViewCaseState("meta_text_size", 0)

        listOf(
            ViewParameter.StringParameter(
                label = "Label",
                value = labelState.value,
                onChange = { labelState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Value",
                value = valueState.value,
                onChange = { valueState.value = it }
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
                label = "Text Size",
                options = metaTextStyleOptions,
                selectedValue = textSizeState.value,
                onChange = { textSizeState.value = it }
            ),
        )
    }
)

val metadataRowList = ViewCase(
    title = "metadataRowList",
    content = {
        val widthState = rememberViewCaseState("meta_list_width", 350f)

        Column(
            modifier = Modifier.width(widthState.value.toInt().dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            MetadataRow(label = "Type", value = "TV Series")
            MetadataRow(label = "Episodes", value = "24")
            MetadataRow(label = "Status", value = "Completed")
            MetadataRow(label = "Rating", value = "R-17+")
            MetadataRow(label = "Score", value = "8.54")
        }
    },
    parameters = {
        val widthState = rememberViewCaseState("meta_list_width", 350f)

        listOf(
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
