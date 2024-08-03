package com.ajea.androidbasic12.classassignments.assignment01

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidbasic12.R

class ImplicitIntentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit_intent)

        val btnSent = findViewById<Button>(R.id.btnSend)
        val btnSendUrl = findViewById<Button>(R.id.btnSendUrl)
        val btnSendUrl2 = findViewById<Button>(R.id.btnSendUrl2)
        val btnSendUrl3 = findViewById<Button>(R.id.btnSendUrl3)
        val btnSendUrl4 = findViewById<Button>(R.id.btnSendUrl4)
        val btnSendUrl5 = findViewById<Button>(R.id.btnSendUrl5)

        btnSent.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:")
                putExtra(Intent.EXTRA_SUBJECT, "Important Update: Policy Changes")
                putExtra(Intent.EXTRA_TEXT, "Dear [Recipient],\n\nThis is an urgent notification regarding [specific issue]. Please address this matter as soon as possible to avoid any disruptions.\n\nThank you for your prompt attention.\n\nBest regards,\n[Your Name]")
            }
            startActivity(Intent.createChooser(emailIntent, "Send mail using:"))
        }

        btnSendUrl.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://duckduckgo.com/"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        btnSendUrl2.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.bing.com/"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        btnSendUrl3.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://chatgpt.com/"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        btnSendUrl4.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        btnSendUrl5.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/"))
            startActivity(Intent.createChooser(urlIntent, "Open using:"))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
