package com.example.harrypotterapp.ui.Main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.harrypotterapp.R
import com.example.harrypotterapp.ui.CharactersDetails.CharacterDetailsActivity
import com.example.harrypotterapp.ui.CharactersInAHouse.CharactersInAHouseActivity
import com.example.harrypotterapp.ui.HogwartsStaff.HogwartsStaffActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttonCharactersById: Button
    private lateinit var buttonStaff: Button
    private lateinit var buttonCharactersByHouse: Button
    private lateinit var buttonExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        buttonCharactersById = findViewById(R.id.buttonCharactersById)
        buttonStaff = findViewById(R.id.buttonStaff)
        buttonCharactersByHouse = findViewById(R.id.buttonCharactersByHouse)
        buttonExit = findViewById(R.id.buttonExit)

        buttonCharactersById.setOnClickListener {
            val intent = Intent(this, CharacterDetailsActivity::class.java)
            startActivity(intent)
        }

        buttonStaff.setOnClickListener {
            val intent = Intent(this, HogwartsStaffActivity::class.java)
            startActivity(intent)
        }

        buttonCharactersByHouse.setOnClickListener {
            val intent = Intent(this, CharactersInAHouseActivity::class.java)
            startActivity(intent)
        }

        buttonExit.setOnClickListener {
            finish()
        }
    }
}