package org.alugames.br.com.alura.alugames.model

data class InfoJogo(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}