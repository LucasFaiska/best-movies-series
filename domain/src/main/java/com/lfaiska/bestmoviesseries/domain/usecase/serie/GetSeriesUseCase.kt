package com.lfaiska.bestmoviesseries.domain.usecase.serie

import com.lfaiska.bestmoviesseries.domain.model.PagedList
import com.lfaiska.bestmoviesseries.domain.model.Serie

interface GetSeriesUseCase {
    suspend operator fun invoke(page: Int, language: String): PagedList<Serie>
}