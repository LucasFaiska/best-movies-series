package com.lfaiska.bestmoviesseries.data.repository.language

interface LanguageRepository {
    fun getSelectedLanguage() : LanguageModel
    fun setSelectedLanguage(language: LanguageModel)
}