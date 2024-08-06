package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.personslist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class PersonListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_list)

        val listRvP = findViewById<RecyclerView>(R.id.rvPersons)
        val data = listOf(
            PersonEntity("John","Travolta","w1"),
            PersonEntity("Steven","Strange","w2"),
            PersonEntity("Peter","Parker","w3"),
            PersonEntity("Mary","Jane","w4"),
            PersonEntity("Clark","Kent","w5"),
            PersonEntity("Julio","Jaramillo","w6"),
            PersonEntity("Chase","Wilson","w7"),
        )
        val adapter = PersonAdapter(data)
        // Reassign the adapter to the RecyclerView
        listRvP.adapter = adapter

        listRvP.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//        listRvP.layoutManager = GridLayoutManager(this,2)

    }
}