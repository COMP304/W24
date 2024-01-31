package com.example.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerList = findViewById<RecyclerView>(R.id.list)
        var recyclerAdapter = RecyclerViewAdapter(itemsList)

        recyclerList.adapter = recyclerAdapter

       // var lmanager = GridLayoutManager(applicationContext,20)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerList.layoutManager = layoutManager

        itemsList.add("Red")
        itemsList.add("Black")
        itemsList.add("Blue")
        itemsList.add("Yellow")
        itemsList.add("Orange")
        itemsList.add("White")

        recyclerAdapter.notifyDataSetChanged()


        var num1Text = findViewById<EditText>(R.id.num1)
        var num2Text = findViewById<EditText>(R.id.num2)


        var addButto = findViewById<Button>(R.id.add);
        addButto.setOnClickListener(View.OnClickListener {

              if ( num1Text.text.toString().isEmpty() ||
                  num2Text.text.toString().isEmpty()){
                  Toast.makeText(this, "Missing Numbers!!",
                      Toast.LENGTH_LONG).show()
              }else {

                  var addtion = num1Text.text.toString().toInt() +
                          num2Text.text.toString().toInt()

                  var intent = Intent(this,
                      ActivityTwo::class.java);
                  intent.putExtra("addtion",addtion)
                  startActivity(intent);
              }
        })




    }
}