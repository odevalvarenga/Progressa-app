package com.example.progressa

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

import com.example.progressa.network.EstudoActivity
import com.example.progressa.network.LeituraActivity
import com.example.progressa.network.MateriaActivity
import com.example.progressa.network.DashboardActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        // LEITURA

        val cardLeitura =
            findViewById<LinearLayout>(
                R.id.cardLeitura
            )

        cardLeitura.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    LeituraActivity::class.java
                )
            )
        }

        // MATÉRIAS

        val cardMateria =
            findViewById<LinearLayout>(
                R.id.cardMateria
            )

        cardMateria.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MateriaActivity::class.java
                )
            )
        }

        // HIDRATAÇÃO

        val cardHidratacao =
            findViewById<LinearLayout>(
                R.id.cardHidratacao
            )

        cardHidratacao.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    HidratacaoActivity::class.java
                )
            )
        }

        // ESTUDOS

        val cardEstudar =
            findViewById<LinearLayout>(
                R.id.cardEstudar
            )

        cardEstudar.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    EstudoActivity::class.java
                )
            )
        }

        // BOLETIM

        val cardBoletim =
            findViewById<LinearLayout>(
                R.id.cardBoletim
            )

        cardBoletim.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    DashboardActivity::class.java
                )
            )
        }
    }
}