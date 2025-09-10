package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase

@Composable
fun ViewCasePreview(
    modifier: Modifier = Modifier,
    viewCase: ViewCase
) {
    Row(modifier) {
        Column(modifier = Modifier.fillMaxHeight().weight(0.75f)) {
            Box(
                modifier = Modifier.fillMaxSize().weight(0.5f).clipToBounds(),
                contentAlignment = Alignment.Center
            ) {
                viewCase.content(viewCase)
            }
            HorizontalDivider()
        }
    }
}