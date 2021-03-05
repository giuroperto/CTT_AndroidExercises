package com.ctt.shoppinglist

import android.animation.Animator
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.ctt.shoppinglist.model.ShoppingItem
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder
import kotlin.math.hypot

class ShoppingItemsAdapter(private val shoppingList: MutableList<ShoppingItem>) : RecyclerView.Adapter<ShoppingItemsAdapter.ViewHolder>(){

    private lateinit var parentContext: View
    var btnOption: Boolean = false

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val shoppingItem : TextView = view.findViewById(R.id.txtItem)
        val shoppingQuantity : TextView = view.findViewById(R.id.txtQuantity)
        val delete : ImageView = view.findViewById(R.id.imgDelete)
    }

    fun addItem(newItem: ShoppingItem) {
        shoppingList.add(newItem).also {
            notifyItemInserted(itemCount - 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        parentContext = parent

        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shoppingItem.text = shoppingList[position].name
        holder.shoppingQuantity.text = shoppingList[position].quantity.toString()

        holder.delete.setOnClickListener {
            basicAlert(parentContext, position)
            btnOption = false
        }
    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    fun basicAlert(view: View, position: Int) {
        val alertDialogBuilder = AlertDialog.Builder(view.context)

        with(alertDialogBuilder) {
            setMessage(R.string.dialog_remove)
            setPositiveButton(R.string.remove,  DialogInterface.OnClickListener {
                    _, _ ->
                deleteItem(position)
                deleteMessage("Item removed!")
            })
            setNegativeButton(R.string.cancel, DialogInterface.OnClickListener {
                    _, _ ->
                btnOption = false
            })
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

    fun deleteMessage(type: String) {
        Toast.makeText(parentContext.context, type, Toast.LENGTH_SHORT).show()
    }

    fun deleteItem(position: Int) {
        shoppingList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, getItemCount())
    }

}