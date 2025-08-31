package com.example.harrypotterapp.data.repository

import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.network.Retrofit

class CharRepository {
    private val api = Retrofit.api

    suspend fun getCharacterById(id: String): Character {
        return api.getCharacterById(id)
    }

    suspend fun getStaff(): List<Character> {
        return api.getStaff()
    }

    suspend fun getCharactersByHouse(house: String): List<Character> {
        return api.getCharactersByHouse(house)
    }
}