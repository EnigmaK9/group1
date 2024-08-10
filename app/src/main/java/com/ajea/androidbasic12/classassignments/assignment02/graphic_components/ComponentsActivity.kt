package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import missing.namespace.R

class ComponentsActivity : AppCompatActivity() {

    private val bmiHistory = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val cbLoseWeight = findViewById<CheckBox>(R.id.cbLoseWeight)
        val llDetails = findViewById<LinearLayout>(R.id.llDetails)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val etName = findViewById<EditText>(R.id.etName)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btGetInfo = findViewById<Button>(R.id.btGetInfo)
        val pbBMIStatus = findViewById<ProgressBar>(R.id.pbBMIStatus)
        val btHistory = findViewById<Button>(R.id.btHistory)
        val spinnerCountries = findViewById<Spinner>(R.id.spinner)

        // Set up the countries spinner
        val countries = arrayOf("México", "Colombia", "Argentina", "Perú", "Venezuela", "Chile", "Ecuador", "Guatemala", "Bolivia", "Cuba")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountries.adapter = adapter
        spinnerCountries.setSelection(adapter.getPosition("México"))

        spinnerCountries.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                Toast.makeText(this@ComponentsActivity, "Selected country: ${parent.getItemAtPosition(position)}", Toast.LENGTH_SHORT).show()
            }
            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        cbLoseWeight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                val fadeOut = AlphaAnimation(1f, 0f).apply {
                    duration = 500
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {}
                        override fun onAnimationEnd(animation: Animation) {
                            cbLoseWeight.visibility = View.GONE
                            llDetails.visibility = View.VISIBLE
                            llDetails.startAnimation(AlphaAnimation(0f, 1f).apply { duration = 500 })
                        }
                        override fun onAnimationRepeat(animation: Animation) {}
                    })
                }
                cbLoseWeight.startAnimation(fadeOut)
            } else {
                llDetails.startAnimation(AlphaAnimation(1f, 0f).apply {
                    duration = 500
                    setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {}
                        override fun onAnimationEnd(animation: Animation) {
                            llDetails.visibility = View.GONE
                            cbLoseWeight.visibility = View.VISIBLE
                        }
                        override fun onAnimationRepeat(animation: Animation) {}
                    })
                })
            }
        }

        btGetInfo.setOnClickListener {
            val height = etHeight.text.toString().toDoubleOrNull()
            val weight = etWeight.text.toString().toDoubleOrNull()
            val name = etName.text.toString()

            if (height != null && weight != null && name.isNotBlank()) {
                val heightInMeters = height / 100
                val bmi = weight / (heightInMeters * heightInMeters)
                val bmiResult = "IMC de $name: %.2f".format(bmi)
                bmiHistory.add(bmiResult)
                pbBMIStatus.visibility = View.VISIBLE
                pbBMIStatus.progress = when {
                    bmi < 18.5 -> 25
                    bmi in 18.5..24.9 -> 50
                    bmi in 25.0..29.9 -> 75
                    bmi >= 30.0 -> 100
                    else -> 0
                }
                Toast.makeText(this, "$bmiResult, Estado: ${getStatus(bmi)}", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Debes ingresar tu nombre, altura y peso correctamente.", Toast.LENGTH_SHORT).show()
            }
        }

        btHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java).apply {
                putStringArrayListExtra("bmiHistory", bmiHistory)
            }
            startActivity(intent)
        }
    }

    private fun getStatus(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Desnutrido"
            bmi in 18.5..24.9 -> "Peso normal"
            bmi in 25.0..29.9 -> "Sobrepeso"
            bmi >= 30.0 -> "Obeso"
            else -> "No clasificable"
        }
    }
}
