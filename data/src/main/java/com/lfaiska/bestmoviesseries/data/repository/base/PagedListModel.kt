package com.lfaiska.bestmoviesseries.data.repository.base

data class PagedListModel<T>(val page: Int, val items: List<T>)