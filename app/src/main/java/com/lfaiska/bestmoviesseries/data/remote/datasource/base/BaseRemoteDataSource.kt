package com.lfaiska.bestmoviesseries.data.remote.datasource.base

import com.lfaiska.bestmoviesseries.data.remote.exception.InternalErrorException
import com.lfaiska.bestmoviesseries.data.remote.exception.ResourceNotFoundException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnauthorizedResourceException
import com.lfaiska.bestmoviesseries.data.remote.exception.UnhandledErrorException
import retrofit2.HttpException

open class BaseRemoteDataSource {
    suspend fun <T> performRequest(request: suspend () -> T): T {
        return try {
            request()
        } catch (httpException: HttpException) {
            when (httpException.code()) {
                401 -> throw UnauthorizedResourceException()
                404 -> throw ResourceNotFoundException()
                500 -> throw InternalErrorException()
                else -> throw UnhandledErrorException()
            }
        }
    }
}