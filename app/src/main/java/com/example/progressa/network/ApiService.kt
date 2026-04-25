package com.example.progressa.network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import com.example.progressa.model.LoginRequest
import com.example.progressa.model.LoginResponse

interface ApiService {

    @POST("auth.php")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}