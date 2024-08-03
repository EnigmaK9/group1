package com.ajea.androidbasic12.ejerciciosclase.ejercicio01.ejercicio01.explicitintent

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

// ... other imports

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // ... existing code in onCreate() ...
    }

    // Move onOptionsItemSelected outside of onCreate()
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressedDispatcher.onBackPressed()
                //Toast.makeText(this, "Home button clicked", Toast.LENGTH_SHORT).show()

            }
        }
        return super.onOptionsItemSelected(item) // Add this line to handle other menu items
    }
}