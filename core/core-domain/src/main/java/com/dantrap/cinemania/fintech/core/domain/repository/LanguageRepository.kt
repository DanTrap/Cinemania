package com.dantrap.cinemania.fintech.core.domain.repository

import kotlinx.coroutines.flow.Flow

interface LanguageRepository {

    fun language(): Flow<String>

    fun changeLanguage(newLanguage: String)
}
