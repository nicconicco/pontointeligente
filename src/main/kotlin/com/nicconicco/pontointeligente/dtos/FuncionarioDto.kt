package com.nicconicco.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty


data class FuncionarioDto (

        @get:NotEmpty(message = "Nome nao pode vir vazio")
        @get:Length(min = 3, max = 200, message = "Nome deve ter minimo 3 letras e maximo 200 caracteres")
        val nome : String = "",

        @get:NotEmpty(message = "Email nao pode vir vazio")
        @get:Length(min = 3, max = 200, message = "Email deve ter minimo 3 letras e maximo 200 caracteres")
        @get:Email(message = "Email Invalido")
        val email : String = "",

        val senha : String? = null,
        val valorHora : String? = null,
        val qtdHorasTrabalhoDia : String? = null,
        val qtdHorasAlmoco : String? = null,
        val id : String? = null
)