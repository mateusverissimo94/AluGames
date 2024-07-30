package br.com.alura.alugames.main

import org.alugames.br.com.alura.alugames.service.ConsumoApi

fun main() {
    val consumo = ConsumoApi()
    val listaGamers = consumo.buscaGamers()

    println(listaGamers)
}