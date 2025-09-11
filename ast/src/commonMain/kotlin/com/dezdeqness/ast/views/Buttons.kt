package com.dezdeqness.ast.views

import com.dezdeqness.ast.viewbook.core.viewcase.ViewCase
import com.dezdeqness.core.ui.views.buttons.AppButton
import com.dezdeqness.core.ui.views.buttons.AppOutlinedButton
import com.dezdeqness.core.ui.views.buttons.AppTextButton

val buttonDefault = ViewCase(
    title = "buttonDefault",
    content = {
        AppButton(title = "Authorize")
    }
)

val buttonOutlined = ViewCase(
    title = "buttonOutlined",
    content = {
        AppOutlinedButton(title = "Authorize")
    }
)

val buttonText = ViewCase(
    title = "buttonText",
    content = {
        AppTextButton(title = "Authorize")
    }
)
