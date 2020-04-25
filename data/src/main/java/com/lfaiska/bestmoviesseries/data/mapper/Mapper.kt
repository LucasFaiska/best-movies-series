package com.lfaiska.bestmoviesseries.data.mapper

interface Mapper <R, L, M> {
    fun mapRemoteToLocal(remote: R) : L
    fun mapRemoteToModel(remote: R) : M
    fun mapLocalToModel(local: L) : M
}