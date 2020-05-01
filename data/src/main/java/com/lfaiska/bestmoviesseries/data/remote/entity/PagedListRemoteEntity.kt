package com.lfaiska.bestmoviesseries.data.remote.entity

data class PagedListRemoteEntity<T> (val page: Int, val results: List<T>)
