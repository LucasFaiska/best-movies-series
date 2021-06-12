package com.lfaiska.bestmoviesseries.data.remote.dao

import com.google.gson.annotations.SerializedName

data class CreatorResponse (
    val id: Long,
    val name: String,
    @SerializedName("profile_path")
    val profilePath: String
)
