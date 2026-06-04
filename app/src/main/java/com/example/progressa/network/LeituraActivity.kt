package com.example.progressa

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.adapter.LeituraAdapter
import com.example.progressa.model.Leitura

class LeituraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leitura)

        val recycler = findViewById<RecyclerView>(R.id.recyclerLeitura)

        recycler.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val lista = listOf(
            Leitura("Matemática", "João", "8.5", "7.9"),
            Leitura("História", "Maria", "9.0", "8.2"),
            Leitura("Geografia", "Carlos", "7.5", "7.0"),
            Leitura("Física", "Ana", "8.0", "7.5")
        )

        recycler.adapter = LeituraAdapter(lista)
    }
}