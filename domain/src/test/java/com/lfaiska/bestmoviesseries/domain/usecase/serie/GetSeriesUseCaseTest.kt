package com.lfaiska.bestmoviesseries.domain.usecase.serie

import com.lfaiska.bestmoviesseries.data.repository.serie.SerieRepository
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import org.junit.Before
import org.junit.Test

class GetSeriesUseCaseTest {

    private lateinit var useCase: GetSeriesUseCase

    @MockK
    lateinit var repository: SerieRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetSeriesUseCaseImpl(repository)
    }

    @Test
    fun foo() {

    }

}