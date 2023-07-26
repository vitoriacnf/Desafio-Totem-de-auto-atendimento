package lanchonete

import untils.Pausa
import java.time.LocalDate

class Pagamento {
    fun efetuarPagammento() {
        val emojiCartao = "\uD83D\uDCB3"
        val emojiNotaDinheiro = "\uD83D\uDCB5"

        totalCompra(carrinho)
        println(
            "\n===============================================================" +
                    "\n\t\t\t\t\tPAGAMENTO: " +

                    "\nQual a forma de pagamento?" +
                    "\n[1]. Cartão de crédito$emojiCartao" +
                    "\n[2]. Cartão de débito$emojiCartao" +
                    "\n[3]. Vale refeição$emojiCartao" +
                    "\n[4]. Dinheiro$emojiNotaDinheiro" +
                    "\n==============================================================="
        )
        val emojiApertoDeMao = "\uD83E\uDD1D"
        when (readln().toInt()) {

            1 ->{
                println("Compra finalizada com sucesso! Agradecemos a preferencia!$emojiApertoDeMao")
                println("Gerando nota fiscal...")
                Pausa().pausar(2)
                gerarNotaFiscal(carrinho)
            }
            2 ->{
                println("Compra finalizada com sucesso! Agradecemos a preferencia!$emojiApertoDeMao")
                println("Gerando nota fiscal...")
                Pausa().pausar(2)
                gerarNotaFiscal(carrinho)
            }
                3 -> {
                    println("Compra finalizada com sucesso! Agradecemos a preferencia!$emojiApertoDeMao")
                    println("Gerando nota fiscal...")
                    Pausa().pausar(2)
                    gerarNotaFiscal(carrinho)
                }
            4 -> {
                print("Informe o valor em dinheiro: R$ ")
                val valorPago = readln().toInt()
                val total = carrinho.sumOf { it.preco }
                val troco = valorPago - total

                if (troco >= 0) {
                    println("Troco: R$ ${String.format("%.2f", troco)}")
                    println("Compra finalizada com sucesso!Agradecemos a preferencia!$emojiApertoDeMao")
                    println("Gerando nota fiscal...")
                    Pausa().pausar(2)
                    gerarNotaFiscal(carrinho)
                } else {
                    println("Valor insuficiente. Pagamento não realizado.")
                }
            }

            else -> println("Opção inválida, tente novamente.")
        }
    }

    private fun totalCompra(carrinho: List<Produtos>): Double {
        val total = carrinho.sumOf { it.preco * it.quantidade }
        println("Valot total da compra: R$$total")
        return total
    }

    private fun gerarNotaFiscal(carrinho: List<Produtos>) {
        val cnpj = "65.867.518/0001-72"
        val data = LocalDate.now()
        println(
            "\n\t\t\t\tNOTA FISCAL" +
                    "\nCNPJ: $cnpj" +
                    "\nData da compra: $data"
        )
        carrinho.forEach() {
            println("\n${it.nome}" +
                        "\nID do produto: ${it.codigo}" +
                        "\nQuantidade: ${produtos.quantidade}" +
                        "\nPreço: R$${it.preco}"
            )
        }
            totalCompra(carrinho)
    }
}

