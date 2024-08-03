package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val cbLoseWeight = findViewById<CheckBox>(R.id.cbLoseWeight)
        val tvLoseWeight = findViewById<TextView>(R.id.tvLoseWeight)
        val llDetails = findViewById<LinearLayout>(R.id.llDetails)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)
        val spinner = findViewById<Spinner>(R.id.spinner)
        val etHeight = findViewById<EditText>(R.id.etHeight)
        val etWeight = findViewById<EditText>(R.id.etWeight)
        val btGetInfo = findViewById<Button>(R.id.btGetInfo)

        cbLoseWeight.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Fade out the CheckBox and TextView to black
                val fadeOut = AlphaAnimation(1f, 0f)
                fadeOut.duration = 500
                fadeOut.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        cbLoseWeight.visibility = View.GONE
                        tvLoseWeight.visibility = View.GONE
                        // Fade in the LinearLayout from black
                        val fadeIn = AlphaAnimation(0f, 1f)
                        fadeIn.duration = 500
                        llDetails.visibility = View.VISIBLE
                        llDetails.startAnimation(fadeIn)
                    }

                    override fun onAnimationRepeat(animation: Animation) {}
                })
                cbLoseWeight.startAnimation(fadeOut)
                tvLoseWeight.startAnimation(fadeOut)
            } else {
                // Fade out the LinearLayout to black
                val fadeOut = AlphaAnimation(1f, 0f)
                fadeOut.duration = 500
                fadeOut.setAnimationListener(object : Animation.AnimationListener {
                    override fun onAnimationStart(animation: Animation) {}
                    override fun onAnimationEnd(animation: Animation) {
                        llDetails.visibility = View.GONE
                        // Fade in the CheckBox and TextView from black
                        val fadeIn = AlphaAnimation(0f, 1f)
                        fadeIn.duration = 500
                        cbLoseWeight.visibility = View.VISIBLE
                        tvLoseWeight.visibility = View.VISIBLE
                        cbLoseWeight.startAnimation(fadeIn)
                        tvLoseWeight.startAnimation(fadeIn)
                    }

                    override fun onAnimationRepeat(animation: Animation) {}
                })
                llDetails.startAnimation(fadeOut)
            }
        }

        // RadioGroup
        rgSex.setOnCheckedChangeListener { _, id ->
            val idName = when (id) {
                R.id.rbWomen -> "Female"
                R.id.rbMen -> "Male"
                else -> "Unknown"
            }
            Toast.makeText(this, "Selected sex: $idName", Toast.LENGTH_SHORT).show()
        }

        // Spinner
        val dataCollection = arrayListOf("México", "Colombia", "Canada", "Argentina", "Denmark", "Venezuela", "España")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, dataCollection).also {
            it.setDropDownViewResource(R.layout.spinner_dropdown_item)
        }
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val itemSelected = dataCollection[position]
                Toast.makeText(this@ComponentsActivity, "Selected country: $itemSelected", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // No action needed
            }
        }

        btGetInfo.setOnClickListener {
            val cbStatus = cbLoseWeight.isChecked
            val selectedSex = when (rgSex.checkedRadioButtonId) {
                R.id.rbWomen -> "Female"
                R.id.rbMen -> "Male"
                else -> "Unknown"
            }
            val height = etHeight.text.toString()
            val weight = etWeight.text.toString()
            val itemSpinnerSelected = spinner.selectedItem.toString()
            Toast.makeText(this, "Lose weight: $cbStatus, Sex: $selectedSex, Height: $height cm, Weight: $weight kg, Country: $itemSpinnerSelected", Toast.LENGTH_SHORT).show()
        }
    }
}
