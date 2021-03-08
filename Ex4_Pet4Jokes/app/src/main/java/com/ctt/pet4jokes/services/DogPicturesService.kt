package com.ctt.pet4jokes.services

import com.ctt.pet4jokes.model.DogPicture
import retrofit2.Call
import retrofit2.http.GET

interface DogPicturesService {
    @GET("breeds/image/random")
    fun getDogPicture() : Call<DogPicture>
}