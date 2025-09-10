package com.dezdeqness.ast.views

import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.views.chips.AppChip

val chipDefault = ViewCase(
    title = "chipDefault",
    content = {
        AppChip(title = "Action")
    }
)
