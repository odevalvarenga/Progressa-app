package com.example.progressa

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.example.progressa.model.LoginRequest
import com.example.progressa.network.RetrofitClient

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textCadastro = findViewById<TextView>(R.id.textCadastro)

        val texto = "Ainda não tem uma conta? Crie agora"

        val spannable = SpannableString(texto)

        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            val request = LoginRequest(email, senha)

            val response = RetrofitClient.instance.login(request)

            if (response.success) {
                Toast.makeText(this, "Login OK!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Email ou senha inválidos", Toast.LENGTH_SHORT).show()
            }
        }

        val inicio = texto.indexOf("Crie agora")

        spannable.setSpan(
            ForegroundColorSpan(Color.parseColor("#4E61F6")),
            inicio,
            inicio + "Crie agora".length,
            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        textCadastro.text = spannable
    }
}