package br.com.alura.alugames.main

import br.com.alura.alugames.model.Gamer

fun main() {
    val gamer1 = Gamer("Mateus", "mateus@email.com")
    gamer1.let {
        it.dataNascimento = "18/09/2000"
        it.usuario = "WretchedEgg"
    }
    println(gamer1)

    val gamer2 = Gamer("pedro", "pedro@email.com","19/19/1992","Baphom3t")
    println(gamer2)

    val gamer3 = Gamer("Jacque", "jacque@email.com")
    println(gamer3)
}

