/*
* Facultad de Ingeniería
* Diplomado de desarrollo de aplicaciones para dispositivos móviles
* Carlos Ignacio Padilla Herrera
* Alan Ulises Mendoza Gonzalez
* Giovanni Sebastian Verastegui Perez
* */

package com.ajea.androidbasic12.ejerciciosclase.ejercicio01.explicitintent

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val labelName = findViewById<TextView>(R.id.labelName)
        val btnReturn = findViewById<Button>(R.id.btnReturn)

        intent.extras?.let { extras ->
            if (extras.containsKey("EXTRA_NAME_KEY")) {
                val names = extras.getString("EXTRA_NAME_KEY", "Default Name")
                labelName.text = names
                Toast.makeText(this, "Our names are: $names", Toast.LENGTH_SHORT).show()
            }

            if (extras.containsKey("EXTRA_BUNDLE_KEY")) {
                val info = extras.getBundle("EXTRA_BUNDLE_KEY")
                val ageCarlos = info?.getInt("EXTRA_AGE_CARLOS", 0) ?: 0
                val ageSebastian = info?.getInt("EXTRA_AGE_SEBASTIAN", 0) ?: 0
                val ageAlan = info?.getInt("EXTRA_AGE_ALAN", 0) ?: 0
                val surnameCarlos = info?.getString("EXTRA_SURNAME_CARLOS", "")
                val surnameSebastian = info?.getString("EXTRA_SURNAME_SEBASTIAN", "")
                val surnameAlan = info?.getString("EXTRA_SURNAME_ALAN", "")
                val address = info?.getString("EXTRA_ADDRESS", "")
                val isStudent = info?.getBoolean("EXTRA_IS_STUDENT", false) ?: false
                val email = info?.getString("EXTRA_EMAIL", "")
                val phone = info?.getString("EXTRA_PHONE", "")
                val jobTitle = info?.getString("EXTRA_JOB_TITLE", "")
                val company = info?.getString("EXTRA_COMPANY", "")
                val university = info?.getString("EXTRA_UNIVERSITY", "")
                val major = info?.getString("EXTRA_MAJOR", "")
                val hobbies = info?.getString("EXTRA_HOBBIES", "")
                val skills = info?.getString("EXTRA_SKILLS", "")

                val toastMessages = listOf(
                    "The age of Carlos is: $ageCarlos",
                    "The age of Sebastian is: $ageSebastian",
                    "The age of Alan is: $ageAlan",
                    "Lastname of Carlos is: $surnameCarlos",
                    "Lastname of Sebastian is: $surnameSebastian",
                    "Lastname of Alan is: $surnameAlan",
                    "Address: $address\nStudent: $isStudent",
                    "Email: $email\nPhone: $phone",
                    "Job Title: $jobTitle\nCompany: $company",
                    "University: $university\nMajor: $major",
                    "Hobbies: $hobbies\nSkills: $skills"
                )

                val handler = Handler(Looper.getMainLooper())
                var delay = 0L

                for (message in toastMessages) {
                    handler.postDelayed({
                        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
                    }, delay)
                    delay += 5000 // delay de 2 secs entre cada toast c:
                }
            }

            btnReturn.setOnClickListener {
                val resultIntent = Intent().apply {
                    putExtra("EXTRA_IS_CORRECT_KEY", true)
                }
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}
