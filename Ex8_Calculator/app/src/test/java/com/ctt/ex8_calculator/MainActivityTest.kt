package com.ctt.ex8_calculator

import android.widget.Button
import android.widget.Toast
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.Assert
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf

// NAO COLOCAR TESTS EM GITIGNORE

//para dizer que quem vai rodar o teste eh o Robolectric -> e nao o padrao JUnit
//dizendo que a classe de testes vai funcionar sob determinada biblioteca
@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    //    criar funcao para fazer teste -> clicar, executar, etc
//    dar nome a funcao de teste -> nome grande e bem especifico
//    especificar que eh um teste e a classe de teste

//    ao rodar funcao -> so o teste
//    rodar classe -> todos os testes

//    testes nao recebem parametros!

    //    para testar API
    val classeRetorno = Any()
    //    entraria o retorno esperado da API, se os parametros estao certos, etc
    val classeEsperada = Any()

    @Test
    fun clicarNoBotaoExibirToastComSucesso() {
//        criar a activity
//        robolectric vai simular o ciclo de vida -> coisa que o unitario nao consegue -> instancia diferente
        val activity = Robolectric.setupActivity(MainActivity::class.java)
        val btn = activity.findViewById<Button>(R.id.btnCalcular)

        btn.performClick()

//        conseguimos utilizar tudo que eh do android aqui
        val toastEsperado = Toast.makeText(activity.applicationContext, activity.calcularSoma(1, 5), Toast.LENGTH_SHORT).show()

//        tudo que se refere ao agora no Robolectric -> shadow
//        em tempo de desenvolvimento, pegue a app agora
//        atual -> aplicacao de agora
//        context pode ter mudado
        val toastAtual = shadowOf(RuntimeEnvironment.application).shownToasts

//        vai ser o ultimo pois so clicamos uma vez
        assertEquals(toastEsperado, toastAtual.last().show())
    }

    @Test
    fun somarDoisNumerosComSucesso() {
        val primeiroNumeroSucesso = 10
        val segundoNumeroSucesso = 5

        val resultadoFuncao = MainActivity().calcularSoma(primeiroNumeroSucesso, segundoNumeroSucesso)

//        teste do resultado esperado

        val resultadoEsperado = "O resultado e 15"

//        teste -> comparacao entre o resultado esperado e o obtido
//        existe a funcao assertEquals do JUnit para isso -> asseguro q o primeiro valor eh igual ao segundo

//        mais usados:
//        assertEquals()
//        assertThat()

        Assert.assertEquals(resultadoEsperado, resultadoFuncao)

//        para executar o teste, clicar no icone de flexas do lado e depois aparece na lista no toolbar
//        da para testar aqui tbm retorno de API -> mas eh teste integrado pois depende do retrofit -> android
    }

    fun somarDoisNumerosFinalizaComErro() {

    }

//    vamos testar todos os cenarios -> 1o nulo, 2o nulo, ambos nulos

    @Test
    fun somarDoisNumerosSendoOPrimeiroNuloErro() {
        val primeiroNumeroSucesso = null
        val segundoNumeroSucesso = 5

        val resultadoFuncao = MainActivity().calcularSoma(primeiroNumeroSucesso, segundoNumeroSucesso)

        val resultadoEsperado = "Insira um valor valido"

        Assert.assertEquals(resultadoEsperado, resultadoFuncao)

    }

    @Test
    fun somarDoisNumerosSendoOSegundoNuloErro() {
        val primeiroNumeroSucesso = 10
        val segundoNumeroSucesso = null

        val resultadoFuncao = MainActivity().calcularSoma(primeiroNumeroSucesso, segundoNumeroSucesso)

        val resultadoEsperado = "Insira um valor valido"

        Assert.assertEquals(resultadoEsperado, resultadoFuncao)

    }

    @Test
    fun somarDoisNumerosSendoAmbosNulosErro() {
        val primeiroNumeroSucesso = null
        val segundoNumeroSucesso = null

        val resultadoFuncao = MainActivity().calcularSoma(primeiroNumeroSucesso, segundoNumeroSucesso)

        val resultadoEsperado = "Insira um valor valido"

        Assert.assertEquals(resultadoEsperado, resultadoFuncao)

    }

}