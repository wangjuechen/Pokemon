package com.jc.android.technicaltest.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonDetails(
    @JsonProperty("id") val id: String,
    @JsonProperty("height") val height: String,
    @JsonProperty("weight") val weight: String,
    @JsonProperty("sprites") val sprites: Sprites
) : Parcelable
