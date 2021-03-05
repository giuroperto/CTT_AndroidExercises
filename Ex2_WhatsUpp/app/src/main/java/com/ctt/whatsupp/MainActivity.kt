package com.ctt.whatsupp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var picture: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        picture = findViewById(R.id.imgCamera)

//        1. Vinculamos as fragments a viewpager

//        vincular tablayout e viewpager -> para vincular as tabs
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

//        funcao do android para pegar o gerenciador de fragments -> suporte -> questoes de compatibilidade
//        primeiro o adapter pra arrumar o viewpager -> criar fragments e organizar
        viewPager.adapter = PageAdapter(supportFragmentManager, this)
//        depois linka com as tabs
        tabLayout.setupWithViewPager(viewPager)

//        para organizar por tabs, ir no adapter e criar um novo metodo

        picture.setOnClickListener{
            abrirCamera()
        }

    }

    fun abrirCamera() {
        val CAMERA_REQUEST_CODE = 12345

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (cameraIntent.resolveActivity(packageManager) != null) {
            startActivityForResult(cameraIntent, CAMERA_REQUEST_CODE)
        } else {
            Toast.makeText(this, "Something went wrong...", Toast.LENGTH_SHORT).show()
        }
    }
}

// PASSOS PARA SE CRIAR UMA RECYCLERVIEW
// 1. TENHA EM MAOS OS SEUS DADOS (UMA MUTABLELISTOF POR EXEMPLO)
// 2. JA TENHA CRIADO A RECYCLERVIEW EM SEU XML -> rv no fragment_contatos
// 3. JA TENHA CRIADO O ITEM DA SUA LISTA EM XML -> item_contato
// 4. CRIE O SEU ADAPTER, INDIQUE QUE O ITEM DA SUA EM XML EH O ITEM DA RECYCLERVIEW VIA ONCREATEVIEWHOLDER -> ConversasAdapter
// 5. CRIE SUA CLASSE VIEWHOLDER, ENCONTRE OS ITENS EM SEU XML COM FINDVIEWBYID
// 6. VINCULE OS DADOS PASSADOS VIA ADAPTER AOS COMPONENTES VIA ONBINDVIEWHOLDER
// 7. VINCULE O ADAPTER DA SUA RECYCLERVIEW A UMA INSTANCIA DA SUA CLASSE ADAPTER COM SEUS DADOS
// 8. VINCULE UM GERENCIADOR DE LAYOUT (LAYOUT MANAGER) A SUA RECYCLERVIEW

// viewpager funciona como o recycler view -> forma de incluir fragments de maneira dinamica no meu app
// gerencia as fragments