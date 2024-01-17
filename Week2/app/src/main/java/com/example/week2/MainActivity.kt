package com.example.week2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    var c : Int = 4;
    var k = 'c';// char
    var email : String? = "123@hotmail.com"

    fun doMath(a: Int, b: Int, op: (Int,Int)->Int) : Int{
        return op(a,b)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var titleOfTheApp : Int = R.string.title
        Log.d("Apptitle"," "+getColor(R.color.red) )

        var functionBut = findViewById<Button>(R.id.functionInKotlin)
        functionBut.setOnClickListener(View.OnClickListener {
            for (x in 1..10 step 3) {
                Log.d("w21", "$x")
            }
            Toast.makeText(this,R.string.meg,Toast.LENGTH_LONG).show()
        })


        var addition = doMath(22,33,{a, b -> a + b})
        var sub =  doMath(22,33,{a, b -> a - b})
        var times =  doMath(22,33,{a, b -> a * b})
        var divid =  doMath(22,33,{a, b -> a / b})
        Log.d("doMath", " 22 + 33 = $addition")
        Log.d("doMath", " 22 - 33 = $sub")
        Log.d("doMath", " 22 * 33 = $times")
        Log.d("doMath", " 22 / 33 = $divid")




        Log.d("w21", DisplayTheDate(1))

        sum(11, 22)

        var r = biggerThan(33.2,88.4)
        Log.d("w2","Bigger Than function's result = $r")

        var s = "112"
        var i :Int? = s.toIntOrNull()
       // Log.d("w2","i is not null $i")
        if (i != null){
            Log.d("w2","i is not null $i")
        }else
            Log.d("w2","i is null")

    }
    fun sum(a : Int, b: Int): Unit{

        var result = a + b

        Log.d("w2","The result of the sum is $result")
        Log.d("w2","My email is  $email")
    }

    fun DisplayTheDate(month: Any): String{
       return when (month) {
            is String -> "The month is $month"
            is Int -> "The month is $month"
            else -> "The month is undified"
        }
    }


    fun biggerThan1(num1: Double, num2: Double) :Double {
        if (num1 > num2)
            return num1
        else
            return num2
    }

    fun biggerThan(num1: Double, num2: Double) = if (num1 > num2) num1 else num2







}