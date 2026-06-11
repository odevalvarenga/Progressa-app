package com.example.progressa.network

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.progressa.R
import com.example.progressa.model.MateriaRequest
import com.example.progressa.model.MateriaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NovaMateriaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_nova_materia)

        val nome =
            findViewById<EditText>(R.id.editNomeMateria)

        val professor =
            findViewById<EditText>(R.id.editProfessor)

        val nota1 =
            findViewById<EditText>(R.id.editNota1)

        val nota2 =
            findViewById<EditText>(R.id.editNota2)

        val trabalhos =
            findViewById<EditText>(R.id.editTrabalhos)

        val cronograma =
            findViewById<EditText>(R.id.editCronograma)

        val btnSalvar =
            findViewById<Button>(R.id.btnSalvarMateria)

        btnSalvar.setOnClickListener {

            val request =
                MateriaRequest(
                    nome.text.toString(),
                    professor.text.toString(),
                    nota1.text.toString().toDoubleOrNull() ?: 0.0,
                    nota2.text.toString().toDoubleOrNull() ?: 0.0,
                    trabalhos.text.toString().toDoubleOrNull() ?: 0.0,
                    cronograma.text.toString()
                )

            RetrofitClient.instance
                .criarMateria(request)
                .enqueue(object :
                    Callback<MateriaResponse> {

                    override fun onResponse(
                        call: Call<MateriaResponse>,
                        response: Response<MateriaResponse>
                    ) {

                        if (
                            response.isSuccessful &&
                            response.body()?.success == true
                        ) {

                            Toast.makeText(
                                this@NovaMateriaActivity,
                                "Matéria cadastrada!",
                                Toast.LENGTH_LONG
                            ).show()

                            finish()

                        } else {

                            Toast.makeText(
                                this@NovaMateriaActivity,
                                "Erro ao cadastrar",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }

                    override fun onFailure(
                        call: Call<MateriaResponse>,
                        t: Throwable
                    ) {

                        Toast.makeText(
                            this@NovaMateriaActivity,
                            t.message,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                })
        }
    }
}