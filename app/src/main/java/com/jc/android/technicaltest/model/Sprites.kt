package com.jc.android.technicaltest.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Sprites(
    @JsonProperty("back_default") val back_default: String,
    @JsonProperty("back_shiny") val back_shiny: String,
    @JsonProperty("front_default") val front_default: String,
    @JsonProperty("front_shiny") val front_shiny: String
) : Parcelable