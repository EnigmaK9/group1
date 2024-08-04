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
            PeopleEntity("John Doe", "Developer", "john_doe"),
            PeopleEntity("Jane Smith", "Designer", "jane_smith"),
            PeopleEntity("Michael Brown", "Manager", "michael_brown"),
            PeopleEntity("Emily Davis", "Analyst", "emily_davis"),
            PeopleEntity("Daniel Wilson", "Tester", "daniel_wilson"),
            PeopleEntity("Sarah Johnson", "Product Owner", "sarah_johnson"),
            PeopleEntity("David Lee", "Developer", "david_lee"),
            PeopleEntity("Laura Martinez", "Scrum Master", "laura_martinez"),
            PeopleEntity("James Anderson", "Architect", "james_anderson")
        )

        // Se crea el adaptador personalizado
        val adapter = PeopleAdapter(data)
        // Se establece el adaptador y el layout manager
        list.adapter = adapter
        list.layoutManager = GridLayoutManager(this, 1)
    }
}
