package com.ctt.whatsupp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

class ContatosFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contatos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                // DADOS
                val listaConversa = mutableListOf<Contato>(
                Contato(imagem = null, nome = "Giulia", ultimaMensagem = "Êl síla erin lû e-govaned vîn.", horarioMensagem = "08:01 PM"),
                Contato(imagem = null, nome = "Henrique", ultimaMensagem = "Ooo gRRr nuurg ahHH aaaraaa RrRaAa!!", horarioMensagem = "08:02 PM"),
                Contato(imagem = null, nome = "Daniel", ultimaMensagem = "Lok'vadnod", horarioMensagem = "08:03 PM"),
                Contato(imagem = null, nome = "Afonso", ultimaMensagem = "Aaaarrrrgggghhhh! Ahoy, Matey!", horarioMensagem = "08:03 PM"),
                Contato(imagem = null, nome = "Cristina", ultimaMensagem = "Taurelilómëa-tumbalemorna Tumbaletaurëa Lómëanor", horarioMensagem = "08:03 PM")
        )

        val rvConversas = view.findViewById<RecyclerView>(R.id.listaContatos)

        val adapterContato = ConversasAdapter(listaConversa)

        rvConversas.adapter = adapterContato
        rvConversas.layoutManager = LinearLayoutManager(requireContext())

    }

}