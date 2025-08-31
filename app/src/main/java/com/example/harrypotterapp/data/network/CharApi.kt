package com.example.harrypotterapp.data.network

import com.example.harrypotterapp.data.model.Character
import retrofit2.http.GET
import retrofit2.http.Path

interface CharApi {

    @GET("character/{id}")
    suspend fun getCharacterById(@Path("id") id: String): List<Character>

    @GET("characters/staff")
    suspend fun getStaff(): List<Character>

    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(@Path("house") house: String): List<Character>
}