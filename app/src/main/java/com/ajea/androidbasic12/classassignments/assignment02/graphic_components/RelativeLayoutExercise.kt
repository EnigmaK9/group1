package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class RelativeLayoutExercise : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout_exercise)

        val ivProfile = findViewById<ImageView>(R.id.ivProfile)
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSave = findViewById<Button>(R.id.btnSave)


    }
}