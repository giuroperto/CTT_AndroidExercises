package com.ctt.whatsupp

import android.content.Context
import androidx.core.content.res.TypedArrayUtils.getText
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager, pageAdapterContext: Context) : FragmentPagerAdapter(fm) {

    var contextHere = pageAdapterContext

//    equivalente ao ItemCount da RV
//    numero de fragments a serem colocadas
//    pode passar a lista ou colocar o numero fixo

//    FRAGMENTS:
//    1. Status
//    2. Conversas
//    3. Chamada

    override fun getCount(): Int {
        return 3
    }


//    a partir de uma posicao, que fragment retornar?
//    relacao entre item/posicao e a fragment a ser exibida

    override fun getItem(position: Int): Fragment {
        return when(position) {
//            CONVERSAS
            0 -> ContatosFragment()
//            STATUS
            1 -> ContatosFragment()
//            CHAMADAS
            2 -> ContatosFragment()
            else -> ContatosFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> contextHere.getString(R.string.conversas)
            1 -> "Status"
            2 -> "Chamadas"
            else -> super.getPageTitle(position)
//            poderia dar um return null pois vai acabar a lista, mas eh boa praticar utilizar o metodo
        }

//        final do codigo
//        return super.getPageTitle(position)
    }
}

// recycler view adapter -> passava uma lista com a DB
// no page adapter
// fragment manager deve ser passado
// activity tem visibilidade da aplicacao, enquanto a fragment nao -> precisa de alguem pra intermediar
// qdo a fragment precisar saber do contexto, quem vai atras dessa info eh o gerenciador de fragments
//fragmentpageadapter -> deprecated -> agora passa um comportamento como parametro tambem
// vai dizer como vai ser o ciclo de vida dessa fragment

// fragment manager -> para activity e fragment terem visibilidade de um do outro e se comunicarem -> eh chamado na activity para passar contexto

// para colocar o item no tab -> ver material design