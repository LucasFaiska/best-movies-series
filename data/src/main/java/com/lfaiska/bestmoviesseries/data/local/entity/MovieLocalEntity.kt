package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "movies")
data class MovieLocalEntity (
    @PrimaryKey
    val id: Long,
    val posterImage: String,
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val title: String,
    val releaseDate: Long
): Parcelable