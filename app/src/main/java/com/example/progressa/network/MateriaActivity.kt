package com.example.progressa.network

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.adapter.MateriaAdapter
import com.example.progressa.model.Materia
import com.example.progressa.util.DashboardManager

class MateriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_materias
        )

        val voltar =
            findViewById<ImageButton>(
                R.id.btnVoltar
            )

        voltar.setOnClickListener {
            finish()
        }

        val recycler =
            findViewById<RecyclerView>(
                R.id.recyclerMateria
            )

        val lista = mutableListOf(

            Materia(
                id = 1,
                nome = "Kotlin/Mobile",
                professor = "Marcelo Andrade",
                nota1 = 9.5,
                nota2 = 6.5,
                trabalhos = 10.0,
                media = (9.5 + 6.5 + 10.0) / 3,
                cronograma =
                    """
                Prova N1: 21/03/2030

                Prova N2: 04/05/2030

                Entrega trabalho:
                22/05/2030
                """.trimIndent()
            ),

            Materia(
                id = 2,
                nome = "Banco de Dados",
                professor = "Carlos Silva",
                nota1 = 8.0,
                nota2 = 10.0,
                trabalhos = 9.0,
                media = (8.0 + 10.0 + 9.0) / 3,
                cronograma =
                    """
                Projeto: 25/04

                Apresentação:
                01/05
                """.trimIndent()
            )
        )

        // MÉDIA PARA DASHBOARD

        val mediaGeral =
            lista
                .map { it.media }
                .average()
                .toFloat()

        DashboardManager.salvarMedia(
            this,
            mediaGeral
        )

        recycler.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        recycler.setHasFixedSize(true)

        recycler.adapter =
            MateriaAdapter(lista)

        // ABRIR TELA NOVA MATÉRIA

        findViewById<Button>(
            R.id.btnNovaMateria
        ).setOnClickListener {

            val intent =
                Intent(
                    this,
                    NovaMateriaActivity::class.java
                )

            startActivity(intent)
        }
    }
}