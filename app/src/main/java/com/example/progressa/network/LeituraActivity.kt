package com.example.progressa.network

import android.os.Bundle
import android.widget.ImageButton
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

        val voltar =
            findViewById<ImageButton>(
                R.id.btnVoltar
            )

        voltar.setOnClickListener {
            finish()
        }

        val recycler =
            findViewById<RecyclerView>(
                R.id.recyclerLeitura
            )

        val lista = listOf(

            Leitura(
                livro="Dom Casmurro",
                autor="Machado de Assis",
                inicio="01/05/2026",
                termino="29/12/2025",
                paginaAtual="35/208",
                progresso=25,
                anotacao="Capítulo interessante"
            ),

            Leitura(
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

        recycler.adapter =
            LeituraAdapter(lista)
    }
}