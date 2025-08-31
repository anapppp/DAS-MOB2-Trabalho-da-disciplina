package com.example.harrypotterapp.ui.CharactersInAHouse

import android.media.tv.TvView
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.repository.CharRepository
import com.example.harrypotterapp.ui.HogwartsStaff.HogwartsStaffViewModel
import kotlinx.coroutines.launch

class CharactersInAHouseActivity : AppCompatActivity() {

    private lateinit var rgHouses: RadioGroup
    private lateinit var tvCharList: TvView
    private lateinit var progressBar: ProgressBar
    private lateinit var viewModel: CharactersInAHouseViewModel
    private lateinit var repository: CharRepository


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_characters_in_ahouse)

        rgHouses = findViewById(R.id.rgHouses)
        tvCharList = findViewById(R.id.tvCharList)
        progressBar = findViewById(R.id.progressBar)

        repository = CharRepository()
        viewModel = CharactersInAHouseViewModel(repository)

        rgHouses.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.rbGryffindor -> fetchStudentsByHouse("gryffindor")
                R.id.rbSlytherin -> fetchStudentsByHouse("slytherin")
                R.id.rbHufflepuff -> fetchStudentsByHouse("hufflepuff")
                R.id.rbRavenclaw -> fetchStudentsByHouse("ravenclaw")
            }
        }
    }
    private fun fetchStudentsByHouse(house: String) {
        lifecycleScope.launch {
            try {
                showLoading()
                val staff: List<Character>? = viewModel.getHogwartsStaff()
                val names = staff?.joinToString(separator = "\n") { it.name ?: "" }

                tvStaffList.text = names


            } catch (e: Exception) {
                Toast.makeText(
                    this@HogwartsStaffActivity,
                    "Erro ao buscar professores",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e("HogwartsStaffActivity", "Erro ao buscar professores", e)
            } finally {
                hideLoading()
            }
        }


    }
}

