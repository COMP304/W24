package com.example.week8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() , FirebaseInterfaceListener{
    val db = Firebase.firestore
    var firebaseService = FirebaseService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        firebaseService.listener = this
        firebaseService.getAllContactsFromDB()

        var nameText = findViewById<EditText>(R.id.cname);
        var phoneText = findViewById<EditText>(R.id.cphone);
        var yobteext = findViewById<EditText>(R.id.cYOB);

        var save = findViewById<Button>(R.id.save);
        save.setOnClickListener(View.OnClickListener {

          if (!nameText.text.isEmpty()&& (!phoneText.text.isEmpty()) && (!yobteext.text.isEmpty()) ) {
              var y = yobteext.text.toString().toInt()
              if (y > 1920 && y < 2024) {
                  val contact = Contact(nameText.text.toString(), phoneText.text.toString(), y)
                  FirebaseService().checkThenInsert(contact);
              }
          }
              })
              }

    override fun gettingContactsFromDBIsDone(list: ArrayList<Contact>) {
        Log.d("all contacts", "The size is "+ list.size)


    }


}
