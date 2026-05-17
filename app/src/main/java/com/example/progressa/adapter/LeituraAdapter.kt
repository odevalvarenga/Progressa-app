package com.example.progressa.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.progressa.R
import com.example.progressa.model.Leitura
class LeituraAdapter(
    private val lista: List<Leitura>
) : RecyclerView.Adapter<LeituraAdapter.LeituraViewHolder>() {

    class LeituraViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        val livro=itemView.findViewById<TextView>(R.id.txtLivro)

        val autor=itemView.findViewById<TextView>(R.id.txtAutor)

        val previsao=itemView.findViewById<TextView>(R.id.txtPrevisao)

        val pagina=itemView.findViewById<TextView>(R.id.txtPagina)

        val anotacao=itemView.findViewById<TextView>(R.id.txtAnotacao)

        val progresso=itemView.findViewById<ProgressBar>(
            R.id.progressLeitura
        )

    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType:Int
    ):LeituraViewHolder {

        val view=LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_leitura,
                parent,
                false
            )

        return LeituraViewHolder(view)
    }

    override fun getItemCount()=lista.size


    override fun onBindViewHolder(
        holder:LeituraViewHolder,
        position:Int
    ){

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
    }

}