package com.ctt.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
        rvItems.adapter = ShoppingItemsAdapter(shoppingList)
        rvItems.layoutManager = LinearLayoutManager(this)

        addBtn.setOnClickListener{
            val inputItem = shopItem.text.toString()
            val inputQuantity = shopQt.text.toString()

            if (inputItem.isEmpty()) {
                shopItem.error = "Please inform an item"
            }

            if (inputQuantity.isEmpty()) {
                shopQt.error = "Please inform the quantity"
            }

            if (inputItem.isNotEmpty() && inputQuantity.isNotEmpty()) {

                val newItem = ShoppingItem(name = inputItem, quantity = inputQuantity.toInt())
                addItem(newItem)
            }
        }
    }

    fun addItem(item: ShoppingItem) {

        shoppingList.add(item)
        showItem(item)
    }

    fun showItem(item: ShoppingItem) {
        Toast.makeText(this, "Item ${item.name} successfully added!", Toast.LENGTH_SHORT).show()
    }
}