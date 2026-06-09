package com.example.progressa

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class HidratacaoActivity : AppCompatActivity() {

    private var metaAgua = 0
    private var aguaBebida = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hidratacao)

        val txtAguaBebida = findViewById<TextView>(R.id.txtAguaBebida)
                val txtStatusAgua = findViewById<TextView>(R.id.txtStatusAgua)
                val progressBarAgua = findViewById<ProgressBar>(R.id.progressBarAgua)
                val editPeso = findViewById<EditText>(R.id.editPesoAtual)
                val btnMais = findViewById<LinearLayout>(R.id.btnMaisAgua)
                val btnMenos = findViewById<LinearLayout>(R.id.btnMenosAgua)
                val btnVoltar = findViewById<TextView>(R.id.btnVoltar)

                // Botão para fechar a tela e voltar
                btnVoltar.setOnClickListener {
            finish()
        }

        // 1. O CÁLCULO AUTOMÁTICO (Sem botão de calcular)
        editPeso.addTextChangedListener { textoDigitado ->
                val pesoTexto = textoDigitado.toString()

            if (pesoTexto.isNotEmpty()) {
                // Tenta converter para número (Double). Se não der, vira 0.0
                val peso = pesoTexto.toDoubleOrNull() ?: 0.0
                metaAgua = (peso * 35).toInt()

                progressBarAgua.max = metaAgua
                atualizarTela(txtAguaBebida, txtStatusAgua, progressBarAgua)
            } else {
                metaAgua = 0
                txtStatusAgua.text = "Defina seu peso abaixo para calcular a meta"
            }
        }

        // 2. Ação do Botão + 100 ml
        btnMais.setOnClickListener {
            if (metaAgua == 0) {
                Toast.makeText(this, "Digite seu peso primeiro!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            aguaBebida += 100
            atualizarTela(txtAguaBebida, txtStatusAgua, progressBarAgua)
        }

        // 3. Ação do Botão - 100 ml
        btnMenos.setOnClickListener {
            if (aguaBebida >= 100) {
                aguaBebida -= 100
                atualizarTela(txtAguaBebida, txtStatusAgua, progressBarAgua)
            }
        }
    }

    private fun atualizarTela(txtAgua: TextView, txtStatus: TextView, progressBar: ProgressBar) {
        txtAgua.text = "$aguaBebida ml"
        progressBar.progress = aguaBebida

        val faltaBeber = metaAgua - aguaBebida

        if (aguaBebida >= metaAgua && metaAgua > 0) {
            txtStatus.text = "Incrível! Meta diária atingida! 🎉"
            txtStatus.setTextColor(Color.parseColor("#4ADE80")) // Verde
            progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#4ADE80"))
        } else {
            txtStatus.text = "Faltam apenas $faltaBeber ml"
            txtStatus.setTextColor(Color.parseColor("#E0E0E0")) // Cinza claro
            progressBar.progressTintList = ColorStateList.valueOf(Color.parseColor("#8B5CF6")) // Roxo
        }
    }
}