package com.nicconicco.pontointeligente.services
import com.nicconicco.pontointeligente.services.*
import com.nicconicco.pontointeligente.documents.*
import com.nicconicco.pontointeligente.repositories.*

interface FuncionarioService {

    fun persistir(funcionario: Funcionario): Funcionario

    fun buscarPorCpf(cpf: String): Funcionario?

    fun buscarPorEmail(email: String): Funcionario?

    fun buscarPorId(id: String): Funcionario?

}
