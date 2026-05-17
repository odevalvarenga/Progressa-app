package com.example.progressa.model

data class Leitura(

    val id:Int,

    val livro:String,

    val autor:String,

    val inicio:String,

    val termino:String,

    val paginaAtual:String,

    var progresso:Int,

    var anotacao:String
)