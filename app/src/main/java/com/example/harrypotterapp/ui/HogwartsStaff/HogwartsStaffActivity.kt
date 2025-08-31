package com.example.harrypotterapp.ui.HogwartsStaff

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.harrypotterapp.R
import com.example.harrypotterapp.data.model.Character
import com.example.harrypotterapp.data.repository.CharRepository
import kotlinx.coroutines.launch


class HogwartsStaffActivity : AppCompatActivity() {

    lateinit var buttonRefreshStaff: Button
    lateinit var tvStaffList: TextView
    lateinit var progressBar: ProgressBar
    lateinit var viewModel: HogwartsStaffViewModel
    lateinit var repository: CharRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_hogwarts_staff)

        buttonRefreshStaff = findViewById(R.id.btnRefreshStaff)
        tvStaffList = findViewById(R.id.tvStaffList)
        progressBar = findViewById(R.id.progressBar)

        repository = CharRepository()
        viewModel = HogwartsStaffViewModel(repository)

        buttonRefreshStaff.setOnClickListener {
            fetchStaffList()
        }
        fetchStaffList()

    }

    private fun fetchStaffList() {
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

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        tvStaffList.visibility = View.GONE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
        tvStaffList.visibility = View.VISIBLE
    }
}