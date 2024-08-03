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
            animalEntity("Elephant", "brown", "elephant"),
            animalEntity("Zebra", "brown", "zebra"),
            animalEntity("Giraffe", "brown", "giraffe"),
            animalEntity("Penguin", "blue", "penguin"),
            animalEntity("Kangaroo", "brown", "kangaroo"),
            animalEntity("Koala", "brown", "koala"),
            animalEntity("Hippopotamus", "brown", "hippo")
        )

        // Se crea el adaptador personalizado
        val adapter = AnimalAdapter(data)
        //centrados, nombres de personas centrados
        list.adapter = adapter
        // list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        list.layoutManager = GridLayoutManager(this, 2)
    }
}
