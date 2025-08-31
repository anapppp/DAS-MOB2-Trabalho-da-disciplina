package com.example.harrypotterapp.ui.CharactersInAHouse

import androidx.lifecycle.ViewModel
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.repository.CharRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharactersInAHouseViewModel (
    private val repository: CharRepository

) : ViewModel() {
    suspend fun getCharactersByHouse(house: String): List<Character>? {
        return try {
            withContext(Dispatchers.IO) {
                repository.getCharactersByHouse(house)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}