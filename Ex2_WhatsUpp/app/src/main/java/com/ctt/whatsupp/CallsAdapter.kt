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
//        holder.txtName.text = callsList[position].picture
//        holder.txtName.text = callsList[position].arrow
    }

    override fun getItemCount(): Int {
        return callsList.size
    }
}


// TODO: 04/03/2021 add picture 
// TODO: 04/03/2021 add arrow to model