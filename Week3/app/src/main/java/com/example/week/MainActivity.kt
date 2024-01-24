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

        var addFragment = findViewById<Button>(R.id.add_fragment)
        addFragment.setOnClickListener(View.OnClickListener {
            var fragment1 = Fragment1()
            supportFragmentManager.beginTransaction().add(R.id.framelayout,fragment1).commit()
           // supportFragmentManager.beginTransaction().add(fragment1,"1").commit()
        })

        var replaceFragment = findViewById<Button>(R.id.replace_fragment)
        replaceFragment.setOnClickListener(View.OnClickListener {
            var fragment2 = Fragment2()
           supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment2).commit()
//
        })

        var removeFragment = findViewById<Button>(R.id.remove_fragment)
        removeFragment.setOnClickListener(View.OnClickListener {
//            var fragment2 = Fragment2()
//            supportFragmentManager.beginTransaction().replace(R.id.framelayout,fragment2).commit()
//

           var fragment =  supportFragmentManager.findFragmentById(R.id.framelayout)
            if (fragment != null) {
                supportFragmentManager.beginTransaction().remove(fragment).commit()
            }
        })



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