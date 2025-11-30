package com.dezdeqness.ast.viewbook.core

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalListContent
import com.dezdeqness.ast.viewbook.core.ui.ViewBookDrawer
import com.dezdeqness.ast.viewbook.core.ui.ViewCasePreview
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase

@Composable
fun ViewBook(
    modifier: Modifier = Modifier,
    viewBookState: ViewBookState,
    isDarkTheme: Boolean = false,
) {
    val currentViewCase = remember {
        mutableStateOf(getFirstViewCase(viewBookState.hierarchicalItems))
    }

    val viewCase = currentViewCase.value ?: return

    MaterialTheme(colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()) {
        ViewBookDrawer(
            modifier = Modifier.width(300.dp),
            drawerContent = {
                Column(
                    modifier = modifier.fillMaxHeight().padding(8.dp),
                ) {
                    Box(modifier = Modifier.weight(1f)) {
                        HierarchicalListContent(
                            items = viewBookState.hierarchicalItems,
                            selectedValue = viewCase,
                            onValueSelected = { selectedViewCase ->
                                currentViewCase.value = selectedViewCase
                            },
                            contentColor = MaterialTheme.colorScheme.surface
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            viewBookState.switchTheme()
                        },
                    ) {
                        Text("Switch theme")
                    }
                }
            },
            viewCaseContent = {
                ViewCasePreview(
                    viewCase = viewCase,
                    modifier = Modifier.background(MaterialTheme.colorScheme.secondaryContainer)
                )
            }
        )
    }
}

private fun getFirstViewCase(items: List<HierarchicalItem<ViewCase>>): ViewCase? {
    for (item in items) {
        when (item) {
            is HierarchicalItem.Item -> return item.value
            is HierarchicalItem.Folder -> {
                val firstChild = getFirstViewCase(item.children)
                if (firstChild != null) return firstChild
            }
        }
    }
    return null
}
