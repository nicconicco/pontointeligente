package com.nicconicco.pontointeligente

import com.nicconicco.pontointeligente.documents.Empresa
import com.nicconicco.pontointeligente.documents.Funcionario
import com.nicconicco.pontointeligente.enums.PerfilEnum
import com.nicconicco.pontointeligente.repositories.EmpresaRepository
import com.nicconicco.pontointeligente.repositories.FuncionarioRepository
import com.nicconicco.pontointeligente.repositories.LancamentoRepository
import com.nicconicco.pontointeligente.util.SenhaUtils
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration

@SpringBootApplication
class PontointeligenteApplication(val empresaRepository: EmpresaRepository,
								  val funcionarioRepository: FuncionarioRepository,
								  val lancamentoRepository: LancamentoRepository) : CommandLineRunner {

	override fun run(vararg args: String?) {
		empresaRepository.deleteAll()
		funcionarioRepository.deleteAll()
		lancamentoRepository.deleteAll()

		var empresa: Empresa = Empresa("Empresa LTDA", "35417492000108")
		empresa = empresaRepository.save(empresa)

		var admin: Funcionario
				= Funcionario("Isadora Giongo", "isa@gmail.com",
				SenhaUtils().gerarBcrypt("123456"), "42357696001",
				PerfilEnum.ROLE_ADMIN, empresa.id!!)
		admin = funcionarioRepository.save(admin)

		var funcionario: Funcionario
				= Funcionario("Veronica Torres", "veronica@gmail.com",
				SenhaUtils().gerarBcrypt("654321"), "17347006023",
				PerfilEnum.ROLE_USUARIO, empresa.id!!)
		funcionario = funcionarioRepository.save(funcionario)

		System.out.println("Empresa ID: " + empresa.id)
		System.out.println("Admin iD: " + admin.id)
		System.out.println("Funcionario iD: " + funcionario.id)
	}
}

fun main(args: Array<String>) {
	SpringApplication.run(PontointeligenteApplication::class.java, *args)
}
