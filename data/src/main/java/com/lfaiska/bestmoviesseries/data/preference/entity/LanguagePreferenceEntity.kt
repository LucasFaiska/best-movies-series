package com.lfaiska.bestmoviesseries.data.preference.entity

import com.google.gson.annotations.SerializedName

data class LanguagePreferenceEntity(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String
)