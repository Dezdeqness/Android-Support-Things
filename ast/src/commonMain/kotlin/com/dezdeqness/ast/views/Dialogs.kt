package com.dezdeqness.ast.views

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.views.bottomsheet.SingleChoiceBottomSheet
import com.dezdeqness.core.ui.views.buttons.AppButton
import com.dezdeqness.core.ui.views.dialogs.SingleChoiceDialog
import kotlinx.coroutines.launch

val singleChoiceDialogDefault = ViewCase(
    title = "singleChoiceDialogDefault",
    content = {
        var isDialogVisible by remember {
            mutableStateOf(false)
        }

        AppButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceDialog(
                modifier = Modifier.width(250.dp),
                title = "Action",
                values = (7..13).toList(),
                selectedValue = 8,
                valueText = { it.toString() },
                onValueSelected = { size ->
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                },
            )
        }

    }
)

val singleChoiceDialogHeaderLess = ViewCase(
    title = "singleChoiceDialogHeaderLess",
    content = {
        var isDialogVisible by remember {
            mutableStateOf(false)
        }

        AppButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceDialog(
                modifier = Modifier.width(250.dp),
                values = (7..13).toList(),
                selectedValue = 8,
                valueText = { it.toString() },
                onValueSelected = { size ->
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                },
            )
        }

    }
)

@OptIn(ExperimentalMaterial3Api::class)
val singleChoiceBottomSheetDefault = ViewCase(
    title = "singleChoiceBottomSheetDefault",
    content = {
        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        var isDialogVisible by remember {
            mutableStateOf(false)
        }

        AppButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceBottomSheet(
                state = sheetState,
                title = "Action",
                values = (7..13).toList(),
                selectedValue = 8,
                valueText = { it.toString() },
                onValueSelected = { size ->
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (sheetState.isVisible.not()) {
                            isDialogVisible = false
                        }
                    }
                },
                onDismiss = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (sheetState.isVisible.not()) {
                            isDialogVisible = false
                        }
                    }
                },
            )
        }

    }
)

@OptIn(ExperimentalMaterial3Api::class)
val singleChoiceBottomSheetHeaderLess = ViewCase(
    title = "singleChoiceBottomSheetHeaderLess",
    content = {
        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        var isDialogVisible by remember {
            mutableStateOf(false)
        }

        AppButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceBottomSheet(
                state = sheetState,
                values = (7..13).toList(),
                selectedValue = 8,
                valueText = { it.toString() },
                onValueSelected = { size ->
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (sheetState.isVisible.not()) {
                            isDialogVisible = false
                        }
                    }
                },
                onDismiss = {
                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (sheetState.isVisible.not()) {
                            isDialogVisible = false
                        }
                    }
                },
            )
        }

    }
)
