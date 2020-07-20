package com.lfaiska.bestmoviesseries.data.repository.language

import com.lfaiska.bestmoviesseries.data.preference.Preference
import com.lfaiska.bestmoviesseries.data.preference.entity.LanguagePreferenceEntity
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import org.junit.Before
import org.junit.Test
import org.junit.Assert.assertEquals

class LanguageRepositoryTest {

    lateinit var repository: LanguageRepository

    @MockK
    lateinit var preference: Preference

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = LanguageRepositoryImpl(preference)
    }

    @Test
    fun `when invoke getSelectedLanguage and retrieve a LanguagePreferenceEntity from preference should return a LanguageModel`() {
        val languagePreferenceEntityMock = LanguagePreferenceEntity("PT-BR", "Português")
        val languageModelMock = LanguageModel("PT-BR", "Português")
        every { preference.get(LanguagePreferenceEntity::class.java) } returns languagePreferenceEntityMock
        val result = repository.getSelectedLanguage()
        assertEquals(languageModelMock, result)
    }

    @Test(expected = LanguageRepositoryException::class)
    fun `when invoke getSelectedLanguage and retrieve null from preference should throws a LanguageRepositoryException`() {
        every { preference.get(LanguagePreferenceEntity::class.java) } returns null
        repository.getSelectedLanguage()
    }

    @Test
    fun `when invoke setSelectedLanguage passing a LanguageModel should save a LanguagePreferenceEntity on preference`() {
        val languagePreferenceEntityMock = LanguagePreferenceEntity("PT-BR", "Português")
        val languageModelMock = LanguageModel("PT-BR", "Português")
        every { preference.put(languagePreferenceEntityMock, LanguagePreferenceEntity::class.java) } returns Unit
        val result = repository.setSelectedLanguage(languageModelMock)
        verify { preference.put(languagePreferenceEntityMock, LanguagePreferenceEntity::class.java) }
    }

}