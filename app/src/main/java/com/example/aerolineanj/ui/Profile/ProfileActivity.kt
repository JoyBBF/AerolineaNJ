package com.example.aerolineanj.ui.Profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.aerolineanj.R
import com.example.aerolineanj.data.model.User
import com.example.aerolineanj.ui.login.LoginActivity
import java.sql.Date

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_profile)
        var user = User("Mari", "Maria", "Solano", "123", "maria@gmail.com", Date.valueOf("1970-02-03"), 0, 111, 222, "abc", 0)
        findViewById<EditText>(R.id.textView11).setText(user.username)
        findViewById<EditText>(R.id.textView22).setText(user.name)
        findViewById<EditText>(R.id.textView33).setText(user.lastName)
        findViewById<EditText>(R.id.textView44).setText(user.email)
        findViewById<EditText>(R.id.textView55).setText(user.workPhone)
        findViewById<EditText>(R.id.textView66).setText(user.cellPhone)
        findViewById<EditText>(R.id.textView77).setText(user.direction)


        findViewById<Button>(R.id.SaveProfile).setOnClickListener{
            user.username = findViewById<EditText>(R.id.textView11).text.toString()
            user.name = findViewById<EditText>(R.id.textView22).text.toString()
            user.lastName = findViewById<EditText>(R.id.textView33).text.toString()
            user.email = findViewById<EditText>(R.id.textView44).text.toString()
            user.workPhone = findViewById<EditText>(R.id.textView55).text.toString().toInt()
            user.cellPhone = findViewById<EditText>(R.id.textView66).text.toString().toInt()
            user.direction = findViewById<EditText>(R.id.textView77).text.toString()
        }


    }

}