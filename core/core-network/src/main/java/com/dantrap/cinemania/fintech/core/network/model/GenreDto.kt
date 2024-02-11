package com.dantrap.cinemania.fintech.core.network.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class GenreDto(
    @SerializedName("genre")
    val genre: String
)
