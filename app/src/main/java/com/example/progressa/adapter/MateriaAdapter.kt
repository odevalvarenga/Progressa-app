package com.example.progressa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.model.Materia

class MateriaAdapter(
    private val lista: MutableList<Materia>
) : RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder>() {

    class MateriaViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView){

        val nome =
            itemView.findViewById<TextView>(
                R.id.txtNome
            )

        val professor =
            itemView.findViewById<TextView>(
                R.id.txtProfessor
            )

        val notas =
            itemView.findViewById<TextView>(
                R.id.txtNotas
            )

        val trabalhos =
            itemView.findViewById<TextView>(
                R.id.txtTrabalhos
            )

        val media =
            itemView.findViewById<TextView>(
                R.id.txtMedia
            )

        val cronograma =
            itemView.findViewById<TextView>(
                R.id.txtCronograma
            )

        val editar =
            itemView.findViewById<Button>(
                R.id.btnEditar
            )

        val excluir =
            itemView.findViewById<Button>(
                R.id.btnExcluir
            )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MateriaViewHolder {

        val view =
            LayoutInflater
                .from(parent.context)
                .inflate(
                    R.layout.item_materia,
                    parent,
                    false
                )

        return MateriaViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(
        holder: MateriaViewHolder,
        position: Int
    ) {

        val item = lista[position]

        holder.nome.text =
            "📚 ${item.nome}"

        holder.professor.text =
            "👨‍🏫 ${item.professor}"

        holder.notas.text =
            "📝 N1:${item.n1} | N2:${item.n2}"

        holder.trabalhos.text =
            "📌 ${item.trabalhos}"

        holder.media.text =
            "📊 Média: ${item.media}"

        holder.cronograma.text =
            item.cronograma


        holder.excluir.setOnClickListener {

            lista.removeAt(position)

            notifyItemRemoved(position)

            notifyItemRangeChanged(
                position,
                lista.size
            )
        }
    }
}