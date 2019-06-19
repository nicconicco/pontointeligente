package com.nicconicco.pontointeligente.services

import com.nicconicco.pontointeligente.documents.Lancamento
import com.nicconicco.pontointeligente.enums.TipoEnum
import com.nicconicco.pontointeligente.repositories.LancamentoRepository
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
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.test.context.junit4.SpringRunner
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureDataMongo
class LancamentoServiceTest {
    @Autowired
    val lancamentoService: LancamentoService? = null

    @MockBean
    private val lancamentoRepository: LancamentoRepository? = null

    private val ID = "1"

    @Before
    @Throws(Exception::class)
    fun setup(){
        BDDMockito.given<Page<Lancamento>>(lancamentoRepository?.findByFuncionarioId(ID, PageRequest(0, 10)))
                .willReturn(PageImpl(ArrayList<Lancamento>()))
        BDDMockito.given(lancamentoRepository?.findById(ID)).willReturn(Optional.of(lancamento()))
        BDDMockito.given(lancamentoRepository?.save(Mockito.any(Lancamento::class.java))).willReturn(lancamento())
    }

    @Test
    fun testBuscarFuncionarioId() {
        val lancamento: Page<Lancamento>? = lancamentoService?.buscarPorFuncionarioId(ID, PageRequest(0, 10))
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testBuscarPorId() {
        val lancamento: Lancamento? = lancamentoService?.buscarPorId(ID)
        Assert.assertNotNull(lancamento)
    }

    @Test
    fun testPersistir() {
        val lancamento: Lancamento? = lancamentoService?.persistir(lancamento())
        Assert.assertNotNull(lancamento)
    }

    private fun lancamento(): Lancamento = Lancamento(
            Date(), TipoEnum.INICIO_TRABALHO, ID)
}