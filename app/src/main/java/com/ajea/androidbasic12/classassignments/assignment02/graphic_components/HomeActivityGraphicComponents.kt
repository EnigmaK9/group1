package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R
import com.ajea.androidbasic12.classassignments.assignment02.graphic_components.list.AnimalListActivity
import com.ajea.androidbasic12.classassignments.assignment02.graphic_components.listpeople.PeopleListActivity
import com.ajea.androidbasic12.classassignments.assignment02.graphic_components.personslist.PersonListActivity
import com.ajea.androidbasic12.classassignments.assignment02.graphic_components.RelativeLayoutExercise

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_graphic_components)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val btnComponents = findViewById<Button>(R.id.btnComponents)
        val btnConstraintLayout = findViewById<Button>(R.id.btnConstraintLayout)
        val btnFrameLayout = findViewById<Button>(R.id.btnFrameLayout)
        val btnLinearLayout = findViewById<Button>(R.id.btnLinearLayout)
        val btnRelativeLayoutExercise = findViewById<Button>(R.id.btnRelativeLayoutExercise)  // Actualizado
        val btnPersonList = findViewById<Button>(R.id.btnPersonList)
        val btnPeopleList = findViewById<Button>(R.id.btnPeopleList)
        val btnAnimalList = findViewById<Button>(R.id.btnAnimalList)
        val btnFrameLayoutExercise = findViewById<Button>(R.id.btnFrameLayoutExercise)

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

        btnRelativeLayoutExercise.setOnClickListener {
            val intent = Intent(this, RelativeLayoutExercise::class.java)
            startActivity(intent)
        }

        btnPersonList.setOnClickListener {
            val intent = Intent(this, PersonListActivity::class.java)
            startActivity(intent)
        }

        btnPeopleList.setOnClickListener {
            val intent = Intent(this, PeopleListActivity::class.java)
            startActivity(intent)
        }

        btnAnimalList.setOnClickListener {
            val intent = Intent(this, AnimalListActivity::class.java)
            startActivity(intent)
        }

        btnFrameLayoutExercise.setOnClickListener {
            val intent = Intent(this, FrameLayoutExercise::class.java)
            startActivity(intent)
        }
    }
}
