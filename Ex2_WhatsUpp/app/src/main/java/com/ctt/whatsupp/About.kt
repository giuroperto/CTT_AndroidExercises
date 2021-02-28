package com.ctt.whatsupp

//Recycler View
// conseguimos fazer qualquer tipo de lista, com texto, imagens, etc
// forma mais atual de mexer com listas componetizadas
// lista -> algo que segue um padrao mas muda o conteudo

// tudo que eh lista em android eh recycler view
// recicla -> reutiliza a estrutura
// nao carrega todos os itens de uma vez -> vai carregando aos poucos -> otimiza o processamento
// quem organiza eh o sistema operacional
// muito mais rapido!

// recycler view exige um layout manager que vai informar como a lista sera exibida
// layout se comunicara com o adapter -> comunica o xml com o dataset -> construimos do zero
// que se comunicara com o data set (os dados em si, ex, mutable list de filmes)

//build graddle do projeto -> infos de compilacao do projeto como um all
//tudo que quiser saber de dependencia e que vai ser utilizado no app -> build graddle do modulo

//sempre que for adicionar algo de fora -> dependencia externa -> implementation no build graddle

// listas para mobile sao listas de componentes

// se a estrutura nao muda, esta correto a recycler view -> so o que altera sao os dados