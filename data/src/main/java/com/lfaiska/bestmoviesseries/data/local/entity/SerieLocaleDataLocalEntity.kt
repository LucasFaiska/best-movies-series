package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.ForeignKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "serie_locale_data",
    primaryKeys = ["serieId", "lang"],
    foreignKeys = [
        ForeignKey(
            entity = SerieDataLocalEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("serieId")
        )
    ]
)
data class SerieLocaleDataLocalEntity(
    val serieId: Long,
    val language: String,
    val posterImage: String,
    val overview: String,
    val name: String
) : Parcelable