package com.example.task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

var cartItems = arrayOf<String>("")

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)

        val names = arrayOf<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_checked, names)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item "+names[i]+" Added to Cart!", Toast.LENGTH_SHORT).show()
            cartItems+=names[i]
        }
    }
    fun viewCart(view: View) {
        setContentView(R.layout.cart)
        val listView1 = findViewById<ListView>(R.id.list_viw)
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, cartItems)
        listView1.adapter = arrayAdapter
        listView1.setOnItemClickListener{ adapterView, view, i, l ->
            cartItems[i] = ""
            arrayAdapter.notifyDataSetChanged()
        }
    }

    fun viewMenu(view: View) {
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.list_view)
        val names = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        listView.adapter = arrayAdapter
        listView.setOnItemClickListener { adapterView, view, i, l ->
            Toast.makeText(this, "Item "+names[i]+" Added to Cart!", Toast.LENGTH_SHORT).show()
            cartItems+=names[i]
        }
    }
}