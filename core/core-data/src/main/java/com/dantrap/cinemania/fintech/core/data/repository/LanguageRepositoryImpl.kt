package com.dantrap.cinemania.fintech.core.data.repository

import android.content.Context
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.dantrap.cinemania.fintech.core.domain.repository.LanguageRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

internal class LanguageRepositoryImpl(private val context: Context) : LanguageRepository {

    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "language")

    override fun language(): Flow<String> = context.dataStore.data.map { preferences ->
        preferences[languageKey] ?: context.resources.configuration.locales[0].language
    }

    override fun changeLanguage(newLanguage: String) {
        CoroutineScope(SupervisorJob()).launch(Dispatchers.Main) {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(newLanguage))
            withContext(Dispatchers.IO) {
                setLanguage(newLanguage)
            }
        }
    }

    private suspend fun setLanguage(language: String) {
        context.dataStore.edit { savedLanguage ->
            savedLanguage[languageKey] = language
        }
    }

    private companion object {
        val languageKey = stringPreferencesKey("language_key")
    }
}
