package com.ctt.pet4jokes.model

import com.google.gson.annotations.SerializedName

data class DogPicture(
    @SerializedName("message")
    val pictureURL: String,
    @SerializedName("status")
    val requestStatus: String
)