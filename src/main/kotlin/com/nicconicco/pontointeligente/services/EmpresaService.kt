package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.documents.Empresa

interface EmpresaService {
    fun buscarPorCnpj(cnpj: String) : Empresa?
    fun persistir(empresa: Empresa) : Empresa
}