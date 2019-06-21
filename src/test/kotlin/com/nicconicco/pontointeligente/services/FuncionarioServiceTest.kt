package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.documents.Funcionario
import com.nicconicco.pontointeligente.enums.PerfilEnum
import com.nicconicco.pontointeligente.repositories.FuncionarioRepository
import com.nicconicco.pontointeligente.util.SenhaUtils
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureDataMongo
class FuncionarioServiceTest {

    @Autowired
    val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val CPF = "07809934970"
    private val EMAIL = "nico@nico.com"
    private val ID = "1"

    @Before
    @Throws(Exception::class)
    fun setup(){
        BDDMockito.given(funcionarioRepository?.findByCpf(CPF)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findByEmail(EMAIL)).willReturn(funcionario())
        BDDMockito.given(funcionarioRepository?.findById(ID)).willReturn(Optional.of(funcionario()))
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java))).willReturn(funcionario())
    }

    @Test
    fun testBuscarPorId() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorId(ID)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarEmpresaPorCpf() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorCpf(CPF)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarEmpresaPorEmail() {
        val funcionario: Funcionario? = funcionarioService?.buscarPorEmail(EMAIL)
        Assert.assertNotNull(funcionario)
    }

    @Test
    fun testPersistirFuncionario() {
        val funcionario: Funcionario? = funcionarioService?.persistir(funcionario())
        Assert.assertNotNull(funcionario)
    }

    private fun funcionario(): Funcionario = Funcionario(
            "Razao Social", "nico@nico.com", SenhaUtils().gerarBcrypt("123456"), CPF, PerfilEnum.ROLE_ADMIN,
            "1")
}