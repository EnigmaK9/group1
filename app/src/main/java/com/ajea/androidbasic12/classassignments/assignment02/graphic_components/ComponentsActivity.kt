package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class ComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_components)

        val cbCreditCard = findViewById<CheckBox>(R.id.cbCreditCard)
        val btGetInfo = findViewById<Button>(R.id.btGetInfo)
        val rgSex = findViewById<RadioGroup>(R.id.rgSex)

        cbCreditCard.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                rgSex.visibility = View.GONE
            } else {
                rgSex.visibility = View.VISIBLE
            }
            Toast.makeText(this, "isChecked = $isChecked", Toast.LENGTH_SHORT).show()
        }

        rgSex.setOnCheckedChangeListener { _, id ->
            val idName = when (id) {
                R.id.rbWomen -> "Women"
                R.id.rbMen -> "Men"
                else -> "Unknown"
            }
            Toast.makeText(this, "CheckedId = $idName", Toast.LENGTH_SHORT).show()
        }

        btGetInfo.setOnClickListener {
            val cbStatus = cbCreditCard.isChecked
            val selectedRgOption = when (rgSex.checkedRadioButtonId) {
                R.id.rbWomen -> "Women"
                R.id.rbMen -> "Men"
                else -> "Unknown"
            }
            Toast.makeText(this, "isChecked = $cbStatus, selectedSex = $selectedRgOption", Toast.LENGTH_SHORT).show()
        }
    }
}
