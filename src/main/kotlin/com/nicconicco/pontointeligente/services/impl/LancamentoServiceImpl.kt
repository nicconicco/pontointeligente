package com.nicconicco.pontointeligente.services.impl

import com.nicconicco.pontointeligente.documents.Lancamento
import com.nicconicco.pontointeligente.repositories.LancamentoRepository
import com.nicconicco.pontointeligente.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service


@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {
    override fun buscarPorFuncionarioId(funcioarioId: String, pageRequest: PageRequest): Page<Lancamento> =
            lancamentoRepository.findByFuncionarioId(funcioarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento? = lancamentoRepository.findById(id).orElseThrow { RuntimeException() }

    override fun persistir(lancamento: Lancamento): Lancamento = lancamentoRepository.save(lancamento)

    override fun remover(lancamento: Lancamento) = lancamentoRepository.delete(lancamento)

}
