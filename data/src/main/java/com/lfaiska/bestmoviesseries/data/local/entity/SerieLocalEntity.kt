package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Embedded
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SerieLocalEntity(
    @Embedded
    val serieDataLocalEntity: SerieDataLocalEntity,
    @Embedded
    val serieLocaleDataLocalEntity: SerieLocaleDataLocalEntity
) : Parcelable