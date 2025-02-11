package com.example.multimedia

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridAdapter(private val context: Context, private val items: List<GridItem>) : BaseAdapter() {

    override fun getCount(): Int = items.size

    override fun getItem(position: Int): Any = items[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.grid_item, parent, false)

        val imageView = view.findViewById<ImageView>(R.id.item_image)
        val textView = view.findViewById<TextView>(R.id.item_text)

        val item = items[position]
        imageView.setImageResource(item.imageResId)
        textView.text = item.name

        return view
    }
}

data class GridItem(val name: String, val imageResId: Int)
