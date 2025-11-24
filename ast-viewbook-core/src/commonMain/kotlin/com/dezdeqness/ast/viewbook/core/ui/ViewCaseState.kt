package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

@Composable
fun <T> rememberViewCaseState(key: String, initialValue: T): MutableState<T> {
    val holder = LocalViewCaseState.current
    val fullKey = "${holder.viewCaseId}:$key"

    @Suppress("UNCHECKED_CAST")
    return holder.stateMap.getOrPut(fullKey) {
        mutableStateOf(initialValue)
    } as MutableState<T>
}
