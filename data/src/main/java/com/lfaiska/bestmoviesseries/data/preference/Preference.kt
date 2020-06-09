package com.lfaiska.bestmoviesseries.data.preference

interface Preference {
    fun <T> get(type: Class<T>): T?
    fun <T> put(value: T, type: Class<T>)
    fun clear()
}