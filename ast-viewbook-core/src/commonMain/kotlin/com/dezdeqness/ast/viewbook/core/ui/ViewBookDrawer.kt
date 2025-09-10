package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.PermanentDrawerSheet
import androidx.compose.material3.PermanentNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun ViewBookDrawer(
    modifier: Modifier = Modifier,
    drawerContent: @Composable ColumnScope.() -> Unit,
    viewCaseContent: @Composable () -> Unit,
) {
    PermanentNavigationDrawer(
        drawerContent = {
            PermanentDrawerSheet(content = drawerContent, modifier = modifier)
        },
        content = viewCaseContent,
    )
}
