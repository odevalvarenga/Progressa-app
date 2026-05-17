package com.example.progressa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.model.Leitura
import android.app.AlertDialog
import android.widget.EditText
import android.text.InputFilter

class LeituraAdapter(
    private val lista: MutableList<Leitura>
) : RecyclerView.Adapter<LeituraAdapter.LeituraViewHolder>() {

    class LeituraViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {

        val livro =
            itemView.findViewById<TextView>(
                R.id.txtLivro
            )

        val autor =
            itemView.findViewById<TextView>(
                R.id.txtAutor
            )

        val previsao =
            itemView.findViewById<TextView>(
                R.id.txtPrevisao
            )

        val pagina =
            itemView.findViewById<TextView>(
                R.id.txtPagina
            )

        val anotacao =
            itemView.findViewById<TextView>(
                R.id.txtAnotacao
            )

        val progresso =
            itemView.findViewById<ProgressBar>(
                R.id.progressLeitura
            )

        val editar =
            itemView.findViewById<Button>(
                R.id.btnEditar
            )

        val excluir =
            itemView.findViewById<Button>(
                R.id.btnExcluir
            )

        val finalizar =
            itemView.findViewById<Button>(
                R.id.btnFinalizado
            )
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeituraViewHolder {

        val view =
            LayoutInflater.from(
                parent.context
            ).inflate(
                R.layout.item_leitura,
                parent,
                false
            )

        return LeituraViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(
        holder: LeituraViewHolder,
        position: Int
    ) {

        val item = lista[position]

        holder.livro.text =
            "📚 ${item.livro}"

        holder.autor.text =
            "👤 ${item.autor}"

        holder.previsao.text =
            "📅 ${item.inicio} → ${item.termino}"

        holder.pagina.text =
            "📖 ${item.paginaAtual}"

        holder.anotacao.text =
            "📝 ${item.anotacao}"

        holder.progresso.progress =
            item.progresso


        // EDITAR
        holder.editar.setOnClickListener {

            val campo =
                EditText(holder.itemView.context)

            campo.hint =
                "Digite sua anotação (máx. 450)"

            campo.setText(
                item.anotacao
            )

            campo.setTextColor(
                android.graphics.Color.WHITE
            )

            campo.setHintTextColor(
                android.graphics.Color.LTGRAY
            )

            campo.setBackgroundColor(
                android.graphics.Color.parseColor("#33224F")
            )

            campo.setPadding(
                40,
                40,
                40,
                40
            )

            campo.minLines = 6
            campo.maxLines = 8

            campo.filters =
                arrayOf(
                    android.text.InputFilter.LengthFilter(450)
                )

            AlertDialog.Builder(
                holder.itemView.context,
                android.R.style.Theme_DeviceDefault_Dialog
            )
                .setTitle(
                    "Editar anotação"
                )

                .setView(
                    campo
                )

                .setPositiveButton(
                    "Salvar"
                ){ _,_ ->

                    item.anotacao =
                        campo.text.toString()

                    notifyItemChanged(
                        holder.adapterPosition
                    )
                }

                .setNegativeButton(
                    "Cancelar",
                    null
                )

                .show()
        }


        // EXCLUIR
        holder.excluir.setOnClickListener {

            val pos =
                holder.adapterPosition

            if(pos != RecyclerView.NO_POSITION){

                lista.removeAt(pos)

                notifyItemRemoved(pos)

            }
        }

        // FINALIZAR
        holder.finalizar.setOnClickListener {

            item.progresso = 100

            holder.finalizar.text =
                "Concluído ✅"

            notifyItemChanged(
                holder.adapterPosition
            )
        }
    }
}