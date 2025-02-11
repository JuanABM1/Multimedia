package com.example.multimedia

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.GridView
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
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
        val items = listOf("Refrescos", "Alcohol", "Entrantes", "Sushi", "Total")
        val adapter = ArrayAdapter(this, R.drawable.list_item, R.id.item_text, items)
        val editText: EditText = findViewById(R.id.search_bar_text)
        val imagebutton: ImageButton = findViewById(R.id.shopping_car_button)
        val imagebutton2: ImageButton = findViewById(R.id.search)
        listView.adapter = adapter

        val gridView: GridView = findViewById(R.id.products_gridview)

        val products1 = listOf(
            GridItem("Agua", R.drawable.agua),
            GridItem("Coca cola", R.drawable.cocacola),
            GridItem("Sprite", R.drawable.sprite),
                              )

        val products2 = listOf(
            GridItem("Vino", R.drawable.vino),
            GridItem("Cava", R.drawable.cava),
            GridItem("Cerveza", R.drawable.cerveza),
                              )

        val products3 = listOf(
            GridItem("Gyozas de carne", R.drawable.gyozas_carne),
            GridItem("Gyozas vegetales", R.drawable.gyozas_vegetales),
            GridItem("Alitas de pollo", R.drawable.pollo),
            GridItem("Filete de pollo", R.drawable.pollo2),
                              )

        val products4 = listOf(
            GridItem("Maki de salmón", R.drawable.salmon),
            GridItem("Maki de atún", R.drawable.atun),
            GridItem("Arroz", R.drawable.gyozas_carne),
        )

        val productsTotal = listOf(
            GridItem("Agua", R.drawable.agua),
            GridItem("Coca cola", R.drawable.cocacola),
            GridItem("Sprite", R.drawable.sprite),
            GridItem("Vino", R.drawable.vino),
            GridItem("Cava", R.drawable.cava),
            GridItem("Cerveza", R.drawable.cerveza),
            GridItem("Gyozas de carne", R.drawable.gyozas_carne),
            GridItem("Gyozas vegetales", R.drawable.gyozas_vegetales),
            GridItem("Alitas de pollo", R.drawable.pollo),
            GridItem("Filete de pollo", R.drawable.pollo2),
            GridItem("Maki de salmón", R.drawable.salmon),
            GridItem("Maki de atún", R.drawable.atun),
            GridItem("Arroz", R.drawable.gyozas_carne),
                                  )

        listView.setOnItemClickListener { _, _, position, _ ->
            if (position == 0){
                val adapter2 = GridAdapter(this, products1)
                gridView.adapter = adapter2
            } else if (position == 1){
                val adapter2 = GridAdapter(this, products2)
                gridView.adapter = adapter2
            } else if (position == 2){
                val adapter2 = GridAdapter(this, products3)
                gridView.adapter = adapter2
            } else if (position == 3){
                val adapter2 = GridAdapter(this, products4)
                gridView.adapter = adapter2
            } else if (position == 4){
                val adapter2 = GridAdapter(this, productsTotal)
                gridView.adapter = adapter2
            }
        }

        val adapter2 = GridAdapter(this, products1)
        gridView.adapter = adapter2

        imagebutton2.setOnClickListener {
            // Buscar el producto
            val nombreBuscado = editText.text.toString()

            // Filtrar los productos que coincidan con el nombre buscado
            val productosFiltrados = productsTotal.filter {
                it.name.equals(nombreBuscado, ignoreCase = true)
            }

            // Verificar si se encontraron productos
            if (productosFiltrados.isNotEmpty()) {
                // Crear el adaptador con los productos filtrados
                val adapter2 = GridAdapter(this, productosFiltrados)
                gridView.adapter = adapter2
            } else {
                // Si no se encuentra ningún producto, mostrar un mensaje
                Toast.makeText(this, "Producto no encontrado", Toast.LENGTH_SHORT).show()
            }
        }

    }
}