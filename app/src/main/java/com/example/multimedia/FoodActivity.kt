package com.example.multimedia

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FoodActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        val productName = intent.getStringExtra("productName")
        val productImage = intent.getIntExtra("productImage", 0)

        val imageView: ImageView = findViewById(R.id.image)
        val productNameTextView: TextView = findViewById(R.id.productname_text)
        val addButton: Button = findViewById(R.id.add_button)
        val cart: ImageButton = findViewById(R.id.cart)
        val back: ImageButton = findViewById(R.id.back)

        productNameTextView.text = productName
        imageView.setImageResource(productImage)

        addButton.setOnClickListener {
            productName?.let {
                val product = CartItem(it, productImage)
                CartManager.addItem(product)
                Toast.makeText(this, "$it añadido al carrito", Toast.LENGTH_SHORT).show()
            }
        }

        cart.setOnClickListener{
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }

        back.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}

