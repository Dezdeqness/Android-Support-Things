package com.dezdeqness.core.utils

import com.dezdeqness.core.dispatcher.CoroutineDispatcherProvider
import kotlinx.coroutines.Dispatchers

class TestCoroutineDispatcherProvider : CoroutineDispatcherProvider {
    override fun main() = Dispatchers.Unconfined

    override fun io() = Dispatchers.Unconfined

    override fun computation() = Dispatchers.Unconfined
}
