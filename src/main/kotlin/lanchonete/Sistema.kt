package lanchonete

fun main() {

    menuPrincipal()
    var opcao: Int
    do {
        try {
            opcao = readln().toInt()

            when(opcao){
                1 -> {
                    menuLanche()
                    opcao = readln().toInt()

                    while (opcao !in 1..2) {
                        println("Opção inválida, tente novamente")
                        menuLanche()
                        opcao = readln().toInt()
                    }

                    val lanche = lanches[opcao - 1]

                    print("Informe a quantidade do lanche ${lanche.nome}:")
                    val quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, lanche, quantidade)
                }
                2 -> {
                    menuBebida()
                    opcao = readln().toInt()

                    while (opcao !in 1..2) {
                        menuBebida()
                        opcao = readln().toInt()
                    }

                    val bebida = bebidas[opcao - 1]

                    print("Informe a quantidade da bebida ${bebida.nome}:")
                    val quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, bebida, quantidade)

                }
            }

            Carrinho().exibirCarrinho(carrinho)

            println(
                "\n1. Comprar mais itens " +
                        "\n2. Editar um item " +
                        "\n3. Remover item " +
                        "\n4. Finalizar o pedido"
            )

            opcao = readln().toInt()

            when (opcao) {
                1 -> menuPrincipal()
                2 -> {
                    Carrinho().editarProdutos()
                }

                3 -> {
                    Carrinho().removerProdutos()
                }

                4 -> {
                    Carrinho().exibirCarrinho(carrinho)
                    Pagamento().efetuarPagammento()
                    break
                }

                else -> println("Opção inválida, tente novamente.")
            }
        } catch (e: NumberFormatException) {
            println("Formato inválido para escolher o item, você deve informar o número dele.")
        }
    } while (true)
}

fun menuPrincipal() {
    println("\n\t\t\tBEM VINDO(A) A LANCHONETE FASTFOOD! " +
            "\nQual será seu(s) pedido(s) hoje? " +
            "\n1. Lanche" +
            "\n2. Bebida")
}


fun menuLanche(){
    println(
        "\n\t\t\tLanches: " +
                "\n1. X-burger " +
                "\n2. X-salada"
    )
}

fun menuBebida(){
    println(
        "\n\t\t\tBebidas:" +
                "\n1. Refrigerante  " +
                "\n2. Suco "
    )
}