package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.views.header.Header

val headerDefault = ViewCase(
    title = "headerDefault",
    content = {
        Header(
            modifier = Modifier.width(250.dp),
            title = "Action",
            onClick = {},
        )
    }
)

val headerIconLess = ViewCase(
    title = "headerIconLess",
    content = {
        Header(
            modifier = Modifier.width(250.dp),
            title = "Action",
        )
    }
)

val headerShaped = ViewCase(
    title = "headerShaped",
    content = {
        Header(
            modifier = Modifier.width(250.dp).clip(RoundedCornerShape(12.dp)),
            title = "Action",
        )
    }
)
