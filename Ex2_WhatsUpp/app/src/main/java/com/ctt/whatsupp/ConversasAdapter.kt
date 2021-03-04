package com.ctt.whatsupp

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

// adapter pede viewholder
// herda dessa interface/classe
// adapter => responsavel por vincular a lista de dados ao item de lista

// classe dentro de classe nao eh ma pratica desde que se trate de recyclerview

//SEGUNDO PASSO A SER LIDO
// vincular o set de dados a minha view -> o nome do objeto contato ao nome do xml
// Responsavel por vincular os dados vindos da listaCOntatos ao XML item_contato (celula/item da lista)
// ViewHolder -> segurador de view -> para indicar que tem um componente grafico que sera exibido na recycler view
// preciso declarar que ela existe para instancia-la
class ConversasAdapter(private val listaContatos: MutableList<Contato>) : RecyclerView.Adapter<ConversasAdapter.ViewHolder>() {

//    PRIMEIRO PASSO A SER LIDO
//    vincular a recycler view aos itens dela -> xml
//     viewholder eh equivalente a como se fosse a ACTIVITY do item da lista
//    Item final a ser visualizado e inserido na recycler

    // boas praticas manter esse trecho de codigo aqui pois centraliza tudo ref a recycler view
    // view eh o gerenciamento do android de layout -> tudo que vem de layout eh view
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // aqui que vamos fazer o vinculo do xml com o kotlin, por exemplo o findviewbyid

    // tudo que eh componente grafico vem de view

        val nomeContato : TextView = view.findViewById(R.id.txtContato)
        val imgContato : ImageView = view.findViewById(R.id.imgContato)
        val ultimaMensagem : TextView = view.findViewById(R.id.txtMensagem)
        val horaMensagem : TextView = view.findViewById(R.id.txtHorario)

    }

//    quando criar o layout da lista, ele retorna ja preenchido
//    metodo abstrato pede que retorne um viewHolder
//     equivalente ao onCreate da Activity -> no caso a nossa celula/item da recyclerview
    
    // qual a base da minha viewholder? item-contato -> metodo do adapter e nao do viewholder
    // view eh a instancia/criacao do R.layout.item_contato
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//    LayouInflater -> criador de layout
//    passa contexto de view group -> a mae dos componentes graficos do android

//        se o layout nao tem pai, esta vinculado a outro componente, dentro de outro layout, o context eh esse outro layout e o attachToRoot seria true pois tem que linkar os dois
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_contato, parent, false)

        // retorna uma instancia da viewholder
//        fala qual eh a referencia do layout a ser utilizado
        return ViewHolder(view)
    }

//    metodo para ligar tudo
//    Responsavel por VINCULAR os dados com os componentes do xml
//    Contato da lista = texto de contato do xml
//    bind eh executado toda vez que tiver um item na minha lista
    
    // classe abstrata obriga a aplicar todos os metodos abstratos

//    vincula agora os atributos da viewholder (celula) com os itens da lista de contatos
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

    //        serve apenas para ter o controle do tamanho da nossa lista
    override fun getItemCount(): Int {
        return listaContatos.size
    }

}

//boa pratica -> bind view
//metodo que vai vincular variaveis e dados dentro do viewholder
// fun bindView() {}
