package com.dezdeqness.ast.viewbook.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

@Composable
fun <T> rememberViewCaseState(key: String, initialValue: T): MutableState<T> {
    val stateMap = LocalViewCaseState.current

    @Suppress("UNCHECKED_CAST")
    return stateMap.getOrPut(key) {
        mutableStateOf(initialValue)
    } as MutableState<T>
}
