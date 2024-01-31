package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        var addFromMainActivity = intent.getIntExtra("addtion",0)

        var addResult = findViewById<TextView>(R.id.addition)
        addResult.text= "This is the result = $addFromMainActivity"

    }
}