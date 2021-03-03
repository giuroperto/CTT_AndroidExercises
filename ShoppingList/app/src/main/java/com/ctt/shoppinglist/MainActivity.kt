package com.ctt.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.shoppinglist.model.ShoppingItem

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

//    fun deleteItem() {
//
//    }
}

// TODO: 02/03/2021 clear input fields
// TODO: 02/03/2021 delete item