package com.example.makemelaugh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.joke.observe(this, Observer {
            with(it) {
                jokeSetup.text = setup
                jokePunchline.text = punchline
            }
        })

        getJoke.setOnClickListener { viewModel.getRandomJoke() }

    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.cancelJobs()
    }
}
