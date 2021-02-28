package com.ctt.whatsupp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

// adapter pede viewholder
// herda dessa interface/classe
// adapter => responsavel por vincular a lista de dados ao item de lista

// classe dentro de classe nao eh ma pratica desde que se trate de recyclerview

//SEGUNDO PASSO A SER LIDO
// vincular o set de dados a minha view -> o nome do objeto contato ao nome do xml
// Responsavel por vincular os dados vindos da listaCOntatos ao XML item_contato
// ViewHolder -> segurador de view -> para indicar que tem um componente grafico que sera exibido na recycler view
// preciso declarar que ela existe para instancia-la
class ConversasAdapter(private val listaContatos: MutableList<Contato>) : RecyclerView.Adapter<ConversasAdapter.ViewHolder>() {

//    PRIMEIRO PASSO A SER LIDO
//    vincular a recycler view aos itens dela -> xml
//     viewholder eh equivalente a como se fosse a ACTIVITY do item da lista
//    Item final a ser visualizado e inserido na recycler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

//    quando criar o layout da lista, ele retorna ja preenchido
//    metodo abstrato pede que retorne um viewHolder
//     equivalente ao onCreate da Activity -> no caso a nossa celula/item da recyclerview
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//    LayouInflater -> criador de layout
//    passa contexto de view group -> a mae dos componentes graficos do android
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}