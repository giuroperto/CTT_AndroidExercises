package com.ctt.whatsupp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

class ConversasAdapter(private val listaContatos: MutableList<Contato>) : RecyclerView.Adapter<ConversasAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val nomeContato : TextView = view.findViewById(R.id.txtContato)
        val imgContato : ImageView = view.findViewById(R.id.imgContato)
        val ultimaMensagem : TextView = view.findViewById(R.id.txtMensagem)
        val horaMensagem : TextView = view.findViewById(R.id.txtHorario)
    }

    fun adicionarContato(novoContato: Contato) {
        listaContatos.add(novoContato)
        notifyDataSetChanged()
    }

    fun fixarContato(contatinho: Contato) {
        listaContatos.add(0, contatinho)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nomeContato.text = listaContatos[position].nome
        holder.ultimaMensagem.text = listaContatos[position].ultimaMensagem
        holder.horaMensagem.text = listaContatos[position].horarioMensagem

        if (listaContatos[position].imagem == null) {
            when(listaContatos[position].nome) {
                "Giulia" -> holder.imgContato.setImageResource(R.drawable.ic_elf)
                "Henrique" -> holder.imgContato.setImageResource(R.drawable.ic_zombie)
                "Afonso" -> holder.imgContato.setImageResource(R.drawable.ic_pirate)
                "Cristina" -> holder.imgContato.setImageResource(R.drawable.ic_tree)
                "Daniel" -> holder.imgContato.setImageResource(R.drawable.ic_orc)
                else -> holder.imgContato.setImageResource(R.drawable.ic_pirate)
            }
        }

    }

    override fun getItemCount(): Int = listaContatos.size
}
