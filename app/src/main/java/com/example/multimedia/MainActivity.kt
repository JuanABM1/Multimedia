package com.example.multimedia

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.categories_list)
        val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8", "Item 9", "Item 10", "Item 11", "Item 12", "Item 13", "Item 14", "Item 15", "Item 16", )
        val adapter = ArrayAdapter(this, R.drawable.list_item, R.id.item_text, items)
        listView.adapter = adapter

        val gridView: GridView = findViewById(R.id.products_gridview)

        val items2 = listOf(
            GridItem("Gyozas de carne", R.drawable.gyozas_carne),
            GridItem("Gyozas vegetales", R.drawable.gyozas_carne),
            GridItem("Alitas de pollo", R.drawable.gyozas_carne),
            GridItem("Filete de pollo", R.drawable.gyozas_carne),
            GridItem("Fideos fritos", R.drawable.gyozas_carne),
            GridItem("Fideos de arroz", R.drawable.gyozas_carne),
            GridItem("Pollo teriyaki", R.drawable.gyozas_carne),
            GridItem("Tempura", R.drawable.gyozas_carne),
            GridItem("Rollitos primavera", R.drawable.gyozas_carne)
        )

        val adapter2 = GridAdapter(this, items2)
        gridView.adapter = adapter2

    }
}