package com.example.week8

class Contact {

    lateinit var name: String
    lateinit var phone: String
    var yob: Int = 0

    constructor(name: String, phone: String, yob: Int) {
        this.name = name
        this.phone = phone
        this.yob = yob
    }

    fun toMap(): Map<String,Any> {
        return hashMapOf(
            "name" to name,
            "phone" to phone,
            "yob" to yob,
        )
    }


}