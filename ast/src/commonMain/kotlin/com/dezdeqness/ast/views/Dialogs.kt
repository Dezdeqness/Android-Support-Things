@file:Folder("Dialogs")

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
import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.bottomsheet.SingleChoiceBottomSheet
import com.dezdeqness.core.ui.views.buttons.AppPrimaryButton
import com.dezdeqness.core.ui.views.dialogs.MultiSelectDialog
import com.dezdeqness.core.ui.views.dialogs.SingleChoiceDialog
import kotlinx.coroutines.launch

@ViewCaseEntry(name = "Single Choice Dialog Default", path = ["Single Choice Dialog"])
val singleChoiceDialogDefault = ViewCase(
    title = "singleChoiceDialogDefault",
    content = {
        val titleState = rememberViewCaseState("dlg_title", "Action")
        val showTitleState = rememberViewCaseState("dlg_show_title", true)
        val widthState = rememberViewCaseState("dlg_width", 250f)
        val dataState = rememberViewCaseState("dlg_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_selected", "green")
        var isDialogVisible by remember { mutableStateOf(false) }

        AppPrimaryButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceDialog(
                modifier = Modifier.width(widthState.value.toInt().dp),
                title = if (showTitleState.value) titleState.value else null,
                values = dataState.value,
                selectedValue = selectedState.value,
                valueText = { it },
                onValueSelected = { _ ->
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                },
            )
        }
    },
    parameters = {
        val titleState = rememberViewCaseState("dlg_title", "Action")
        val showTitleState = rememberViewCaseState("dlg_show_title", true)
        val widthState = rememberViewCaseState("dlg_width", 250f)
        val dataState = rememberViewCaseState("dlg_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_selected", "green")

        listOf(
            ViewParameter.BooleanParameter(
                label = "Show Title",
                value = showTitleState.value,
                onChange = { showTitleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 400f,
                step = 50f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.ListParameter(
                label = "Items",
                value = dataState.value,
                onChange = { dataState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Selected Item",
                options = dataState.value + "none",
                selectedValue = selectedState.value,
                onChange = { selectedState.value = dataState.value.getOrNull(it) ?: "" }
            )
        )
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@ViewCaseEntry(name = "Single Choice Bottom Sheet Default", path = ["Single Choice Bottom Sheet"])
val singleChoiceBottomSheetDefault = ViewCase(
    title = "singleChoiceBottomSheetDefault",
    content = {
        val titleState = rememberViewCaseState("bs_title", "Action")
        val showTitleState = rememberViewCaseState("bs_show_title", true)
        val dataState = rememberViewCaseState("dlg_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_selected", "green")

        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        var isDialogVisible by remember { mutableStateOf(false) }

        AppPrimaryButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceBottomSheet(
                state = sheetState,
                title = if (showTitleState.value) titleState.value else null,
                values = dataState.value,
                selectedValue = selectedState.value,
                valueText = { it },
                onValueSelected = { _ ->
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
    },
    parameters = {
        val titleState = rememberViewCaseState("bs_title", "Action")
        val showTitleState = rememberViewCaseState("bs_show_title", true)
        val dataState = rememberViewCaseState("dlg_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_selected", "green")

        listOf(
            ViewParameter.BooleanParameter(
                label = "Show Title",
                value = showTitleState.value,
                onChange = { showTitleState.value = it }
            ),
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.ListParameter(
                label = "Items",
                value = dataState.value,
                onChange = { dataState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Selected Item",
                options = dataState.value + "none",
                selectedValue = selectedState.value,
                onChange = { selectedState.value = dataState.value.getOrNull(it) ?: "" }
            )
        )
    }
)

@ViewCaseEntry(name = "Single Choice Dialog Header Less", path = ["Single Choice Dialog"])
val singleChoiceDialogHeaderLess = ViewCase(
    title = "singleChoiceDialogHeaderLess",
    content = {
        val widthState = rememberViewCaseState("dlg_hl_width", 250f)
        val dataState = rememberViewCaseState("dlg_hl_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_hl_selected", "green")
        var isDialogVisible by remember { mutableStateOf(false) }

        AppPrimaryButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceDialog(
                modifier = Modifier.width(widthState.value.toInt().dp),
                title = null,
                values = dataState.value,
                selectedValue = selectedState.value,
                valueText = { it },
                onValueSelected = { _ ->
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                },
            )
        }
    },
    parameters = {
        val widthState = rememberViewCaseState("dlg_hl_width", 250f)
        val dataState = rememberViewCaseState("dlg_hl_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("dlg_hl_selected", "green")

        listOf(
            ViewParameter.DensityParameter(
                label = "Width",
                value = widthState.value,
                min = 200f,
                max = 400f,
                step = 50f,
                onChange = { widthState.value = it }
            ),
            ViewParameter.ListParameter(
                label = "Items",
                value = dataState.value,
                onChange = { dataState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Selected Item",
                options = dataState.value + "none",
                selectedValue = selectedState.value,
                onChange = { selectedState.value = dataState.value.getOrNull(it) ?: "" }
            )
        )
    }
)

@ViewCaseEntry(name = "Multi Select Dialog")
val multiSelectDialogDefault = ViewCase(
    title = "multiSelectDialogDefault",
    content = {
        val titleState = rememberViewCaseState("msd_title", "Select genres")
        val dataState = rememberViewCaseState(
            "msd_data",
            listOf("Action", "Comedy", "Drama", "Romance", "Sci-Fi")
        )
        val selectedState = rememberViewCaseState("msd_selected", listOf("Action", "Drama"))
        var isDialogVisible by remember { mutableStateOf(false) }

        AppPrimaryButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            MultiSelectDialog(
                title = titleState.value,
                items = dataState.value,
                selectedItems = selectedState.value,
                itemText = { it },
                onConfirm = { selected ->
                    selectedState.value = selected
                    isDialogVisible = false
                },
                onDismiss = {
                    isDialogVisible = false
                },
            )
        }
    },
    parameters = {
        val titleState = rememberViewCaseState("msd_title", "Select genres")
        val dataState = rememberViewCaseState(
            "msd_data",
            listOf("Action", "Comedy", "Drama", "Romance", "Sci-Fi")
        )
        val selectedState = rememberViewCaseState("msd_selected", listOf("Action", "Drama"))

        listOf(
            ViewParameter.StringParameter(
                label = "Title",
                value = titleState.value,
                onChange = { titleState.value = it }
            ),
            ViewParameter.ListParameter(
                label = "Items",
                value = dataState.value,
                onChange = { dataState.value = it }
            ),
            ViewParameter.ListParameter(
                label = "Selected Items",
                value = selectedState.value,
                onChange = { selectedState.value = it }
            ),
        )
    }
)

@OptIn(ExperimentalMaterial3Api::class)
@ViewCaseEntry(
    name = "Single Choice Bottom Sheet Header Less",
    path = ["Single Choice Bottom Sheet"]
)
val singleChoiceBottomSheetHeaderLess = ViewCase(
    title = "singleChoiceBottomSheetHeaderLess",
    content = {
        val dataState = rememberViewCaseState("bs_hl_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("bs_hl_selected", "green")

        val scope = rememberCoroutineScope()
        val sheetState = rememberModalBottomSheetState()
        var isDialogVisible by remember { mutableStateOf(false) }

        AppPrimaryButton(
            title = "Click",
            onClick = {
                isDialogVisible = true
            }
        )

        if (isDialogVisible) {
            SingleChoiceBottomSheet(
                state = sheetState,
                title = null,
                values = dataState.value,
                selectedValue = selectedState.value,
                valueText = { it },
                onValueSelected = { _ ->
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
    },
    parameters = {
        val dataState = rememberViewCaseState("bs_hl_data", listOf("blue", "red", "green"))
        val selectedState = rememberViewCaseState("bs_hl_selected", "green")

        listOf(
            ViewParameter.ListParameter(
                label = "Items",
                value = dataState.value,
                onChange = { dataState.value = it }
            ),
            ViewParameter.ChoiceParameter(
                label = "Selected Item",
                options = dataState.value + "none",
                selectedValue = selectedState.value,
                onChange = { selectedState.value = dataState.value.getOrNull(it) ?: "" }
            )
        )
    }
)
