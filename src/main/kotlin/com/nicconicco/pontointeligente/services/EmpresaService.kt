package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.services.*
import com.nicconicco.pontointeligente.documents.*
import com.nicconicco.pontointeligente.repositories.*

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String): Empresa?

    fun persistir(empresa: Empresa): Empresa

}
