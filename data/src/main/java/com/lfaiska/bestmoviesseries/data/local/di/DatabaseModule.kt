package com.lfaiska.bestmoviesseries.data.local.di

import android.content.Context
import com.lfaiska.bestmoviesseries.data.local.core.AppDatabase
import org.koin.dsl.module

val databaseModule = module {
    single { providesDatabase(get()) }
}

fun providesDatabase(context: Context): AppDatabase = AppDatabase.instance(context)