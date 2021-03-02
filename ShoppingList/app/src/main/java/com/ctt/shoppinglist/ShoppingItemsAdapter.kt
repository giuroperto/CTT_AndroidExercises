package com.ctt.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.shoppinglist.model.ShoppingItem

class ShoppingItemsAdapter(private val shoppingList: MutableList<ShoppingItem>) : RecyclerView.Adapter<ShoppingItemsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoppingItem : TextView = view.findViewById(R.id.txtItem)
        val shoppingQuantity : TextView = view.findViewById(R.id.txtQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shoppingItem.text = shoppingList[position].name
        holder.shoppingQuantity.text = shoppingList[position].quantity.toString()
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }
}