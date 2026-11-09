package com.dezdeqness.core.settings

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences

interface PreferenceHandler<T> {
    fun read(prefs: Preferences, key: SettingsPreference<T>): T?
    fun write(prefs: MutablePreferences, key: SettingsPreference<T>, value: T)
}
