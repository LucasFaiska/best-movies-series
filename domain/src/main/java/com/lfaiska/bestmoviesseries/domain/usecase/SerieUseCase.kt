package com.lfaiska.bestmoviesseries.domain.usecase

import com.lfaiska.bestmoviesseries.data.repository.serie.SerieRepository
import com.lfaiska.bestmoviesseries.domain.mapper.SerieMapper
import com.lfaiska.bestmoviesseries.domain.model.PagedList
import com.lfaiska.bestmoviesseries.domain.model.Serie

class SerieUseCase(
    private val repository: SerieRepository,
    val mapper: SerieMapper
) {

    suspend fun getSeries(page: Int, language: String): PagedList<Serie> {
        return mapper.mapSeriePagedList(repository.getSeries(page, language))
    }
}
