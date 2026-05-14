package com.example.progressa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.example.progressa.model.RegisterRequest
import com.example.progressa.model.RegisterResponse
import com.example.progressa.network.RetrofitClient

class CadastroActivity : AppCompatActivity() {

    private lateinit var editNome: EditText
    private lateinit var editEmail: EditText
    private lateinit var editSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var btnLoginRedirect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        editNome = findViewById(R.id.editNome)
        editEmail = findViewById(R.id.editEmail)
        editSenha = findViewById(R.id.editSenha)
        btnCriarConta = findViewById(R.id.btnCriarConta)
        btnLoginRedirect = findViewById(R.id.btnLoginRedirect)

        btnCriarConta.setOnClickListener {

            val nome = editNome.text.toString()
            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val request = RegisterRequest(nome, email, senha)

            val call = RetrofitClient.instance.register(request)

            call.enqueue(object : Callback<RegisterResponse> {

                override fun onResponse(
                    call: Call<RegisterResponse>,
                    response: Response<RegisterResponse>
                ) {
                    if (response.isSuccessful) {
                        val body = response.body()

                        if (body?.success == true) {
                            Toast.makeText(this@CadastroActivity, "Cadastro OK!", Toast.LENGTH_SHORT).show()

                            val intent = Intent(this@CadastroActivity, LoginActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this@CadastroActivity, body?.message ?: "Erro", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(this@CadastroActivity, "Erro na resposta", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                    Toast.makeText(this@CadastroActivity, "Erro: ${t.message}", Toast.LENGTH_LONG).show()
                }
            })
        }

        btnLoginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}