package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase

data class ViewCaseStateHolder(
    val stateMap: MutableMap<String, Any>,
    val viewCaseId: String
)

val LocalViewCaseState = compositionLocalOf<ViewCaseStateHolder> {
    error("No ViewCaseState provided")
}

@Composable
fun ViewCasePreview(
    modifier: Modifier = Modifier,
    viewCase: ViewCase
) {
    val state = remember(viewCase.title) { mutableStateMapOf<String, Any>() }
    val stateHolder = remember(viewCase.title) {
        ViewCaseStateHolder(state, viewCase.title)
    }

    CompositionLocalProvider(LocalViewCaseState provides stateHolder) {
        Row(modifier) {
            Column(modifier = Modifier.fillMaxHeight().weight(1f)) {
                Box(
                    modifier = Modifier.fillMaxSize().weight(0.5f).clipToBounds(),
                    contentAlignment = Alignment.Center
                ) {
                    viewCase.content(viewCase)
                }
                HorizontalDivider()
            }

            val parameters = viewCase.parameters()

            if (parameters.isNotEmpty()) {
                VerticalDivider()
                ParametersList(
                    parameters = parameters
                )
            }
        }
    }
}