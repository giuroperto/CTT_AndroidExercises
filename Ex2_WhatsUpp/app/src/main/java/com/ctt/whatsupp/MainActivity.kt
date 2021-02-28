package com.ctt.whatsupp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaConversa = mutableListOf<Contato>(
                Contato(imagem = null, nome = "Giulia", ultimaMensagem = "EEVEE!!!", horarioMensagem = "08:01 PM"),
                Contato(imagem = null, nome = "Henrique", ultimaMensagem = "PIKACHU!!!", horarioMensagem = "08:02 PM"),
                Contato(imagem = null, nome = "Daniel", ultimaMensagem = "ORCS!!!", horarioMensagem = "08:03 PM")
        )

        val rvConversas = findViewById<RecyclerView>(R.id.listaContatos)
    }
}