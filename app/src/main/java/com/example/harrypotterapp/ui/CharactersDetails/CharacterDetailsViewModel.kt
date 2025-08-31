package com.example.harrypotterapp.ui.CharactersDetails

import androidx.lifecycle.ViewModel
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.repository.CharRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CharacterDetailsViewModel(
    private val repository: CharRepository
) : ViewModel() {
    suspend fun getCharacterById(id: String): Character? {
        return try {
            withContext(Dispatchers.IO) {
                repository.getCharacterById(id)
            }
        } catch (e: Exception) {
            throw e
        }
    }
}