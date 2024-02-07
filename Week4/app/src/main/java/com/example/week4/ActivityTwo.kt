package com.example.week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

class ActivityTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        var addFromMainActivity = intent.getIntExtra("addtion",0)

        var cityautocompletetext = findViewById<AutoCompleteTextView>(R.id.citytext)
        var cityArrayAdapter = ArrayAdapter(this,
            R.layout.dropdown_item_layout,
            R.id.autocompletetext,
            resources.getStringArray(R.array.cities))

        cityautocompletetext.setAdapter(cityArrayAdapter)


        var addResult = findViewById<TextView>(R.id.addition)
        addResult.text= "This is the result = $addFromMainActivity"

        var qcheckbox = findViewById<CheckBox>(R.id.quick_checkbox)

        var vcheckbox = findViewById<CheckBox>(R.id.vege_checkbox)



        var resultButton = findViewById<Button>(R.id.getresult_but)
        resultButton.setOnClickListener(View.OnClickListener {
            if (qcheckbox.isChecked && vcheckbox.isChecked){
                Toast.makeText(this, "Both", Toast.LENGTH_LONG).show()
            }else if  (!qcheckbox.isChecked && !vcheckbox.isChecked){
                Toast.makeText(this, "None of them", Toast.LENGTH_LONG).show()

            }else if (qcheckbox.isChecked && !vcheckbox.isChecked){
                Toast.makeText(this, "Quick Only", Toast.LENGTH_LONG).show()
            }else if (!qcheckbox.isChecked && vcheckbox.isChecked){
                Toast.makeText(this, "Vege Only", Toast.LENGTH_LONG).show()
            }
        })



    }
}