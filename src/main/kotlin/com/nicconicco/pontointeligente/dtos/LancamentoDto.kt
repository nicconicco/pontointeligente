package com.nicconicco.pontointeligente.dtos

import javax.validation.constraints.NotEmpty

data class LancamentoDto(
        @get:NotEmpty(message = "Data nao pode vir vazio")
        val data : String = "",

        @get:NotEmpty(message = "Tipo nao pode vir vazio")
        val tipo : String = "",

        val funcionarioId: String? = null,
        val descricao:  String? = null,
        val localizacao:  String? = null
)