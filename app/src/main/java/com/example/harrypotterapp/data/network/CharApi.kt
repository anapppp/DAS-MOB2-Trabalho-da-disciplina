package com.example.harrypotterapp.data.network

import retrofit2.http.GET
import retrofit2.http.Path

interface CharApi {
    @GET("characters")
    suspend fun getCharacters(): List<Char>

    @GET("characters/{id}")
    suspend fun getCharacterById(@Path("id") id: String): Char

    @GET("characters/staff")
    suspend fun getStaff(): List<Char>

    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(@Path("house") house: String): List<Char>

}