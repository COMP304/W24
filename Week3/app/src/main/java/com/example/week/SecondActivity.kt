package com.example.week

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class SecondActivity  : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activty_second)
        Log.d("week3","in onCreate function A2")

        var numFromA1 = intent.getIntExtra("myNum",0)
        Log.d("week3", "The number from A1 is $numFromA1")
    }

    override fun onStart() {
        super.onStart()
        Log.d("week3","in onStart function A2")
    }

    override fun onResume() {
        super.onResume()
        Log.d("week3","in onResume function A2")
    }

    override fun onStop() {
        super.onStop()
        Log.d("week3","in onStop function A2")
    }

    override fun onPause() {
        super.onPause()
        Log.d("week3","in onPasue function A2")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("week3","in onDestroy function A2")
    }
}
