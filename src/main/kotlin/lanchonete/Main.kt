package lanchonete

val produtos = Produto(0, "", 0.0, 0)
val menu = Menu()
fun main() {

    menu.mostrarMenuPrincipal()
    var opcao: Int
    do {
        try {
            opcao = readln().toInt()

            when (opcao) {
                1 -> {
                    menu.mostrarMenuLanche()
                    opcao = readln().toInt()

                    try {
                        while (opcao !in 1..2) {
                            println("Opção inválida, tente novamente")
                            menu.mostrarMenuLanche()
                            opcao = readln().toInt()
                        }
                    } catch (e: NumberFormatException) {
                        println("Formato inválido para escolher o item, você deve informar o número dele.")
                    }

                    val lanche = lanchesLista[opcao - 1]

                    print("Informe a quantidade do lanche ${lanche.nome}:")
                    produtos.quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, lanche, produtos.quantidade)
                }

                3 -> {
                    println("Finalizando o sistema. Obrigado por usar.")
                    return
                }

                2 -> {
                    menu.mostrarMenuBebida()
                    opcao = readln().toInt()

                    try {
                        while (opcao !in 1..2) {
                            println("Opção inválida, tente novamente")
                            menu.mostrarMenuBebida()
                            opcao = readln().toInt()
                        }
                    } catch (e: NumberFormatException) {
                        println("Formato inválido para escolher o item, você deve informar o número dele.")
                    }

                    val bebida = bebidasLista[opcao - 1]

                    print("Informe a quantidade da bebida ${bebida.nome}:")
                    produtos.quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, bebida, produtos.quantidade)

                }
            }

            Carrinho().exibirCarrinho(carrinho)

            menu.gerenciarAlteracoesPedido()
            break
        } catch (e: NumberFormatException) {
            println("Formato inválido para escolher o item, você deve informar o número dele.")
        }
    } while (true)
}

