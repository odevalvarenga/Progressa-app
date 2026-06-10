package com.example.progressa.network

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.progressa.R
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import kotlin.math.ceil

class EstudoActivity : AppCompatActivity() {

    private lateinit var txtCronometro: TextView
    private lateinit var txtHoje: TextView
    private lateinit var txtSequencia: TextView

    private var segundos = 0
    private var rodando = false

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_estudo)

        findViewById<ImageButton>(R.id.btnVoltar).setOnClickListener {
            finish()
        }

        txtCronometro = findViewById(R.id.txtCronometro)
        txtHoje = findViewById(R.id.txtHoje)
        txtSequencia = findViewById(R.id.txtSequencia)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnPausar = findViewById<Button>(R.id.btnPausar)
        val btnFinalizar = findViewById<Button>(R.id.btnFinalizar)

        val prefs = getSharedPreferences("ESTUDO", MODE_PRIVATE)

        val minutosHoje = prefs.getInt("MINUTOS_HOJE", 0)

        val diasEstudados =
            prefs.getStringSet(
                "DIAS_ESTUDADOS",
                mutableSetOf()
            ) ?: mutableSetOf()

        txtHoje.text =
            "Hoje: $minutosHoje min"

        txtSequencia.text =
            "🔥 ${diasEstudados.size} dias estudados esta semana"

        btnIniciar.setOnClickListener {
            rodando = true
        }

        btnPausar.setOnClickListener {
            rodando = false
        }

        btnFinalizar.setOnClickListener {

            rodando = false

            val minutosSessao =
                ceil(segundos / 60.0).toInt()

            val hojeAtual =
                prefs.getInt(
                    "MINUTOS_HOJE",
                    0
                )

            val diasAtualizados =
                diasEstudados.toMutableSet()

            val formato =
                SimpleDateFormat(
                    "yyyyMMdd",
                    Locale.getDefault()
                )

            val hoje =
                formato.format(
                    Calendar.getInstance().time
                )

            diasAtualizados.add(hoje)

            prefs.edit()
                .putInt(
                    "MINUTOS_HOJE",
                    hojeAtual + minutosSessao
                )
                .putStringSet(
                    "DIAS_ESTUDADOS",
                    diasAtualizados
                )
                .apply()

            txtHoje.text =
                "Hoje: ${hojeAtual + minutosSessao} min"

            txtSequencia.text =
                "🔥 ${diasAtualizados.size} dias estudados esta semana"

            segundos = 0

            atualizarCronometro()
        }

        iniciarCronometro()
    }

    private fun iniciarCronometro() {

        handler.post(
            object : Runnable {

                override fun run() {

                    if (rodando) {
                        segundos++
                    }

                    atualizarCronometro()

                    handler.postDelayed(
                        this,
                        1000
                    )
                }
            }
        )
    }

    private fun atualizarCronometro() {

        val horas = segundos / 3600
        val minutos = (segundos % 3600) / 60
        val seg = segundos % 60

        txtCronometro.text =
            String.format(
                "%02d:%02d:%02d",
                horas,
                minutos,
                seg
            )
    }

    override fun onDestroy() {
        super.onDestroy()

        handler.removeCallbacksAndMessages(null)
    }
}