package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "serie",
    primaryKeys = ["serieId", "lang"]
)
data class SerieLocalEntity(
    val id: Long,
    val language: String,
    val posterImage: String,
    val voteAverage: Double,
    val popularity: Double,
    val overview: String,
    val name: String,
    val firstAirDate: String
) : Parcelable