@file:Folder("Buttons")

package com.dezdeqness.ast.views

import com.dezdeqness.ast.viewbook.core.ui.rememberViewCaseState
import com.dezdeqness.ast.viewbook.core.viewcase.Folder
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.ast.viewbook.core.viewcase.ViewCaseEntry
import com.dezdeqness.ast.viewbook.core.viewcase.ViewParameter
import com.dezdeqness.core.ui.views.chips.AppChip

@ViewCaseEntry(name = "Chip Default")
val chipDefault = ViewCase(
    title = "chipDefault",
    content = {
        val chipTitleOptions = listOf("Action", "Submit", "Cancel", "Confirm", "Delete")
        val selectedChipIndex = rememberViewCaseState("chip_idx", 0)

        AppChip(
            title = chipTitleOptions[selectedChipIndex.value],
        )
    },
    parameters = {
        val chipTitleOptions = listOf("Action", "Submit", "Cancel", "Confirm", "Delete")
        val selectedChipIndex = rememberViewCaseState("chip_idx", 0)

        listOf(
            ViewParameter.ChoiceParameter(
                label = "Chip Title",
                options = chipTitleOptions,
                selectedValue = selectedChipIndex.value,
                onChange = { selectedChipIndex.value = it }
            ),
        )
    }
)
