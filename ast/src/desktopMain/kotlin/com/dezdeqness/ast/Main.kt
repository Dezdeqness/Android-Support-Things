package com.dezdeqness.ast

import androidx.compose.ui.window.singleWindowApplication
import com.dezdeqness.ast.generated.generatedViewBookItems

fun main() {
    singleWindowApplication {
        App(items = generatedViewBookItems())
    }
}
