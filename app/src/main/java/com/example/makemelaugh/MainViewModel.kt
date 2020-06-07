package com.example.makemelaugh

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.makemelaugh.api.RetrofitBuilder
import com.example.makemelaugh.models.Joke
import com.example.makemelaugh.repository.Repository
import kotlinx.coroutines.*

class MainViewModel: ViewModel(){
    private val  _jokeMutable: MutableLiveData<Joke> = MutableLiveData()

    var joke: LiveData<Joke> = _jokeMutable

    var job: CompletableJob? = null

    fun getRandomJoke(){

        job = Job()

        job?.let { theJob ->
            CoroutineScope(Dispatchers.IO + theJob).launch {
                val joke = Repository.getRandomJoke()
                withContext(Dispatchers.Main) {
                    _jokeMutable.value = joke
                    theJob.complete()
                }
            }

        }
    }

    fun cancelJobs(){
        job?.cancel()
    }
}