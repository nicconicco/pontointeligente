package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.documents.Funcionario
import com.nicconicco.pontointeligente.documents.Lancamento
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest

interface LancamentoService {

    fun buscarPorFuncionarioId(funcioarioId: String, pageRequest: PageRequest) : Page<Lancamento>

    fun buscarPorId(id: String) : Lancamento?

    fun persistir(lancamento: Lancamento) : Lancamento

    fun remover(lancamento: Lancamento)
}