package com.ctt.pet4jokes.services

import com.ctt.pet4jokes.model.Joke
import retrofit2.Call
import retrofit2.http.GET

interface JokesService {
    @GET("api?format=json")
    fun getJokes() : Call<Joke>
}