package com.lfaiska.bestmoviesseries.data.local.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lfaiska.bestmoviesseries.data.repository.model.CreatorModel
import com.lfaiska.bestmoviesseries.data.repository.model.GenreModel
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
@Entity(
    tableName = "serie",
    primaryKeys = ["id", "lang"]
)
data class SerieLocalEntity(
    val id: Long,
    val language: String,
    val voteAverage: Double? = null,
    val popularity: Double? = null,
    val overview: String? = null,
    val name: String? = null,
    val firstAirDate: String? = null,
    val backdropPath: String? = null,
    val posterPath: String? = null,
    val numberOfEpisodes: Int? = null,
    val numberOfSeasons: Int? = null
) : Parcelable