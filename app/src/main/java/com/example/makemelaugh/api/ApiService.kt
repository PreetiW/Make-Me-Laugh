package com.example.makemelaugh.api

import com.example.makemelaugh.models.Joke
import retrofit2.http.GET

interface ApiService {

    @GET("random_joke")
    suspend fun getRandomJoke():Joke
}