package com.lfaiska.bestmoviesseries.data.local.core

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

private const val DB_NAME = "Database.db"
private const val DB_VERSION = 1

@Database(entities = [], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var database: AppDatabase? = null

        fun instance(context: Context): AppDatabase = database
            ?: synchronized(this) {
                database ?: buildDatabase(context).also { database = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration().build()
    }
}