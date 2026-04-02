package com.example.progressa.network

import com.example.progressa.model.LoginRequest
import com.example.progressa.model.LoginResponse

class FakeApiService {

    fun login(request: LoginRequest): LoginResponse {

        // LOGIN FAKE
        val emailCorreto = "admin@progressa.com"
        val senhaCorreta = "123456"

        return if (request.email == emailCorreto && request.password == senhaCorreta) {
            LoginResponse(true, "Login realizado com sucesso")
        } else {
            LoginResponse(false, "Email ou senha inválidos")
        }
    }
}
