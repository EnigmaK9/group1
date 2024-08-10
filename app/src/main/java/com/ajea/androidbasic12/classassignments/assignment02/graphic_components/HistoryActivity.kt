package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.ajea.androidbasic12.R

class HistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val bmiHistory = intent.getStringArrayListExtra("bmiHistory")
        val listView = findViewById<ListView>(R.id.listViewHistory)

        if (bmiHistory != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bmiHistory)
            listView.adapter = adapter
        }
    }
}
