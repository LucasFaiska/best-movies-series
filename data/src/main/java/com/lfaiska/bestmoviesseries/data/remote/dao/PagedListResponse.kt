package com.lfaiska.bestmoviesseries.data.remote.dao

data class PagedListResponse<T> (val page: Int, val results: List<T>)
