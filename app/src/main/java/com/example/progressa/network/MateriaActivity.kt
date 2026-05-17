package com.example.progressa.network

import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.adapter.MateriaAdapter
import com.example.progressa.model.Materia

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

        voltar.setOnClickListener{
            finish()
        }


        val recycler =
            findViewById<RecyclerView>(
                R.id.recyclerMateria
            )


        val lista = mutableListOf(

            Materia(
                id=1,
                nome="Kotlin/Mobile",
                professor="Marcelo Andrade",
                n1="9,5",
                n2="6,5",
                trabalhos="10",
                media="8,5",

                cronograma=
                    """
                Prova N1: 21/03/2030
                
                Prova N2: 04/05/2030
                
                Entrega trabalho:
                22/05/2030
                """.trimIndent()
            ),

            Materia(
                id=2,
                nome="Banco de Dados",
                professor="Carlos Silva",
                n1="8",
                n2="10",
                trabalhos="9",
                media="9",

                cronograma=
                    """
                Projeto: 25/04
                
                Apresentação:
                01/05
                """.trimIndent()
            )

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


        findViewById<android.widget.Button>(
            R.id.btnNovaMateria
        )
            .setOnClickListener{

                Toast.makeText(
                    this,
                    "Adicionar matéria",
                    Toast.LENGTH_SHORT
                ).show()

            }

    }
}