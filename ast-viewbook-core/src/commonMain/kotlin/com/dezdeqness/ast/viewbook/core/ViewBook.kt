package com.dezdeqness.ast.viewbook.core

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.ViewBookDrawer
import com.dezdeqness.ast.viewbook.core.ui.ViewCasePreview

@Composable
fun ViewBook(
    modifier: Modifier = Modifier,
    viewBookState: ViewBookState,
    isDarkTheme: Boolean = false,
) {
    val currentViewCase = remember {
        mutableStateOf(viewBookState.viewCases.firstOrNull())
    }

    val viewCase = currentViewCase.value ?: return

    MaterialTheme(colorScheme = if (isDarkTheme) darkColorScheme() else lightColorScheme()) {
        ViewBookDrawer(
            modifier = Modifier.width(300.dp),
            drawerContent = {
                LazyColumn(
                    modifier = modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    contentPadding = PaddingValues(8.dp),
                ) {
                    items(viewBookState.viewCases.size) { index ->
                        val item = viewBookState.viewCases[index]
                        val isActiveViewCase = viewCase.title == item.title
                        Box(
                            modifier = modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .background(
                                    color = MaterialTheme.colorScheme.primaryContainer,
                                    shape = RoundedCornerShape(12.dp),
                                ).clickable { currentViewCase.value = item },
                        ) {
                            Text(
                                text = item.title,
                                fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                                fontWeight = if (isActiveViewCase) FontWeight.SemiBold else FontWeight.Normal,
                                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                            )
                        }
                    }

                    item {
                        Button(
                            onClick = {
                                viewBookState.switchTheme()
                            },
                        ) {
                            Text("Switch theme")
                        }
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
