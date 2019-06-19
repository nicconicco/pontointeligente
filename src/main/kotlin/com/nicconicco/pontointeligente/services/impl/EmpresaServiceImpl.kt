package com.nicconicco.pontointeligente.services.impl

import com.nicconicco.pontointeligente.documents.Empresa
import com.nicconicco.pontointeligente.repositories.EmpresaRepository
import com.nicconicco.pontointeligente.services.EmpresaService
import org.springframework.stereotype.Service

@Service
class EmpresaServiceImpl(val empresaRepository: EmpresaRepository) : EmpresaService {

    override fun buscarPorCnpj(cnpj: String): Empresa? = empresaRepository.findByCnpj(cnpj)

    override fun persistir(empresa: Empresa): Empresa = empresaRepository.save(empresa)
}