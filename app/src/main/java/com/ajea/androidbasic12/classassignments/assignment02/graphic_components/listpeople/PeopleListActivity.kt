package com.ajea.androidbasic12.classassignments.assignment02.graphic_components.listpeople

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ajea.androidbasic12.R

class PeopleListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_people_list)

        val list = findViewById<RecyclerView>(R.id.peopleList)

        val data = listOf(
            PeopleEntity("John Doe", "Developer", "male01"),
            PeopleEntity("Jane Smith", "Designer", "female02"),
            PeopleEntity("Michael Brown", "Manager", "male02"),
            PeopleEntity("Emily Davis", "Analyst", "female03"),
            PeopleEntity("Daniel Wilson", "Tester", "male03"),
            PeopleEntity("Sarah Johnson", "Product Owner", "female04"),
            PeopleEntity("David Lee", "Developer", "male04"),
            PeopleEntity("Laura Martinez", "Scrum Master", "female05"),
            PeopleEntity("James Anderson", "Architect", "male05")
        )

        // Se crea el adaptador personalizado
        val adapter = PeopleAdapter(data)
        // Se establece el adaptador y el layout manager
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 1)
    }
}
