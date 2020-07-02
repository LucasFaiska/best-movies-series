package com.lfaiska.bestmoviesseries.data.repository.language

import com.lfaiska.bestmoviesseries.data.preference.Preference
import com.lfaiska.bestmoviesseries.data.preference.entity.LanguagePreferenceEntity

class LanguageRepositoryImpl(private val preference: Preference) : LanguageRepository {
    override fun getSelectedLanguage(): LanguageModel {
        return preference.get(LanguagePreferenceEntity::class.java)?.let { language ->
            LanguageModel(language.id, language.name)
        } ?: run {
            throw LanguageRepositoryException("getSelectedLanguage")
        }
    }

    override fun setSelectedLanguage(language: LanguageModel) {
        language.apply {
            preference.put(
                LanguagePreferenceEntity(this.id, this.name),
                LanguagePreferenceEntity::class.java
            )
        }
    }
}