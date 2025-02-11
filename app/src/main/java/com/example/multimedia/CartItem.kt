package com.example.multimedia

data class CartItem(
    val name: String,
    val imageResId: Int
                   )
object CartManager {
    val cartItems = mutableListOf<CartItem>()

    fun addItem(item: CartItem) {
        cartItems.add(item)
    }

    fun getItems(): List<CartItem> {
        return cartItems
    }

    fun clearItems(){
        cartItems.clear()
    }
}