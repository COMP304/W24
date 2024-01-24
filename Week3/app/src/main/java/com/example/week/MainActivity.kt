package com.example.week

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var editText = findViewById<EditText>(R.id.valueFromuser)

        Log.d("week3","in onCreate function A1")


        var tosecondButton = findViewById<Button>(R.id.tosecond)

        tosecondButton.setOnClickListener(View.OnClickListener {
            // the code here will run when the button clicked.
            var intent = Intent(this, SecondActivity::class.java)
            if (!editText.text.isEmpty()){
                intent.putExtra("myNum",editText.text.toString().toInt())
            }


            startActivity(intent)
        })

    }


    override fun onStart() {
        super.onStart()
        Log.d("week3","in onStart function A1")
    }

    override fun onResume() {
        super.onResume()
        Log.d("week3","in onResume function A1")
    }

    override fun onStop() {
        super.onStop()
        Log.d("week3","in onStop function A1")
    }

    override fun onPause() {
        super.onPause()
        Log.d("week3","in onPasue function A1")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("week3","in onDestroy function A1")
    }
}