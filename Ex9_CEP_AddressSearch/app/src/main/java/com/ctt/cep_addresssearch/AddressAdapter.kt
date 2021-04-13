package com.ctt.cep_addresssearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val txtAddress : TextView = itemView.findViewById(R.id.txtAddress)
    val txtCity : TextView = itemView.findViewById(R.id.txtCity)
    val txtState : TextView = itemView.findViewById(R.id.txtState)
    val txtPostcode : TextView = itemView.findViewById(R.id.txtPostcode)
    val txtNeighbourhood : TextView = itemView.findViewById(R.id.txtNeighbourhood)
}

class AddressAdapter (
        private val addressList: List<Address>
) : RecyclerView.Adapter<AddressViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder =
            AddressViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_address, parent, false))

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        val item = addressList[position]

        holder.txtAddress.text = item.street
        holder.txtCity.text = item.city
        holder.txtState.text = item.state
        holder.txtPostcode.text = item.postcode
        holder.txtNeighbourhood.text = item.neighbourhood
    }

    override fun getItemCount(): Int = addressList.size
}