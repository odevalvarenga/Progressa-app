package com.example.progressa.model

data class Leitura(

    val livro:String,

    val autor:String,

    val inicio:String,

    val termino:String,

    val paginaAtual:String,

    val progresso:Int,

    val anotacao:String

)