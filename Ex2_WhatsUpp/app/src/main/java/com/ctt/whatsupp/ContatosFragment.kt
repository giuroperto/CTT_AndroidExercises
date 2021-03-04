package com.ctt.whatsupp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ctt.whatsupp.model.Contato

//trabalhar com fragments eh trabalhar com pequenos pedacos de uma activity
//fragments nao trabalham com intent -> arguments

//seria possivel passar uma lista aqui para o fragment que nem no adapter e trabalhar com as listas
// fragment eh uma mistura de adapter e activity -> mais flexivel
class ContatosFragment : Fragment() {
//    na activity que vou ficar, quero fazer algo na oncreate da Activity
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

//    onCreate da Fragment
//    mesma ideia de quando trabalha com recyclerview -> pode chamar esses fragments em qualquer momento da app
//    para mexer com os dados nao usa metodo abaixo uma vez que o layout n vai ter sido criado/inflado ainda
//    chama outro ciclo de vida -> onViewCreated()
//    na activity a gente comeca com o layout, aqui nao, por isso temos que utilizar outro ciclo de vida para adicionar o comportamento do fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contatos, container, false)
    }

//    toda a parte logica dos meus componentes
//    para fragments nao sabe o contexto, pois pode ser usado de qualquer lugar -> usar view de onde foi criada
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

                val listaConversa = mutableListOf<Contato>(
                Contato(imagem = null, nome = "Giulia", ultimaMensagem = "EEVEE!!!", horarioMensagem = "08:01 PM"),
                Contato(imagem = null, nome = "Henrique", ultimaMensagem = "PIKACHU!!!", horarioMensagem = "08:02 PM"),
                Contato(imagem = null, nome = "Daniel", ultimaMensagem = "ORCS!!!", horarioMensagem = "08:03 PM"),
                Contato(imagem = null, nome = "Afonso", ultimaMensagem = "ORCS!!!", horarioMensagem = "08:03 PM"),
                Contato(imagem = null, nome = "Cristina", ultimaMensagem = "ORCS!!!", horarioMensagem = "08:03 PM")
        )

        val rvConversas = view.findViewById<RecyclerView>(R.id.listaContatos)
    //        vinculando adapter a recycler view -> gerenciador de dados -> vincula os dois

        val adapterContato = ConversasAdapter(listaConversa)
        rvConversas.adapter = adapterContato

//    para indicar o contexto para o layoutmanager -> funcao -> this nao vai funcionar pois referira ao fragment
//    nao sabemos em que activity estamos -> fragment pode ser colocada em diversos lugares -> utilizar funcao requireContext()
        rvConversas.layoutManager = LinearLayoutManager(requireContext())

    }

}