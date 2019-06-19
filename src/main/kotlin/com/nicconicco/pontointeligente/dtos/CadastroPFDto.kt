package com.nicconicco.pontointeligente.dtos

import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.br.CNPJ
import org.hibernate.validator.constraints.br.CPF
import javax.validation.constraints.Email
import javax.validation.constraints.NotEmpty

data class CadastroPFDto (
        @get:NotEmpty(message = "Nome nao pode vir vazio")
        @get:Length(min = 3, max = 200, message = "Nome deve ter minimo 3 letras e maximo 200 caracteres")
        val nome : String = "",

        @get:NotEmpty(message = "Email nao pode vir vazio")
        @get:Length(min = 3, max = 200, message = "Email deve ter minimo 3 letras e maximo 200 caracteres")
        @get:Email(message = "Email Invalido")
        val email : String = "",

        @get:NotEmpty(message = "Senha nao pode vir vazio")
        val senha : String = "",

        @get:NotEmpty(message = "CPF nao pode vir vazio")
        @get:CPF(message = "CPF Invalido")
        val cpf : String = "",

        @get:NotEmpty(message = "CNPJ nao pode vir vazio")
        @get:CNPJ(message = "CNPJ Invalido")
        val cnpj : String = "",

        val empresa : String? = "",
        val valorHora : String? = "",
        val qtdHorasTrabalhoDia : String? = "",
        val qtdHorasAlmoco : String? = "",

        val id : String? = null
)