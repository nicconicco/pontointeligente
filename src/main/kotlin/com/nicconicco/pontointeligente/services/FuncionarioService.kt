package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.documents.Funcionario

interface FuncionarioService {

    fun buscarPorCnpj(cnpj: String) : Funcionario?

    fun buscarPorEmail(email: String) : Funcionario?

    fun persistir(funcioario: Funcionario) : Funcionario

    fun buscarPorId(id: String) : Funcionario?
}