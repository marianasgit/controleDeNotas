package com.example.controledenotas

fun situacaoAluno(media: Int): String {
    if (media >=5) {
        return "Aprovado"
    } else {
        return "Reprovado!"
    }
}

fun calcularMedia (vararg notas:Int): Int{   //recebendo varios argumentos com vararg (comportamento de array, recebe varios argumentos)

    var soma = 0

    for (nota in notas) {
        soma += nota
    }

    return soma / notas.size
}