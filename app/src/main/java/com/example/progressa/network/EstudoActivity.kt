package com.example.progressa.network

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.progressa.R
import kotlin.math.ceil

class EstudoActivity : AppCompatActivity() {

    private lateinit var txtCronometro: TextView

    private lateinit var txtHoje: TextView

    private lateinit var txtSemana: TextView

    private lateinit var txtSequencia: TextView

    private var segundos = 0

    private var rodando = false

    private val handler =
        Handler(
            Looper.getMainLooper()
        )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_estudo
        )

        txtCronometro =
            findViewById(
                R.id.txtCronometro
            )

        txtHoje =
            findViewById(
                R.id.txtHoje
            )

        txtSemana =
            findViewById(
                R.id.txtSemana
            )

        txtSequencia =
            findViewById(
                R.id.txtSequencia
            )

        val prefs =
            getSharedPreferences(
                "ESTUDO",
                MODE_PRIVATE
            )

        val minutosHoje =
            prefs.getInt(
                "MINUTOS_HOJE",
                0
            )

        val minutosSemana =
            prefs.getInt(
                "MINUTOS_SEMANA",
                0
            )

        val sequencia =
            prefs.getInt(
                "SEQUENCIA",
                0
            )

        txtHoje.text =
            "Hoje: $minutosHoje min"

        txtSemana.text =
            "Semana: $minutosSemana min"

        txtSequencia.text =
            "🔥 Sequência: $sequencia dias"

        val btnIniciar =
            findViewById<Button>(
                R.id.btnIniciar
            )

        val btnPausar =
            findViewById<Button>(
                R.id.btnPausar
            )

        val btnFinalizar =
            findViewById<Button>(
                R.id.btnFinalizar
            )

        btnIniciar.setOnClickListener {

            rodando = true
        }

        btnPausar.setOnClickListener {

            rodando = false
        }

        btnFinalizar.setOnClickListener {

            rodando = false

            val minutosSessao =
                ceil(
                    segundos / 60.0
                ).toInt()

            val hojeAtual =
                prefs.getInt(
                    "MINUTOS_HOJE",
                    0
                )

            val semanaAtual =
                prefs.getInt(
                    "MINUTOS_SEMANA",
                    0
                )

            val sequenciaAtual =
                prefs.getInt(
                    "SEQUENCIA",
                    0
                )

            prefs.edit()
                .putInt(
                    "MINUTOS_HOJE",
                    hojeAtual + minutosSessao
                )
                .putInt(
                    "MINUTOS_SEMANA",
                    semanaAtual + minutosSessao
                )
                .putInt(
                    "SEQUENCIA",
                    sequenciaAtual + 1
                )
                .apply()

            txtHoje.text =
                "Hoje: ${hojeAtual + minutosSessao} min"

            txtSemana.text =
                "Semana: ${semanaAtual + minutosSessao} min"

            txtSequencia.text =
                "🔥 Sequência: ${sequenciaAtual + 1} dias"

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

        val horas =
            segundos / 3600

        val minutos =
            (segundos % 3600) / 60

        val seg =
            segundos % 60

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

        handler.removeCallbacksAndMessages(
            null
        )
    }
}