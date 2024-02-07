package com.example.week4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {
    private val itemsList = ArrayList<String>()
    lateinit var image : ImageView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image = findViewById<ImageView>(R.id.image)
        registerForContextMenu(image)

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


    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.image_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when (item.itemId){
            R.id.refresh ->
            {
                image.setImageDrawable(getDrawable(R.drawable.newimage))
                Toast.makeText(this, "Refresh The Image", Toast.LENGTH_LONG).show()
            }
            R.id.delete -> Toast.makeText(this, "Remove the image", Toast.LENGTH_LONG).show()
        }
        return true
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }


//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater = menuInflater
//         inflater.inflate(R.menu.main_menu, menu)
//
//            val menuItem1 : MenuItem? = menu?.add(0,1,1, "Add New")
//            kotlin.run {
//                menuItem1?.setShowAsAction(
//                    MenuItem.SHOW_AS_ACTION_IF_ROOM or
//                            MenuItem.SHOW_AS_ACTION_WITH_TEXT
//                )
//            }
//
//            return true
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       when(  item.itemId){
           R.id.addnew -> Toast.makeText(this, "Add New", Toast.LENGTH_LONG).show()
           R.id.remove -> Toast.makeText(this, "Remove Item", Toast.LENGTH_LONG).show()

       }
        return true
    }
}