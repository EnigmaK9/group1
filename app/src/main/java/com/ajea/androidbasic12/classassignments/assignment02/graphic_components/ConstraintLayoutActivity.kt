package com.ajea.androidbasic12.classassignments.assignment02.graphic_components

import android.os.Bundle
import android.text.Editable
import android.text.SpannableString
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.text.style.UnderlineSpan
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ajea.androidbasic12.R

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var rememberMeCheckBox: CheckBox
    private lateinit var loadingProgressBar: ProgressBar
    private lateinit var helpButton: ImageButton
    private lateinit var forgotPasswordTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_constraint_layout)

        // Set window insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        emailEditText = findViewById(R.id.etEmail)
        passwordEditText = findViewById(R.id.etPassword)
        loginButton = findViewById(R.id.btnSend)
        rememberMeCheckBox = findViewById(R.id.cbRememberMe)
        loadingProgressBar = findViewById(R.id.pbLoading)
        helpButton = findViewById(R.id.ibHelp)
        forgotPasswordTextView = findViewById(R.id.tvForgotPassword)

        // Add underline to forgotPasswordTextView programmatically
        val forgotPasswordText = SpannableString(forgotPasswordTextView.text.toString())
        forgotPasswordText.setSpan(UnderlineSpan(), 0, forgotPasswordText.length, 0)
        forgotPasswordTextView.text = forgotPasswordText
        forgotPasswordTextView.movementMethod = LinkMovementMethod.getInstance()

        // Add TextWatcher to EditText
        emailEditText.addTextChangedListener(loginTextWatcher)
        passwordEditText.addTextChangedListener(loginTextWatcher)

        // Set onClickListener for login button
        loginButton.setOnClickListener {
            login()
        }

        // Set onClickListener for help button
        helpButton.setOnClickListener {
            showHelp()
        }

        // Set onClickListener for forgot password TextView
        forgotPasswordTextView.setOnClickListener {
            Toast.makeText(this, "Function not implemented yet", Toast.LENGTH_SHORT).show()
        }
    }

    // TextWatcher for enabling/disabling login button
    private val loginTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val emailInput = emailEditText.text.toString().trim()
            val passwordInput = passwordEditText.text.toString().trim()
            loginButton.isEnabled = emailInput.isNotEmpty() && passwordInput.isNotEmpty()
        }

        override fun afterTextChanged(s: Editable?) {}
    }

    // Function to handle login
    private fun login() {
        loadingProgressBar.visibility = ProgressBar.VISIBLE
        // Simulate login process
        val email = emailEditText.text.toString().trim()
        val password = passwordEditText.text.toString().trim()

        // Placeholder for actual login logic
        if (email == "test@example.com" && password == "password") {
            Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
        }
        loadingProgressBar.visibility = ProgressBar.GONE
    }

    // Function to show help
    private fun showHelp() {
        Toast.makeText(this, "Help button clicked", Toast.LENGTH_SHORT).show()
        // Placeholder for actual help logic
    }
}
