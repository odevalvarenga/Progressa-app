package com.example.progressa.model

data class MateriaApiResponse(

    val id: Int,

    val nome: String,

    val professor: String,

    val nota1: Double,

    val nota2: Double,

    val trabalhos: Double,

    val media: Double,

    val cronograma: String

)