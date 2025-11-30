package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.header.Header

val headerDefault = ViewCase(
    title = "headerDefault",
    content = {
        val titleState = rememberViewCaseState("header_title", "Action")
        val widthState = rememberViewCaseState("header_width", 250f)
        val cornerRadiusState = rememberViewCaseState("header_corner", 0f)
        val hasClickState = rememberViewCaseState("header_click", true)

        val modifier = if (cornerRadiusState.value > 0) {
            Modifier.width(widthState.value.toInt().dp)
                .clip(RoundedCornerShape(cornerRadiusState.value.toInt().dp))
        } else {
            Modifier.width(widthState.value.toInt().dp)
        }
        
        Header(
            modifier = modifier,
            title = titleState.value,
            onClick = if (hasClickState.value) {
                {}
            } else null,
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("header_title", "Action")
        val widthState = rememberViewCaseState("header_width", 250f)
        val cornerRadiusState = rememberViewCaseState("header_corner", 0f)
        val hasClickState = rememberViewCaseState("header_click", true)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 4f,
                onChange = { cornerRadiusState.value = it }
            ),
            ViewParameter.BooleanParameter(
                label = "Has Click Action",
                value = hasClickState.value,
                onChange = { hasClickState.value = it }
            )
        )
    }
)

val headerIconLess = ViewCase(
    title = "headerIconLess",
    content = {
        val titleState = rememberViewCaseState("header_iconless_title", "Action")
        val widthState = rememberViewCaseState("header_iconless_width", 250f)

        Header(
            modifier = Modifier.width(widthState.value.toInt().dp),
            title = titleState.value,
            onClick = null,
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("header_iconless_title", "Action")
        val widthState = rememberViewCaseState("header_iconless_width", 250f)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            )
        )
    }
)

val headerShaped = ViewCase(
    title = "headerShaped",
    content = {
        val titleState = rememberViewCaseState("header_shaped_title", "Action")
        val widthState = rememberViewCaseState("header_shaped_width", 250f)
        val cornerRadiusState = rememberViewCaseState("header_shaped_corner", 16f)

        Header(
            modifier = Modifier.width(widthState.value.toInt().dp)
                .clip(RoundedCornerShape(cornerRadiusState.value.toInt().dp)),
            title = titleState.value,
            onClick = {},
        )
    },
    parameters = {
        val titleState = rememberViewCaseState("header_shaped_title", "Action")
        val widthState = rememberViewCaseState("header_shaped_width", 250f)
        val cornerRadiusState = rememberViewCaseState("header_shaped_corner", 16f)

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 100f,
                max = 500f,
                step = 10f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Corner Radius",
                value = cornerRadiusState.value,
                min = 0f,
                max = 32f,
                step = 4f,
                onChange = { cornerRadiusState.value = it }
            )
        )
    }
)
