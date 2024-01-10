package com.example.week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var loginbutton = findViewById<Button>(R.id.login_button)

        // Kotlin is a functional language ==== everything is function
        loginbutton.setOnClickListener(View.OnClickListener { view ->
            Toast.makeText(this,"Log In clicked", Toast.LENGTH_LONG).show()
        })
    }


}