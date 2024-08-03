package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_graphic_components)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnComponents = findViewById<Button>(R.id.btnComponents)
        val btnConstraintLayout = findViewById<Button>(R.id.btnConstraintLayout)
        val btnFrameLayout = findViewById<Button>(R.id.btnFrameLayout)
        val btnLinearLayout = findViewById<Button>(R.id.btnLinearLayout)
        val btnRelativeLayout = findViewById<Button>(R.id.btnRelativeLayout)

        btnComponents.setOnClickListener {
            val intent = Intent(this, ComponentsActivity::class.java)
            startActivity(intent)
        }

        btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        btnFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}
