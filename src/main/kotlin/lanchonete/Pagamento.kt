package lanchonete

class Pagamento {
    fun efetuarPagammento() {

        println(
            "Qual a forma de pagamento?" +
                    "\n1. Cartão de crédito" +
                    "\n2. Cartão de débito" +
                    "\n3. Vale refeição" +
                    "\n4. Dinheiro"
        )

        when (readln().toInt()) {
            1, 2, 3 -> println("Compra finalizada com sucesso!")
            4 -> {
                print("Informe o valor em dinheiro: R$ ")
                val valorPago = readln().toInt()

                val total = carrinho.sumOf { it.preco }
                val troco = valorPago - total

                if (troco >= 0) {
                    println("Troco: R$ ${String.format("%.2f", troco)}")
                    println("Compra finalizada com sucesso!")

                } else {
                    println("Valor insuficiente. Pagamento não realizado.")
                }
            }

            else -> println("Opção inválida, tente novamente.")
        }
    }
}

