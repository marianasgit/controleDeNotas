package com.example.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private lateinit var nomeEditText: EditText
private lateinit var nota1EditText: EditText
private lateinit var nota2EditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)  //val calcular = findViewById (R.id.calcular) as Button
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener {
              //resgatando os valores inseridos pelo usuário
            val relatorio = findViewById<TextView>(R.id.relatorio)
            val situacao = findViewById<TextView>(R.id.situacao)

            nota1EditText = findViewById(R.id.nota1)
            nota2EditText = findViewById(R.id.nota2)
            nomeEditText = findViewById(R.id.nome)

            if (validarCampos()) {

                val nota1 = nota1EditText.text.toString().toInt()
                val nota2 = nota2EditText.text.toString().toInt()
                val nome = nomeEditText.text.toString()

                val media = calcularMedia(nota1, nota2)

                //relatorio.text = "Relatório final: \n Aluno: ${nome} \n Nota 1: ${nota1} \n Nota 2: ${nota2} \n Média: ${media} \n "

                relatorio.text = situacaoAluno(media)
            }

        }

        sair.setOnClickListener {
            finish()
        }
    }
//
//    fun situacaoAluno(media: Int): String {
//        if (media >=5) {
//            return "Aprovado"
//        } else {
//            return "Reprovado!"
//        }
//    }

//    private fun calcularMedia(nota1: Double, nota2: Double): Double {
//        return (nota1 + nota2) / 2
//    }
//                                                                                      fazendo a mesma funcao de maneiras diferentes
//   private fun calcularMedia(nota1: Double, nota2: Double) = (nota1 + nota2) / 2

//    val calcularMedia = { nota1: Double, nota2: Double -> (nota1 + nota2) / 2 }

//    fun calcularMedia (vararg notas:Int): Int{   //recebendo varios argumentos com vararg (comportamento de array, recebe varios argumentos)
//
//        var soma = 0
//
//        for (nota in notas) {
//            soma += nota
//        }
//
//        return soma / notas.size
//    }


    private fun validarCampos(): Boolean {
        var noError = true
        if (nomeEditText.text.isBlank()) {
            nomeEditText.setError("Digite seu nome!")
            noError = false
        }

        if (nota1EditText.text.isBlank()) {
            nota1EditText.setError("Preencha a primeira nota!")
            noError = false
        }

        if (nota2EditText.text.isBlank()) {
            nota2EditText.setError("Preencha a segunda nota!")
            noError = false
        }

        return noError
    }
}