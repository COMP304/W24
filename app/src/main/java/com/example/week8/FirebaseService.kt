package com.example.week8

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore


interface FirebaseInterfaceListener {
    fun gettingContactsFromDBIsDone(list: ArrayList<Contact>)
}
class FirebaseService {
    val db = Firebase.firestore
    var listener : FirebaseInterfaceListener? = null
    infix fun checkThenInsert (c: Contact){
        db.collection("Contacts")
            .whereEqualTo("name", c.name).
            whereEqualTo("phone",c.phone).
            whereEqualTo("yob",c.yob)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {

                    Log.d("firebase", "${document.id} => ${document.data}")
                }
                if (documents.documents.size == 0) {
                    // insert
                    db.collection("Contacts")
                        .add(c.toMap())
                        .addOnSuccessListener { documentReference ->
                            Log.d(
                                "firestore",
                                "DocumentSnapshot added with ID: ${documentReference.id}"
                            )
                        }
                        .addOnFailureListener { e ->
                            Log.w("firestore", "Error adding document", e)
                        }
                }else {
                    Log.d("firebase", "The contact is already in the database")

                }
            }
            .addOnFailureListener { exception ->
                Log.w("firebase", "Error getting documents: ", exception)
            }
    }

    fun getAllContactsFromDB(){
        var listOfContact = arrayListOf<Contact>()
        var i = 0
        db.collection("Contacts")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("firebase", "${document.id} => ${document.data}")
                    var name = document.data.get("name") as String
                    var phone = document.data.get("phone") as String
                     var yob = document.data.get("yob") as Number
                    var c = Contact(name,phone,yob.toInt())
                    listOfContact.add(c)
                }
                listener!!?.gettingContactsFromDBIsDone(listOfContact)
            }
            .addOnFailureListener { exception ->
                Log.d("firebase", "Error getting documents: ", exception)
            }
    }

}