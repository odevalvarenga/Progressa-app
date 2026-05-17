package com.example.progressa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.LinearLayout

import com.example.progressa.network.LeituraActivity
import com.example.progressa.network.MateriaActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_home
        )

        val cardLeitura =
            findViewById<LinearLayout>(
                R.id.cardLeitura
            )

        cardLeitura.setOnClickListener {

            val intent =
                Intent(
                    this,
                    LeituraActivity::class.java
                )

            startActivity(intent)
        }


        val cardMateria =
            findViewById<LinearLayout>(
                R.id.cardMateria
            )

        cardMateria.setOnClickListener {

            val intent =
                Intent(
                    this,
                    MateriaActivity::class.java
                )

            startActivity(intent)
        }
    }
}