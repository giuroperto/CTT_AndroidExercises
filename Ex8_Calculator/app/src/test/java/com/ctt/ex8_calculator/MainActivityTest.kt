package com.ctt.ex8_calculator

import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import junit.framework.Assert.*
import org.junit.After
import org.junit.Test
import org.junit.Assert
import org.junit.Before
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.Shadows.shadowOf
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config
import org.w3c.dom.Text

// NAO COLOCAR TESTS EM GITIGNORE

//para dizer que quem vai rodar o teste eh o Robolectric -> e nao o padrao JUnit
//dizendo que a classe de testes vai funcionar sob determinada biblioteca

// A versao 4.4 do Robolectric nao tem suporte para o SDK 30
// Nao precisa mudar no projeto!!! Da para adicionar a configuracao do teste

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
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

    private lateinit var activity: MainActivity

//    controlador tem acesso a algumas informacoes que a activity nao tem, se preferir, separe os dois -> boa pratica
//    visao macro da activity -> tem visao de tudo
//    testar os intents dela, testar mudar o ciclo de vida... mais maleabilidade nos testes
    private lateinit var controller: ActivityController<MainActivity>

    //        ROBOLECTRIC TEM 3 PASSOS:
//        ANTES - PREPARAR O AMBIENTE DE TESTES
@Before
    fun setup() {

        controller = Robolectric.buildActivity(MainActivity::class.java)

//        preciso criar a activity para ter acesso ao botao -> onCreate
//        robolectric que cria a activity para nos, simula a sua criacao -> mas eh o gerador de activity (activity controladora) e nao a activity em si
//        opcoes de mexer em ciclo de vida
//        pega a activity no onCreate, da um start na activity, e pega o que ela gerar
//        activity = Robolectric.buildActivity(MainActivity::class.java).create().start().get()

        activity = controller.create().start().get()
    }


//        TESTE
//    todos os testes elaborados

//        DEPOIS - O QUE FAZER APOS O TESTE, TOTALMENTE OPCIONAL
//    dar um fim na activity

    @After
    fun tearDown() {
        Log.d("TAG", "alguma informacao")
        activity.finish()
    }

    @Test
    fun clicarBotaoExibirResultadoComSucesso() {
//        nao eh so instanciar a classe, mas sim rodar, mexer nos ciclos de vida dela...
//        e nao se faz que nem nos testes unitarios basicos com MainActivity()

        val botao = activity.findViewById<Button>(R.id.btnCalcular)
        val n1 = activity.findViewById<EditText>(R.id.edtNumero1)
        val n2 = activity.findViewById<EditText>(R.id.edtNumero2)

//        compare das duas -> pois ao clicar geraria uma nova activity
//        activity.startNextMatchingActivity(MainActivity2::class.java)

        n1.setText("1")
        n2.setText("2")
        botao.performClick()

        val resultadoAtual = activity.findViewById<TextView>(R.id.txtResult).text.toString()
        val resultadoEsperado = activity.calcularSoma(1, 2)

        assertEquals(resultadoEsperado, resultadoAtual)

//        um teste pode ter mais de um assert -> so vai dar como OK se passar em todos
//        assertEquals(activity.findViewById(R.id.txtResult), TextView)
        assertNotNull(resultadoAtual)
    }

//    TDD: QUAIS SAO OS CENARIOS DE ERRO/SUCESSO QUE PODEM OCORRER NO MEU APP?
//    BDD: cenario de caso do usuario -> dado que sou um usuario querendo calcular dois numeros, quando eu inserir um deles como vazio
//    deve retornar uma mensagem de valor invalido
//    Quando eu fizer algo relacionado a essa acao, ter um retorno
//    Dado que, quando, deve ser

    @Test
    fun clicarBotaoExibirResultadoErro() {

        val botao = activity.findViewById<Button>(R.id.btnCalcular)
        val n1 = activity.findViewById<EditText>(R.id.edtNumero1)
        val n2 = activity.findViewById<EditText>(R.id.edtNumero2)

        n1.setText(null)
        n1.setText("2")
        botao.performClick()

//        teste vai dar erro pois eh engenharia reversa... design para falhar, pois primeiro se faz o teste
//        depois faz o possivel no codigo para chegar ao resultado esperado
//        intuito primeiro eh fazer o teste passar e depois vamos refatorar para melhorar
//        val resultadoEsperado = activity.validarEntrada(n1.text.toString(), n2.text.toString())
        val resultadoCalcularSoma = activity.calcularSoma(
            n1.text.toString().toIntOrNull(),
            n2.text.toString().toIntOrNull())
        val resultadoAtual = activity.findViewById<TextView>(R.id.txtResult).text.toString()

        assertEquals(resultadoCalcularSoma, resultadoAtual)
//        assertFalse(resultadoEsperado)

    }

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