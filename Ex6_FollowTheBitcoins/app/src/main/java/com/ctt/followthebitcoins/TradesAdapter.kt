package com.ctt.followthebitcoins

class TradesAdapter {
}

//package com.ctt.whatsupp
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.ctt.whatsupp.model.Call
//import com.ctt.whatsupp.model.Status
//
//class StatusAdapter(private var statusList: MutableList<Status>) : RecyclerView.Adapter<StatusAdapter.ViewHolder>() {
//
//    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        val contactName: TextView = view.findViewById(R.id.txtName)
//        val contactTime: TextView = view.findViewById(R.id.txtTime)
//        val contactImg: ImageView = view.findViewById(R.id.imgContact)
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StatusAdapter.ViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.status_item, parent, false)
//
//        return ViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: StatusAdapter.ViewHolder, position: Int) {
//        holder.contactName.text = statusList[position].name
//        holder.contactTime.text = statusList[position].time
//
//        if (statusList[position].picture == null) {
//            when(statusList[position].name) {
//                "Giulia" -> holder.contactImg.setImageResource(R.drawable.ic_elf)
//                "Henrique" -> holder.contactImg.setImageResource(R.drawable.ic_zombie)
//                "Afonso" -> holder.contactImg.setImageResource(R.drawable.ic_pirate)
//                "Cristina" -> holder.contactImg.setImageResource(R.drawable.ic_tree)
//                "Daniel" -> holder.contactImg.setImageResource(R.drawable.ic_orc)
//                else -> holder.contactImg.setImageResource(R.drawable.ic_pirate)
//            }
//        }
//
//    }
//
//    override fun getItemCount(): Int {
//        return statusList.size
//    }
//}
//
//// TODO: 04/03/2021 add picture