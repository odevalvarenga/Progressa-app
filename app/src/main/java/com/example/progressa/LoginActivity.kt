package com.example.progressa

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

import com.example.progressa.model.LoginRequest
import com.example.progressa.model.LoginResponse
import com.example.progressa.network.RetrofitClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textCadastro = findViewById<TextView>(R.id.textCadastro)
        val editEmail = findViewById<EditText>(R.id.editEmail)
        val editSenha = findViewById<EditText>(R.id.editSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val texto = "Ainda não tem uma conta? Crie agora"
        val spannable = SpannableString(texto)

        // 👉 Clique para ir para cadastro
        textCadastro.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        // 👉 Clique no botão login
        btnLogin.setOnClickListener {

            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            if (email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val request = LoginRequest(email, senha)
            val call = RetrofitClient.instance.login(request)

            call.enqueue(object : Callback<LoginResponse> {

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {

                        val body = response.body()

                        if (body?.success == true) {

                            Toast.makeText(this@LoginActivity, "Login OK!", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                            intent.putExtra("nome", "Usuário") // depois melhoramos isso
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this@LoginActivity, body?.message ?: "Erro", Toast.LENGTH_SHORT).show()
                        }

                    } else {
                        Toast.makeText(this@LoginActivity, "Erro na resposta", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Erro de conexão: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }

        // 👉 Estilo do texto "Crie agora"
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