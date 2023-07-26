package testes

import lanchonete.Carrinho
import lanchonete.Produtos
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class CarrinhoTest {

    @Test
    fun deveAdicionarAoCarrinhoComQuantidade() {
        val carrinho = mutableListOf<Produtos>()
        val carrinhoObj = Carrinho()

        val produto = Produtos(1, "Produto A", 10.0, 2)
        carrinhoObj.adicionarAoCarrinho(carrinho, produto, 2)

        assertEquals(1, carrinho.size)
        assertTrue(carrinho.contains(produto))
        assertEquals(2, carrinho[0].quantidade)
    }

    @Test
    fun deveAdicionarAoCarrinhoSemQuantidade() {
        val carrinho = mutableListOf<Produtos>()
        val carrinhoObj = Carrinho()

        val produto = Produtos(1, "Produto A", 10.0, 2)
        carrinhoObj.adicionarAoCarrinho(carrinho, produto, 2)

        assertEquals(1, carrinho.size)
        assertTrue(carrinho.contains(produto))
        assertEquals(2, carrinho[0].quantidade)
    }

    @Test
    fun deveExibirCarrinho() {
        val carrinho = mutableListOf<Produtos>()
        val carrinhoObj = Carrinho()

        val produto1 = Produtos(1, "Produto A", 10.0, 2)
        val produto2 = Produtos(2, "Produto B", 5.0, 3)

        carrinhoObj.adicionarAoCarrinho(carrinho, produto1, 2)
        carrinhoObj.adicionarAoCarrinho(carrinho, produto2, 3)

        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        carrinhoObj.exibirCarrinho(carrinho)

        val expectedOutput =
            "\n===============================================================\n\t\t\t\t\tRESUMO DA COMPRA: \n" +
                    "Produto A - Quantidade: 2 - Valor: R$ 10,00\n" +
                    "Produto B - Quantidade: 3 - Valor: R$ 5,00\n" +
                    "\n===============================================================\n"

        assertEquals(expectedOutput, outContent.toString())
    }

    @Test
    fun deveMostrarEdicaoDosProdutos() {
        val carrinho = mutableListOf<Produtos>()
        val carrinhoObj = Carrinho()

        val produto = Produtos(1, "Produto A", 10.0, 1)
        carrinhoObj.adicionarAoCarrinho(carrinho, produto, 1)

        System.setIn("5\n".byteInputStream())
        carrinhoObj.editarProdutos()

        assertEquals(1, carrinho.size)
        assertEquals(1, carrinho[0].quantidade)
    }

    @Test
    fun deveRemoverProdutos() {
        val carrinho = mutableListOf<Produtos>()
        val carrinhoObj = Carrinho()

        val produto = Produtos(1, "Produto A", 10.0, 2)
        carrinhoObj.adicionarAoCarrinho(carrinho, produto, 2)

        System.setIn("1\n".byteInputStream())
        carrinhoObj.removerProdutos()

        assertEquals(1, carrinho.size)

    }
}


