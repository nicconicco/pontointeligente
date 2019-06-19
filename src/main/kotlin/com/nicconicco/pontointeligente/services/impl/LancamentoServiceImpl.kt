package com.nicconicco.pontointeligente.services.impl

import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import com.nicconicco.pontointeligente.services.*
import com.nicconicco.pontointeligente.documents.*
import com.nicconicco.pontointeligente.repositories.*
import com.nicconicco.pontointeligente.response.*
import com.nicconicco.pontointeligente.dtos.*
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.nicconicco.pontointeligente.utils.SenhaUtils


@Service
class LancamentoServiceImpl (val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest) =
            lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String) {
    //lancamentoRepository.findOne(id!!)
    }

    override fun persistir(lancamento: Lancamento)  {
    //lancamentoRepository.save(lancamento) 
    }

    override fun remover(id: String) {
    //lancamentoRepository.delete(id!!)
    } 

}
