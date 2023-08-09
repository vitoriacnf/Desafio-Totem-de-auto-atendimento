package lanchonete

import untils.Pausa
import java.time.LocalDate

class Pagamento(private val carrinho: List<Produto>) {

    fun efetuarPagamento() {
        exibirOpcoesPagamento()

        when (readOption()) {
            in 1..3 -> processarPagamento()
            4 -> processarPagamentoDinheiro()
            else -> println("Opção inválida, tente novamente.")
        }
    }

    private fun exibirOpcoesPagamento() {
        val emojis = mapOf(1 to "\uD83D\uDCB3", 2 to "\uD83D\uDCB5", 3 to "\uD83D\uDCB3", 4 to "\uD83D\uDCB5")

        println(
            "\n===============================================================" +
                    "\n\t\t\t\t\tPAGAMENTO: " +
                    "\nQual a forma de pagamento?"
        )

        for (option in 1..4) {
            println("[$option]. ${getOpcaoPagamentoText(option)} ${emojis[option]}")
        }

        println("===============================================================")
    }

    private fun getOpcaoPagamentoText(option: Int): String {
        return when (option) {
            1, 2, 3 -> "Cartão de ${if (option == 3) "vale " else ""}crédito"
            4 -> "Dinheiro"
            else -> "Opção desconhecida"
        }
    }

    private fun readOption(): Int {
        return readlnOrNull()?.toIntOrNull() ?: -1
    }

    private fun processarPagamento() {
        println("Compra finalizada com sucesso! Agradecemos a preferência! \uD83E\uDD1D")
        println("Gerando nota fiscal...")
        Pausa().pausar(2)
        gerarNotaFiscal()
    }

    private fun processarPagamentoDinheiro() {
        print("Informe o valor em dinheiro: R$ ")
        val valorPago = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        val total = carrinho.sumOf { it.preco }
        val troco = valorPago - total

        if (troco >= 0) {
            println("Troco: R$ ${String.format("%.2f", troco)}")
            processarPagamento()
        } else {
            println("Valor insuficiente. Pagamento não realizado.")
        }
    }

    private fun gerarNotaFiscal() {
        val cnpj = "65.867.518/0001-72"
        val data = LocalDate.now()

        println(
            "\n\t\t\t\tNOTA FISCAL" +
                    "\nCNPJ: $cnpj" +
                    "\nData da compra: $data"
        )

        for (produto in carrinho) {
            println(
                "\n${produto.nome}" +
                        "\nID do produto: ${produto.codigo}" +
                        "\nQuantidade: ${produto.quantidade}" +
                        "\nPreço: R$${produto.preco}"
            )
        }

        println("\nValor total da compra: R$${carrinho.sumOf { it.preco * it.quantidade }}")
    }
}
