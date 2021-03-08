package com.ctt.pet4jokes.model

import com.google.gson.annotations.SerializedName

data class Joke(
    @SerializedName("joke")
    val joke: String
    )