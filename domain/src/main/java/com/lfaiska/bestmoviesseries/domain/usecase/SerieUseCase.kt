package com.lfaiska.bestmoviesseries.domain.usecase

import com.lfaiska.bestmoviesseries.data.repository.base.ListModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieModel
import com.lfaiska.bestmoviesseries.data.repository.serie.SerieRepository

class SerieUseCase(val repository: SerieRepository) {

    suspend fun getSeries(page: Int): ListModel<SerieModel> {
        return repository.getSeries(page)
    }
}
