package com.example.progressa.network

import com.example.progressa.model.LoginRequest
import com.example.progressa.model.LoginResponse
import com.example.progressa.model.RegisterRequest
import com.example.progressa.model.RegisterResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("auth.php")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("register.php")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>
}