package com.nicconicco.pontointeligente.controllers

import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid
import com.nicconicco.pontointeligente.services.*
import com.nicconicco.pontointeligente.documents.*
import com.nicconicco.pontointeligente.repositories.*
import com.nicconicco.pontointeligente.response.*
import com.nicconicco.pontointeligente.dtos.*
import com.nicconicco.pontointeligente.util.SenhaUtils
import com.nicconicco.pontointeligente.enums.*

@RestController
@RequestMapping("/api/cadastrar-pj")
class CadastroPJController(val empresaService: EmpresaService,
                           val funcionarioService: FuncionarioService) {

    @PostMapping
    fun cadastrar(@Valid @RequestBody cadastroPJDto: CadastroPJDto,
                  result: BindingResult): ResponseEntity<Response<CadastroPJDto>> {
        val response: Response<CadastroPJDto> = Response<CadastroPJDto>()

        validarDadosExistentes(cadastroPJDto, result)
        if (result.hasErrors()) {
            for (erro in result.allErrors) response.erros.add(erro.defaultMessage!!)
            return ResponseEntity.badRequest().body(response)
        }

        val empresa: Empresa = converterDtoParaEmpresa(cadastroPJDto)
        empresaService.persistir(empresa)

        val funcionario: Funcionario = converterDtoParaFuncionario(cadastroPJDto, empresa)
        funcionarioService.persistir(funcionario)
        response.data = converterCadastroPJDto(funcionario, empresa)

        return ResponseEntity.ok(response)
    }

    private fun validarDadosExistentes(cadastroPJDto: CadastroPJDto, result: BindingResult) {
        val empresa: Empresa? = empresaService.buscarPorCnpj(cadastroPJDto.cnpj)
        if (empresa != null) {
            result.addError(ObjectError("empresa", "Empresa já existente."))
        }

        val funcionarioCpf: Funcionario? = funcionarioService.buscarPorCpf(cadastroPJDto.cpf)
        if (funcionarioCpf != null) {
            result.addError(ObjectError("funcionario", "CPF já existente."))
        }

        val funcionarioEmail: Funcionario? = funcionarioService.buscarPorEmail(cadastroPJDto.email)
        if (funcionarioEmail != null) {
            result.addError(ObjectError("funcionario", "Email já existente."))
        }
    }

    private fun converterDtoParaEmpresa(cadastroPJDto: CadastroPJDto): Empresa =
        Empresa(cadastroPJDto.razaoSocial, cadastroPJDto.cnpj)


    private fun converterDtoParaFuncionario(cadastroPJDto: CadastroPJDto, empresa: Empresa) =
        Funcionario(cadastroPJDto.nome, cadastroPJDto.email,
                SenhaUtils().gerarBcrypt(cadastroPJDto.senha), cadastroPJDto.cpf,
                PerfilEnum.ROLE_ADMIN, empresa.id.toString())

    private fun converterCadastroPJDto(funcionario: Funcionario, empresa: Empresa): CadastroPJDto =
            CadastroPJDto(funcionario.nome, funcionario.email, "", funcionario.cpf,
                    empresa.cnpj, empresa.razaoSocial, funcionario.id)

}
