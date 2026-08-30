package com.dezdeqness.ast.viewbook.core

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.ui.CountBadge
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalItem
import com.dezdeqness.ast.viewbook.core.ui.HierarchicalListContent
import com.dezdeqness.ast.viewbook.core.ui.ViewBookDrawer
import com.dezdeqness.ast.viewbook.core.ui.ViewCasePreview
import com.dezdeqness.ast.viewbook.core.ui.countItems
import com.dezdeqness.ast.viewbook.core.ui.findPath
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.theme.AppTheme

@Composable
fun ViewBook(
    modifier: Modifier = Modifier,
    viewBookState: ViewBookState,
    isDarkTheme: Boolean = false,
) {
    val currentViewCase = remember {
        mutableStateOf(getFirstViewCase(viewBookState.hierarchicalItems))
    }
    var filterQuery by remember { mutableStateOf("") }

    val viewCase = currentViewCase.value ?: return

    ViewBookDrawer(
        modifier = Modifier.width(300.dp),
        drawerContent = {
                Column(
                    modifier = modifier.fillMaxHeight().padding(8.dp),
                ) {
                    FilterField(
                        query = filterQuery,
                        onQueryChange = { filterQuery = it },
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    AllComponentsRow(
                        count = countItems(viewBookState.hierarchicalItems),
                        onClick = { filterQuery = "" },
                    )

                    Box(modifier = Modifier.weight(1f)) {
                        HierarchicalListContent(
                            items = viewBookState.hierarchicalItems,
                            selectedValue = viewCase,
                            onValueSelected = { selectedViewCase ->
                                currentViewCase.value = selectedViewCase
                            },
                            contentColor = MaterialTheme.colorScheme.surface,
                            filterQuery = filterQuery,
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = { viewBookState.switchTheme() },
                    ) {
                        Text("Switch theme")
                    }
                }
            },
            viewCaseContent = {
                Column(modifier = Modifier.fillMaxHeight()) {
                    ViewCaseHeader(
                        path = findPath(viewBookState.hierarchicalItems, viewCase).orEmpty(),
                        fallbackTitle = viewCase.title,
                    )

                    Box(modifier = Modifier.weight(1f)) {
                        ViewCasePreview(
                            viewCase = viewCase,
                            isDarkTheme = isDarkTheme,
                            modifier = Modifier.fillMaxSize(),
                        )
                    }
                }
            }
    )
}

@Composable
private fun FilterField(
    query: String,
    onQueryChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        placeholder = { Text("Filter…", style = AppTheme.typography.bodyMedium) },
    )
}

@Composable
private fun AllComponentsRow(
    count: Int,
    onClick: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 12.dp),
    ) {
        Text(
            text = "All components",
            style = AppTheme.typography.bodyMedium,
            color = AppTheme.colors.textPrimary,
            modifier = Modifier.weight(1f),
        )
        CountBadge(count = count)
    }
}

@Composable
private fun ViewCaseHeader(
    path: List<String>,
    fallbackTitle: String,
) {
    val title = path.lastOrNull() ?: fallbackTitle
    val breadcrumbs = path.dropLast(1)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        if (breadcrumbs.isNotEmpty()) {
            Text(
                text = breadcrumbs.joinToString(" / "),
                style = AppTheme.typography.labelMedium,
                color = AppTheme.colors.textSecondary,
            )
        }
        Text(
            text = title,
            style = AppTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold,
            color = AppTheme.colors.textPrimary,
        )
    }
    HorizontalDivider()
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
