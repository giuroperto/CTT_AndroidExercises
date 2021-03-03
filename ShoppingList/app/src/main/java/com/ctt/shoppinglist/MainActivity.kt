package com.ctt.shoppinglist

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContentProviderCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.shoppinglist.model.ShoppingItem
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator

class MainActivity : AppCompatActivity() {

    private lateinit var addBtn : Button
    private lateinit var shopItem : EditText
    private lateinit var shopQt : EditText

    private lateinit var shoppingList : MutableList<ShoppingItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addBtn = findViewById(R.id.btnAdd)
        shopItem = findViewById(R.id.edtItem)
        shopQt = findViewById(R.id.edtQt)

        shoppingList = mutableListOf<ShoppingItem>(
                ShoppingItem("Milk", 2),
                ShoppingItem("Chocolate", 5),
                ShoppingItem("Orange Juice", 1),
                ShoppingItem("Oatmeal", 2),
                ShoppingItem("Bread", 1),
                ShoppingItem("Butter", 1),
                ShoppingItem("Tomatoes", 4),
        )

        val rvItems = findViewById<RecyclerView>(R.id.itemsList)

        val itemsAdapter = ShoppingItemsAdapter(shoppingList)
        rvItems.adapter = itemsAdapter
        rvItems.layoutManager = LinearLayoutManager(this)
        rvItems.itemAnimator = SlideInLeftAnimator()
        rvItems.itemAnimator?.apply {
            addDuration = 400
            removeDuration = 500
        }

        addBtn.setOnClickListener{
            val inputItem = shopItem.text.toString().capitalize()
            val inputQuantity = shopQt.text.toString()

            if (inputItem.isEmpty()) {
                shopItem.error = "Please inform an item"
            }

            if (inputQuantity.isEmpty()) {
                shopQt.error = "Please inform the quantity"
            }

            if (inputItem.isNotEmpty() && inputQuantity.isNotEmpty()) {

                itemsAdapter.addItem(
                        ShoppingItem(name = inputItem, quantity = inputQuantity.toInt())
                )

                Toast.makeText(this, "Item $inputItem successfully added!", Toast.LENGTH_SHORT).show()

                clearInputFields()
            }
        }
    }

    fun clearInputFields() {
        shopItem.text.clear()
        shopQt.text.clear()
    }

//    private companion object {
//        fun basicAlert(view: View) {
//            val alertDialogBuilder = android.app.AlertDialog.Builder()
//
//            with(alertDialogBuilder) {
//                setMessage(R.string.dialog_remove)
//                setPositiveButton(R.string.remove,  positiveButtonClick)
//                setNegativeButton(R.string.cancel, negativeButtonClick)
//                setIcon(android.R.drawable.dialog_holo_light_frame)
//            }
//
//            val alertDialog = alertDialogBuilder.create()
//            alertDialog.show()
//        }
//
//        val positiveButtonClick = {
//                dialog: DialogInterface, which: Int ->
//            Toast.makeText(, "REMOVE", Toast.LENGTH_SHORT).show()
//        }
//
//        val negativeButtonClick = {
//                dialog: DialogInterface, which: Int ->
//            Toast.makeText(, "CANCEL", Toast.LENGTH_SHORT).show()
//        }
//    }
}


// TODO: 03/03/2021  add alertDialog when removing