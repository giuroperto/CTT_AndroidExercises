package com.ctt.ex8_calculator

//import junit.framework.Assert
import org.junit.Test
import org.junit.Assert

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