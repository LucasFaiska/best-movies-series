package com.lfaiska.bestmoviesseries.data.preference

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson

class PreferenceImpl(context: Context?, val gson: Gson) : Preference {

    private val sharedPreferences =
        context?.getSharedPreferences(KEY, Context.MODE_PRIVATE) ?: run {
            throw UninitializedPropertyAccessException("Context must be initialized")
        }

    override fun <T> get(type: Class<T>): T? {
        val json = sharedPreferences.getString(type.simpleName, null)
        return json?.let { gson.fromJson(it, type) }
    }

    override fun <T> put(value: T, type: Class<T>) {
        sharedPreferences.edit {
            putString(type.simpleName, gson.toJson(value))
        }
    }

    override fun clear() {
        sharedPreferences.edit {
            clear()
        }
    }

    companion object {
        private const val KEY = "BestMoviesSeries"
    }
}