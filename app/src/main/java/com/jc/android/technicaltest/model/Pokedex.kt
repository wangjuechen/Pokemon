package com.jc.android.technicaltest.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokedex(
    @JsonProperty("count") val count: Int,
    @JsonProperty("next") val next: String,
    @JsonProperty("previous") val previous: String,
    @JsonProperty("results") val results: List<Results>
) : Parcelable