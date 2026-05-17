package com.example.progressa.network

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.adapter.LeituraAdapter
import com.example.progressa.model.Leitura

class LeituraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(
            R.layout.activity_leitura
        )

        // voltar
        val voltar =
            findViewById<ImageButton>(
                R.id.btnVoltar
            )

        voltar.setOnClickListener {
            finish()
        }


        // novo livro
        val novoLivro =
            findViewById<Button>(
                R.id.btnNovoLivro
            )

        novoLivro.setOnClickListener {

            Toast.makeText(
                this,
                "Tela de adicionar livro",
                Toast.LENGTH_SHORT
            ).show()

        }


        // recycler
        val recycler =
            findViewById<RecyclerView>(
                R.id.recyclerLeitura
            )


        val lista = mutableListOf(

            Leitura(
                id=1,
                livro="Dom Casmurro",
                autor="Machado de Assis",
                inicio="01/05/2026",
                termino="29/12/2025",
                paginaAtual="35/208",
                progresso=25,
                anotacao="Capítulo interessante"
            ),

            Leitura(
                id=2,
                livro="1984",
                autor="George Orwell",
                inicio="03/05/2026",
                termino="20/01/2026",
                paginaAtual="80/240",
                progresso=40,
                anotacao="Mundo distópico"
            )

        )

        recycler.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.HORIZONTAL,
                false
            )

        recycler.setHasFixedSize(true)

        recycler.setPadding(
            0,
            0,
            0,
            0
        )

        recycler.clipToPadding = true

        recycler.adapter =
            LeituraAdapter(lista)

    }
}