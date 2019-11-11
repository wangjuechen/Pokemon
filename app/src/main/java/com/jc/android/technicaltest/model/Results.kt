package com.jc.android.technicaltest.model

import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonProperty
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Results(
    @JsonProperty("name") val name: String,
    @JsonProperty("url") val url: String
) : Parcelable