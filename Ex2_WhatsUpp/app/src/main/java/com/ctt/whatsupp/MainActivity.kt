package com.ctt.whatsupp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AbsListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

// PASSOS PARA SE CRIAR UMA RECYCLERVIEW
// 1. TENHA EM MAOS OS SEUS DADOS (UMA MUTABLELISTOF POR EXEMPLO)
// 2. JA TENHA CRIADO A RECYCLERVIEW EM SEU XML
// 3. JA TENHA CRIADO O ITEM DA SUA LISTA EM XML
// 4. CRIE O SEU ADAPTER, INDIQUE QUE O ITEM DA SUA EM XML EH O ITEM DA RECYCLERVIEW VIA ONCREATEVIEWHOLDER
// 5. CRIE SUA CLASSE VIEWHOLDER, ENCONTRE OS ITENS EM SEU XML COM FINDVIEWBYID
// 6. VINCULE OS DADOS PASSADOS VIA ADAPTER AOS COMPONENTES VIA ONBINDVIEWHOLDER
// 7. VINCULE O ADAPTER DA SUA RECYCLERVIEW A UMA INSTANCIA DA SUA CLASSE ADAPTER COM SEUS DADOS
// 8. VINCULE UM GERENCIADOR DE LAYOUT (LAYOUT MANAGER) A SUA RECYCLERVIEW