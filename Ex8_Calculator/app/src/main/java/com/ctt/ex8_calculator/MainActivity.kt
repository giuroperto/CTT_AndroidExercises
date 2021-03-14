package com.ctt.ex8_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularSoma(a: Int?, b: Int?) : String {

        var resultado = ""

        resultado = if(a == null || b == null) {
            "Insira um valor valido"
        } else {
            "O resultado e " + (a + b)
        }

        return resultado

//        val resultado = a + b
//        return "O resultado e: $resultado"
    }
}