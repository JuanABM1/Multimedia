package com.example.multimedia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        var cartItems = CartManager.getItems()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        val back: ImageButton = findViewById(R.id.back)
        val order: ImageButton = findViewById(R.id.order)

        recyclerView.layoutManager = LinearLayoutManager(this)
        var adapter = CartAdapter(cartItems)
        recyclerView.adapter = adapter

        back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        order.setOnClickListener {
            CartManager.clearItems()
            cartItems = emptyList()
            adapter = CartAdapter(cartItems)
            recyclerView.adapter = adapter
            Toast.makeText(this, "Pedido hecho", Toast.LENGTH_SHORT).show()
        }
    }

}
