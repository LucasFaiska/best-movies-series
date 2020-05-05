package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "serie")
data class SerieDataLocalEntity (
    @PrimaryKey
    val id: Long,
    val voteAverage: Double,
    val popularity: Double,
    val firstAirDate: String
) : Parcelable