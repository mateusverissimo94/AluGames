package org.alugames.br.com.alura.alugames.service

import br.com.alura.alugames.model.Gamer
import br.com.alura.alugames.model.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.alugames.br.com.alura.alugames.model.InfoApiShark
import org.alugames.br.com.alura.alugames.model.InfoJogo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    fun buscaJogo(id: String): InfoJogo {
        val endereco = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()
        if (json.trim() == "[]") {
            val jogoVazio: InfoJogo = (InfoJogo(InfoApiShark("", "")))
            return jogoVazio
        }

        val gson = Gson()
        var meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)

        return meuInfoJogo
    }

    fun buscaGamers(): List<Gamer> {
        val endereco = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        var listarGamer: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamerConvertida = listarGamer.map { infoGamerJson ->
            Gamer(
                infoGamerJson.nome,
                infoGamerJson.email,
                infoGamerJson.dataNascimento,
                infoGamerJson.usuario
            )
        }

        return listaGamerConvertida
    }

}