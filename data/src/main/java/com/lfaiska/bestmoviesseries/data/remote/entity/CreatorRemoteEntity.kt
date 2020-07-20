package com.lfaiska.bestmoviesseries.data.remote.entity

import com.google.gson.annotations.SerializedName

data class CreatorRemoteEntity (
    val id: Long,
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String
)
