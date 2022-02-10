package com.example.controledenotas

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)  //val calcular = findViewById (R.id.calcular) as Button
        val sair = findViewById<Button>(R.id.sair)

        calcular.setOnClickListener {
            val nota1 = findViewById<EditText>(R.id.nota1).text.toString().toInt()  //resgatando os valores inseridos pelo usuário
            val nota2 = findViewById<EditText>(R.id.nota2).text.toString().toInt()
            val faltas = findViewById<EditText>(R.id.faltas).text.toString().toInt()
            val relatorio = findViewById<TextView>(R.id.relatorio)
            val situacao = findViewById<TextView>(R.id.situacao)

            val media = (nota1 + nota2) / 2

            relatorio.text = "Relatório final: \n Nota 1: ${nota1} \n Nota 2: ${nota2} \n Faltas: ${faltas} \n Média: ${media} \n "

            if (media >=5) {
                situacao.text = "Aprovado!"
                situacao.setTextColor(Color.GREEN)
            } else {
                situacao.text = "Reprovado!"
                situacao.setTextColor(Color.RED)
            }


        }

        sair.setOnClickListener {
            finish()
        }
    }
}