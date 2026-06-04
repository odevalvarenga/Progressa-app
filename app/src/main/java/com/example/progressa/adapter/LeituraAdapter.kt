package com.example.progressa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.model.Leitura

class LeituraAdapter(
    private val lista: List<Leitura>
) : RecyclerView.Adapter<LeituraAdapter.LeituraViewHolder>() {

    class LeituraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val materia: TextView = itemView.findViewById(R.id.txtMateria)
        val professor: TextView = itemView.findViewById(R.id.txtProfessor)
        val nota: TextView = itemView.findViewById(R.id.txtNota)
        val media: TextView = itemView.findViewById(R.id.txtMedia)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeituraViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_leitura, parent, false)
        return LeituraViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeituraViewHolder, position: Int) {
        val item = lista[position]

        holder.materia.text = item.nomeMateria
        holder.professor.text = "Professor: ${item.professor}"
        holder.nota.text = "Nota: ${item.nota}"
        holder.media.text = "Média: ${item.media}"
    }

    override fun getItemCount() = lista.size
}