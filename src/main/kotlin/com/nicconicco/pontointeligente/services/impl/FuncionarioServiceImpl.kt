package com.nicconicco.pontointeligente.services.impl

import com.nicconicco.pontointeligente.documents.Funcionario
import com.nicconicco.pontointeligente.repositories.FuncionarioRepository
import com.nicconicco.pontointeligente.services.FuncionarioService
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {
    override fun buscarPorId(id: String): Funcionario? = funcionarioRepository.findById(id).orElseThrow { RuntimeException() }
    override fun persistir(funcioario: Funcionario): Funcionario = funcionarioRepository.save(funcioario)
    override fun buscarPorEmail(email: String): Funcionario? = funcionarioRepository.findByEmail(email)
    override fun buscarPorCnpj(cnpj: String): Funcionario? = funcionarioRepository.findByCpf(cnpj)
}