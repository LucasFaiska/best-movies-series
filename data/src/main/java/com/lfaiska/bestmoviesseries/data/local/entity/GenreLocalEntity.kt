package com.lfaiska.bestmoviesseries.data.local.entity

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "genre")
data class GenreLocalEntity (
    @PrimaryKey
    val id: Long,
    val name: String
) : Parcelable
