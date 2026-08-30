@file:Folder("Settings")

package com.dezdeqness.ast.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.core.ui.theme.AppTheme
import com.dezdeqness.core.ui.views.header.Header
import com.dezdeqness.core.ui.views.sections.AppSections

@ViewCaseEntry(name = "App Section Default")
val appSectionDefault = ViewCase(
    title = "appSectionDefault",
    content = {
        AppSections(
            modifier = Modifier.width(400.dp).clip(RoundedCornerShape(12.dp)),
            header = {
                Header(
                    title = "History",
                )
            },
            items = listOf("Item", "Item long enough", "Really long item that can hold even 3 lines, trust me"),
            itemContent = { item ->
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color.Green),
                    )
                    Text(
                        item,
                        modifier = Modifier.width(150.dp),
                        style = AppTheme.typography.bodyMedium,
                        color = AppTheme.colors.textPrimary,
                    )
                }
            }

        )
    }
)
