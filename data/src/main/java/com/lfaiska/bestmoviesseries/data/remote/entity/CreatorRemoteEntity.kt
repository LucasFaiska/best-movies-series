package com.lfaiska.bestmoviesseries.data.remote.entity

import com.google.gson.annotations.SerializedName

data class CreatorRemoteEntity (
    val name: String,
    @SerializedName("profile_path")
    val profile_path: String
)
