package com.example.harrypotterapp.data.repository

import com.example.harrypotterapp.data.network.RetrofitInstance

class CharRapository {
    private val api = RetrofitInstance.api

    suspend fun getCharacters(): List<Char> {
        return api.getCharacters()
    }

    suspend fun getCharacterById(id: String): Char {
        return api.getCharacterById(id)
    }

    suspend fun getStaff(): List<Char> {
        return api.getStaff()
    }

    suspend fun getCharactersByHouse(house: String): List<Char> {
        return api.getCharactersByHouse(house)
    }
}