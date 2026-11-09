package com.dezdeqness.core.settings

interface SettingsPreference<T> {
    val name: String
    val default: T
    val handler: PreferenceHandler<T>
}
