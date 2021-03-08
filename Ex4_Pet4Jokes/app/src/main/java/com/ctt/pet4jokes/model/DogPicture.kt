package com.ctt.pet4jokes.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DogPicture(
    @SerializedName("message")
    val pictureURL: String,
    @SerializedName("status")
    val requestStatus: String
) : Parcelable
