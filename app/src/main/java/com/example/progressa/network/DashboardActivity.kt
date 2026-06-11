package com.example.progressa.network

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.progressa.R
import com.example.progressa.util.DashboardManager

class DashboardActivity : AppCompatActivity() {

    private lateinit var txtLivros: TextView
    private lateinit var txtTempo: TextView
    private lateinit var txtAgua: TextView
    private lateinit var txtMedia: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_dashboard)

        findViewById<ImageButton>(R.id.btnVoltar)
            .setOnClickListener {
                finish()
            }

        txtLivros =
            findViewById(R.id.txtLivros)

        txtTempo =
            findViewById(R.id.txtTempo)

        txtAgua =
            findViewById(R.id.txtAgua)

        txtMedia =
            findViewById(R.id.txtMedia)

        carregarDashboard()
    }

    override fun onResume() {
        super.onResume()

        carregarDashboard()
    }

    private fun carregarDashboard() {

        val livros =
            DashboardManager.getLivros(this)

        val totalSegundos =
            DashboardManager.getTempo(this)

        val agua =
            DashboardManager.getAgua(this)

        val media =
            DashboardManager.getMedia(this)

        val horas =
            totalSegundos / 3600

        val minutos =
            (totalSegundos % 3600) / 60

        val segundos =
            totalSegundos % 60

        txtLivros.text =
            livros.toString()

        txtTempo.text =
            String.format(
                "%02d:%02d:%02d",
                horas,
                minutos,
                segundos
            )

        txtAgua.text =
            "$agua ml"

        txtMedia.text =
            String.format(
                "%.1f",
                media
            )
    }
}