package com.nicconicco.pontointeligente.controllers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import com.nicconicco.pontointeligente.services.*
import com.nicconicco.pontointeligente.documents.*
import com.nicconicco.pontointeligente.repositories.*
import com.nicconicco.pontointeligente.response.*
import com.nicconicco.pontointeligente.dtos.*
import com.nicconicco.pontointeligente.util.SenhaUtils

@RestController
@RequestMapping("/api/empresas")
class EmpresaController(val empresaService: EmpresaService) {

    @GetMapping(value = "/cnpj/{cnpj}")
    fun buscarPorCnpj(@PathVariable("cnpj") cnpj: String): ResponseEntity<Response<EmpresaDto>> {
        val response: Response<EmpresaDto> = Response<EmpresaDto>()
        val empresa: Empresa? = empresaService.buscarPorCnpj(cnpj)

        if (empresa == null) {
            response.erros.add("Empresa não econtrada para o CNPJ ${cnpj}")
            return ResponseEntity.badRequest().body(response)
        }

        response.data = converterEmpresaDto(empresa)
        return ResponseEntity.ok(response)
    }

    private fun converterEmpresaDto(empresa: Empresa): EmpresaDto =
            EmpresaDto(empresa.razaoSocial, empresa.cnpj, empresa.id)

}
