package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.list

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class AnimalListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_animal_list)

        val list = findViewById<RecyclerView>(R.id.animalList)

        val data = listOf(
            animalEntity("Lion", "yellow", "lion"),
            animalEntity("Tiger", "orange", "tiger"),
            animalEntity("Elephant", "gray", "elephant"),
            animalEntity("Zebra", "white and black", "zebra"),
            animalEntity("Giraffe", "yellow with brown", "giraffe"),
            animalEntity("Penguin", "black with white belly", "penguin"),
            animalEntity("Kangaroo", "brown", "kangaroo"),
            animalEntity("Koala", "gray", "koala"),
            animalEntity("Hippopotamus", "gray", "hippo")
        )

        // Se crea el adaptador personalizado
        val adapter = AnimalAdapter(data)
        //centrados, nombres de personas centrados
        list.adapter = adapter
        // list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = GridLayoutManager(this, 1)
    }
}
