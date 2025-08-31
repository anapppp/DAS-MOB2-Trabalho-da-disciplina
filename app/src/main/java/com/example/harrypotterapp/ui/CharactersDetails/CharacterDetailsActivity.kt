package com.example.harrypotterapp.ui.CharactersDetails

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.repository.CharRepository
import com.example.harrypotterapp.ui.hideLoading
import com.example.harrypotterapp.ui.showLoading
import kotlinx.coroutines.launch

class
CharacterDetailsActivity : AppCompatActivity() {

    private lateinit var etCharacterId: EditText
    private lateinit var btnSearchChar: Button
    private lateinit var tvCharDetails: TextView

    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: CharacterDetailsViewModel
    private lateinit var repository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_character_details)

        etCharacterId = findViewById(R.id.etCharacterId)
        btnSearchChar = findViewById(R.id.btnSearchChar)
        tvCharDetails = findViewById(R.id.tvCharDetails)
        progressBar = findViewById(R.id.progressBar)

        repository = CharRepository()
        viewModel = CharacterDetailsViewModel(repository)

        btnSearchChar.setOnClickListener {
            val characterId: String = etCharacterId.text.toString()
            fetchCharacterDetails(characterId)
        }
    }

    private fun fetchCharacterDetails(characterId: String) {
        lifecycleScope.launch {
            try {
                showLoading(progressBar, tvCharDetails)
                val character = viewModel.getCharacterById(characterId)
                tvCharDetails.text = """
                    Nome: ${character?.name}
                    Casa: ${character?.house}
                """.trimIndent()
            } catch (e: Exception) {
                Toast.makeText(
                    this@CharacterDetailsActivity,
                    "Erro ao buscar detalhes do personagem",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("HogwartsStaffActivity", "Erro ao buscar personagem", e)
            }
            finally {
                hideLoading(progressBar, tvCharDetails)
            }
        }
    }
}

