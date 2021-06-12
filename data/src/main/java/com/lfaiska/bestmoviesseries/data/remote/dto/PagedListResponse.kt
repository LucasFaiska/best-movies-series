package com.lfaiska.bestmoviesseries.data.remote.dto

data class PagedListResponse<T> (val page: Int, val results: List<T>)
