package com.ctt.whatsupp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Call

class CallsAdapter(private val callsList: MutableList<Call>) : RecyclerView.Adapter<CallsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val contactName : TextView = view.findViewById(R.id.txtName)
        val contactTime : TextView = view.findViewById(R.id.txtTime)
        val contactImg : ImageView = view.findViewById(R.id.imgContact)
        val ArrowImg : ImageView = view.findViewById(R.id.imgArrow)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CallsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.call_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CallsAdapter.ViewHolder, position: Int) {
        holder.contactName.text = callsList[position].name
        holder.contactTime.text = callsList[position].time

        if (callsList[position].picture == null) {
            when(callsList[position].name) {
                "Giulia" -> holder.contactImg.setImageResource(R.drawable.ic_elf)
                "Henrique" -> holder.contactImg.setImageResource(R.drawable.ic_zombie)
                "Afonso" -> holder.contactImg.setImageResource(R.drawable.ic_pirate)
                "Cristina" -> holder.contactImg.setImageResource(R.drawable.ic_tree)
                "Daniel" -> holder.contactImg.setImageResource(R.drawable.ic_orc)
                else -> holder.contactImg.setImageResource(R.drawable.ic_pirate)
            }
        }

        if (callsList[position].incoming) {
            if (callsList[position].successful) {
                holder.ArrowImg.setImageResource(R.drawable.ic_left_down_green)
            } else {
                holder.ArrowImg.setImageResource(R.drawable.ic_left_down_red)
            }
        } else {
            if (callsList[position].successful) {
                holder.ArrowImg.setImageResource(R.drawable.ic_right_up_green)
            } else {
                holder.ArrowImg.setImageResource(R.drawable.ic_right_up_red)
            }
        }
    }

    override fun getItemCount(): Int {
        return callsList.size
    }
}