package com.lfaiska.bestmoviesseries.data.local.dto

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "creator")
data class CreatorLocalEntity (
    @PrimaryKey
    val id: Long,
    val name: String,
    val profilePath: String
) : Parcelable
