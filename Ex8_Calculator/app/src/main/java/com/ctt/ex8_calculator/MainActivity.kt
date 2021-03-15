package com.ctt.ex8_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var result : TextView
    private lateinit var edtn1 : EditText
    private lateinit var edtn2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        result = findViewById(R.id.txtResult)
        edtn1 = findViewById(R.id.edtNumero1)
        edtn2 = findViewById(R.id.edtNumero2)

        val btnCalcular : Button = findViewById(R.id.btnCalcular)

//        PARA TESTAR TOASTS
//        btnCalcular.setOnClickListener {
//            Toast.makeText(this,
//                calcularSoma(1, 5),
//                Toast.LENGTH_SHORT).show()
//        }

//        PARA TESTAR COM CAMPO DA VIEW
        btnCalcular.setOnClickListener {
            result.text = calcularSoma(edtn1.text.toString().toIntOrNull(), edtn2.text.toString().toIntOrNull())
        }

    }

//    fun validarEntrada(a: String, b: String) : Boolean {
//        if a.isNotEmpty() && b.isNotEmpty()
//    }

//    boas praticas separar as funcoes -> funcoes puras em kotlin -> deixando Toast por exemplo em outro local
//    tudo que e Java -> JUNIT
//    devops desenvolvem as ferramentas para analizar coverage pois o que tem aqui do JUNIT eh meio burro

//    fun calcularSoma(a: String, b: String) : String {
    fun calcularSoma(a: Int?, b: Int?) : String {

//        val entradaValida = validarEntrada(a, b)
        var resultado = ""

//        if (entradaValida) {
        resultado = if (a != null && b != null) {
//            resultado = "O resultado e " + a.toInt() + b.toInt()
             "O resultado e " + (a + b)
        } else {
            "Insira um valor valido"
        }

//        resultado = if(a == null || b == null) {
//            "Insira um valor valido"
//        } else {
//            "O resultado e " + (a + b)
//        }

        return resultado

//        val resultado = a + b
//        return "O resultado e: $resultado"

    }
}
