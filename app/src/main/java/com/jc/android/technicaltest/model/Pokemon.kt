package com.jc.android.technicaltest.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val name: String,
    val url: String,
    val id: String
) : Parcelable