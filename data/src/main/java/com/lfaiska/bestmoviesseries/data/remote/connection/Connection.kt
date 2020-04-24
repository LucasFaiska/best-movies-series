package com.lfaiska.bestmoviesseries.data.remote.connection

interface Connection {
    suspend fun isAvailable(): Boolean
}