package com.example.harrypotterapp.ui.HogwartsStaff

import androidx.lifecycle.ViewModel
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.repository.CharRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HogwartsStaffViewModel(
    private val repository: CharRepository

) : ViewModel() {
    suspend fun getHogwartsStaff(): List<Character>? {
        return try {
            withContext(Dispatchers.IO) {
                repository.getStaff()
            }
        } catch (e: Exception) {
            throw e
        }
    }
}

