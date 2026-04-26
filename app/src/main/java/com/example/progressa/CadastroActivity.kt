package com.example.progressa

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    private lateinit var editNome: EditText
    private lateinit var editEmail: EditText
    private lateinit var editSenha: EditText
    private lateinit var btnCriarConta: Button
    private lateinit var btnLoginRedirect: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        // 1. Conectando o código ao XML
        editNome = findViewById(R.id.editNome)
        editEmail = findViewById(R.id.editEmail)
        editSenha = findViewById(R.id.editSenha)
        btnCriarConta = findViewById(R.id.btnCriarConta)
        btnLoginRedirect = findViewById(R.id.btnLoginRedirect)

        // 2. Ação do Botão de Criar Conta (ÁREA DO BACKEND)
        btnCriarConta.setOnClickListener {
            val nome = editNome.text.toString()
            val email = editEmail.text.toString()
            val senha = editSenha.text.toString()

            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: ESPAÇO LIVRE PARA A API DE CADASTRO
                // Aqui é onde o backend será plugado futuramente.
                Toast.makeText(this, "Preparado para o Backend!", Toast.LENGTH_SHORT).show()
            }
        }

        // 3. Voltar para a tela de Login
        btnLoginRedirect.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}