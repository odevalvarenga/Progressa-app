package com.example.progressa

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textCadastro = findViewById<TextView>(R.id.textCadastro)

        val texto = "Ainda não tem uma conta? Crie agora"

        val spannable = SpannableString(texto)


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