package testes

import lanchonete.Pagamento
import lanchonete.Produtos
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.time.LocalDate

class PagamentoTest {

    @Test
    fun deveRetornarTotalCompra() {
        val carrinho = mutableListOf(
            Produtos(1, "Produto A", 10.0, 2),
            Produtos(2, "Produto B", 5.0, 3)
        )

        val pagamento = Pagamento()

        val total = pagamento.totalCompra(carrinho)

        assertEquals(35.0, total)
    }
    @Test
    fun deveGerarNotaFiscalComInformacoesDaCompra() {
        val carrinho = mutableListOf(
            Produtos(1, "Produto A", 10.0, 2),
            Produtos(2, "Produto B", 5.0, 3)
        )

        val pagamento = Pagamento()

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        pagamento.gerarNotaFiscal(carrinho)

        val cnpj = "65.867.518/0001-72"
        val data = LocalDate.now()

        val expectedOutput = """
            NOTA FISCAL
            CNPJ: $cnpj
            Data da compra: $data
            
            Produto A
            ID do produto: 1
            Quantidade: 2
            Preço: R$10.0
            
            Produto B
            ID do produto: 2
            Quantidade: 3
            Preço: R$5.0
            Valot total da compra: R$35.0
        """.trimIndent()

        assertEquals(expectedOutput, outContent.toString().trim())
    }
}

