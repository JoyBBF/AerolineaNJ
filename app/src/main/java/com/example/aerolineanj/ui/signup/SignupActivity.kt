package com.example.aerolineanj.ui.signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aerolineanj.R
import com.example.aerolineanj.ui.login.LoginActivity

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_signup)

        val username2 = findViewById<EditText>(R.id.username2)
        val password2 = findViewById<EditText>(R.id.password2)
        val password3 = findViewById<EditText>(R.id.password3)
        val signup = findViewById<Button>(R.id.signup)

        signup.setOnClickListener {
            var intent = Intent(this,  LoginActivity::class.java)
            startActivity(intent)
        }

    }
}