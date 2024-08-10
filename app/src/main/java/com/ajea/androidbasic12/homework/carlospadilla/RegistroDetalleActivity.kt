package com.ajea.androidbasic12.homework.carlospadilla

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class RegistroDetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_detalle)

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastName = findViewById<TextView>(R.id.tvLastName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvGender = findViewById<TextView>(R.id.tvGender)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)

        val name = intent.getStringExtra("NAME")
        val lastName = intent.getStringExtra("LASTNAME")
        val email = intent.getStringExtra("EMAIL")
        val gender = intent.getStringExtra("GENDER")
        val password = intent.getStringExtra("PASSWORD")

        tvName.text = "Name: $name"
        tvLastName.text = "Last Name: $lastName"
        tvEmail.text = "Email: $email"
        tvGender.text = "Gender: $gender"
        tvPassword.text = "Password: $password"
    }
}
