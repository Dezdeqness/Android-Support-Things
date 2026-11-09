package com.dezdeqness.core.settings.handlers

import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import com.dezdeqness.core.settings.PreferenceHandler
import com.dezdeqness.core.settings.SettingsPreference

object BooleanHandler : PreferenceHandler<Boolean> {
    override fun read(prefs: Preferences, key: SettingsPreference<Boolean>): Boolean? =
        prefs[booleanPreferencesKey(key.name)]

    override fun write(
        prefs: MutablePreferences,
        key: SettingsPreference<Boolean>,
        value: Boolean
    ) {
        prefs[booleanPreferencesKey(key.name)] = value
    }
}
