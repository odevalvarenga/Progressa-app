package com.example.progressa.network

import com.example.progressa.model.LoginRequest
import com.example.progressa.model.LoginResponse
import com.example.progressa.model.RegisterRequest
import com.example.progressa.model.RegisterResponse
import com.example.progressa.model.MateriaRequest
import com.example.progressa.model.MateriaResponse
import com.example.progressa.model.MateriaApiResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    // LOGIN
    @POST("auth.php")
    fun login(
        @Body request: LoginRequest
    ): Call<LoginResponse>

    // CADASTRO USUÁRIO
    @POST("register.php")
    fun register(
        @Body request: RegisterRequest
    ): Call<RegisterResponse>

    // CADASTRO MATÉRIA
    @POST("materia_create.php")
    fun criarMateria(
        @Body request: MateriaRequest
    ): Call<MateriaResponse>

    // LISTAR MATÉRIAS
    @GET("materia_list.php")
    fun listarMaterias():
            Call<List<MateriaApiResponse>>
}