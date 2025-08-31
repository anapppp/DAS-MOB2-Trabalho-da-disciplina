package com.example.harrypotterapp.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    val api: CharApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharApi::class.java)
    }
}
