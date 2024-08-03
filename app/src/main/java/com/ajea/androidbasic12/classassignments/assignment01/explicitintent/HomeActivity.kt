/*
* Facultad de Ingeniería
* Diplomado de desarrollo de aplicaciones para dispositivos móviles
* Carlos Ignacio Padilla Herrera
* Alan Ulises Mendoza Gonzalez
* Giovanni Sebastian Verastegui Perez
* */

package com.ajea.androidbasic12.classassignments.assignment01.explicitintent

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class HomeActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            val isCorrect = result.data?.getBooleanExtra("EXTRA_IS_CORRECT_KEY", false) ?: false
            if (isCorrect) {
                onBackPressedDispatcher.onBackPressed() //como si el usuario apretara un back
            } else {
                Toast.makeText(this, "resultExtra = $isCorrect", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnSendActivity = findViewById<Button>(R.id.btnSendActivity)

        btnSendActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                val bundle = Bundle().apply {
                    putInt("EXTRA_AGE_CARLOS", 120)
                    putInt("EXTRA_AGE_SEBASTIAN", 97)
                    putInt("EXTRA_AGE_ALAN", 3)
                    putString("EXTRA_SURNAME_CARLOS", "Padilla")
                    putString("EXTRA_SURNAME_SEBASTIAN", "Verastegui")
                    putString("EXTRA_SURNAME_ALAN", "Mendoza")
                    putString("EXTRA_ADDRESS", "Wonderland, Vatican City")
                    putString("EXTRA_EMAIL", "enigmak9@pm.me, alanmendoza@gmail.com, sebastianverastegui@gmail.com")
                    putString("EXTRA_PHONE", "2298866888, 5511223366, 5555444422")
                    putString("EXTRA_JOB_TITLE", "Software Developer, Web Developer, Accounter")
                    putString("EXTRA_COMPANY", "Enigma Unit")
                    putString("EXTRA_UNIVERSITY", "UNAM")
                    putString("EXTRA_MAJOR", "Computer Engineering, Electrical-Electronic Engineering")
                    putString("EXTRA_HOBBIES", "Tango, Play Guitar, Hiking")
                    putString("EXTRA_SKILLS", "Python, Kotlin, Swift")
                }
                putExtra("EXTRA_NAME_KEY", "Carlos, Sebastian, Alan")
                putExtra("EXTRA_BUNDLE_KEY", bundle)
            }
            register.launch(intent)
        }
    }
}
