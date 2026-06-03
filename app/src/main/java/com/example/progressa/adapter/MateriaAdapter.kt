package com.example.progressa.adapter

import android.app.AlertDialog
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.model.Materia

class MateriaAdapter(
    private val lista: MutableList<Materia>
) : RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder>() {

    class MateriaViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val nome: TextView =
            itemView.findViewById(R.id.txtNome)

        val professor: TextView =
            itemView.findViewById(R.id.txtProfessor)

        val notas: TextView =
            itemView.findViewById(R.id.txtNotas)

        val trabalhos: TextView =
            itemView.findViewById(R.id.txtTrabalhos)

        val media: TextView =
            itemView.findViewById(R.id.txtMedia)

        val cronograma: TextView =
            itemView.findViewById(R.id.txtCronograma)

        val editar: Button =
            itemView.findViewById(R.id.btnEditar)

        val excluir: Button =
            itemView.findViewById(R.id.btnExcluir)
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
            "📝 N1: ${item.nota1} | N2: ${item.nota2}"

        holder.trabalhos.text =
            "📌 Trabalhos: ${item.trabalhos}"

        holder.media.text =
            "📊 Média: %.2f".format(item.media)

        holder.cronograma.text =
            item.cronograma

        // ==========================
        // EDITAR
        // ==========================

        holder.editar.setOnClickListener {

            val contexto =
                holder.itemView.context

            val layout =
                LinearLayout(contexto).apply {

                    orientation =
                        LinearLayout.VERTICAL

                    setPadding(
                        40,
                        30,
                        40,
                        10
                    )
                }

            val campoNome =
                EditText(contexto).apply {

                    hint =
                        "Nome da matéria"

                    setText(item.nome)
                }

            val campoProfessor =
                EditText(contexto).apply {

                    hint =
                        "Professor"

                    setText(item.professor)
                }

            val campoN1 =
                EditText(contexto).apply {

                    hint =
                        "Nota N1"

                    inputType =
                        InputType.TYPE_CLASS_NUMBER or
                                InputType.TYPE_NUMBER_FLAG_DECIMAL

                    setText(
                        item.nota1.toString()
                    )
                }

            val campoN2 =
                EditText(contexto).apply {

                    hint =
                        "Nota N2"

                    inputType =
                        InputType.TYPE_CLASS_NUMBER or
                                InputType.TYPE_NUMBER_FLAG_DECIMAL

                    setText(
                        item.nota2.toString()
                    )
                }

            val campoTrabalhos =
                EditText(contexto).apply {

                    hint =
                        "Nota dos Trabalhos"

                    inputType =
                        InputType.TYPE_CLASS_NUMBER or
                                InputType.TYPE_NUMBER_FLAG_DECIMAL

                    setText(
                        item.trabalhos.toString()
                    )
                }

            val txtMedia =
                TextView(contexto).apply {

                    text =
                        "Média Atual: %.2f"
                            .format(item.media)

                    textSize = 18f
                }

            layout.addView(
                TextView(contexto).apply {
                    text = "Nome da Matéria"
                }
            )

            layout.addView(campoNome)

            layout.addView(
                TextView(contexto).apply {
                    text = "Professor"
                }
            )

            layout.addView(campoProfessor)

            layout.addView(
                TextView(contexto).apply {
                    text = "Nota N1"
                }
            )

            layout.addView(campoN1)

            layout.addView(
                TextView(contexto).apply {
                    text = "Nota N2"
                }
            )

            layout.addView(campoN2)

            layout.addView(
                TextView(contexto).apply {
                    text = "Trabalhos"
                }
            )

            layout.addView(campoTrabalhos)

            layout.addView(txtMedia)

            AlertDialog.Builder(contexto)
                .setTitle("Editar Matéria")
                .setView(layout)

                .setPositiveButton(
                    "Salvar"
                ) { _, _ ->

                    item.nome =
                        campoNome.text.toString()

                    item.professor =
                        campoProfessor.text.toString()

                    item.nota1 =
                        campoN1.text.toString()
                            .toDoubleOrNull()
                            ?: 0.0

                    item.nota2 =
                        campoN2.text.toString()
                            .toDoubleOrNull()
                            ?: 0.0

                    item.trabalhos =
                        campoTrabalhos.text.toString()
                            .toDoubleOrNull()
                            ?: 0.0

                    item.media =
                        (
                                item.nota1 +
                                        item.nota2 +
                                        item.trabalhos
                                ) / 3

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

        // ==========================
        // EXCLUIR
        // ==========================

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