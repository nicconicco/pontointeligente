package com.nicconicco.pontointeligente.repositories

import com.nicconicco.pontointeligente.documents.Empresa
import org.springframework.data.mongodb.repository.MongoRepository

interface EmpresaRepository : MongoRepository<Empresa, String> {
    fun findByCnpj(cnpj: String) : Empresa
}