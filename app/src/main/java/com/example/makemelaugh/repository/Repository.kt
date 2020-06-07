package com.example.makemelaugh.repository

import androidx.lifecycle.LiveData
import com.example.makemelaugh.api.RetrofitBuilder
import com.example.makemelaugh.models.Joke


object Repository {
    suspend fun getRandomJoke(): Joke {
        return RetrofitBuilder.apiService.getRandomJoke()
    }
}
