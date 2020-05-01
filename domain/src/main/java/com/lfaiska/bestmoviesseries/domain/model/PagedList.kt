package com.lfaiska.bestmoviesseries.domain.model

data class PagedList<T>(val page: Int, val items: List<T>)