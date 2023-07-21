package lanchonete
val produtos = Produtos(0, "", 0.0, 0)
fun main() {

    menuPrincipal()
    var opcao: Int
    do {
        try {
            opcao = readln().toInt()

            when (opcao) {
                1 -> {
                    menuLanche()
                    opcao = readln().toInt()

                   try {
                       while (opcao !in 1..2) {
                           println("Opção inválida, tente novamente")
                           menuLanche()
                           opcao = readln().toInt()
                       }
                   }catch (e: NumberFormatException){
                       println("Formato inválido para escolher o item, você deve informar o número dele.")
                   }

                    val lanche = lanches[opcao - 1]

                    print("Informe a quantidade do lanche ${lanche.nome}:")
                     produtos.quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, lanche, produtos.quantidade)
                }

                2 -> {
                    menuBebida()
                    opcao = readln().toInt()

                    try {
                        while (opcao !in 1..2) {
                            println("Opção inválida, tente novamente")
                            menuBebida()
                            opcao = readln().toInt()
                        }
                    }catch (e: NumberFormatException){
                        println("Formato inválido para escolher o item, você deve informar o número dele.")
                    }

                    val bebida = bebidas[opcao - 1]

                    print("Informe a quantidade da bebida ${bebida.nome}:")
                    produtos.quantidade = readln().toInt()

                    Carrinho().adicionarAoCarrinho(carrinho, bebida, produtos.quantidade)

                }
            }

            Carrinho().exibirCarrinho(carrinho)

            println(
                "\n[1]. Comprar mais itens " +
                        "\n[2]. Editar um item " +
                        "\n[3]. Remover item " +
                        "\n[4]. Finalizar o pedido"
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
    val emojiHamburger = "\uD83C\uDF54"
    val emojiBebida = "\uD83C\uDF79"
    println(
        "\n===============================================================" +
                "\n\t\t\tBEM VINDO(A) A LANCHONETE FASTFOOD! " +
                "\n==============================================================="
    )
    println(
        "" +
                "\nQual será seu(s) pedido(s) hoje?\n" +
                "\n[1]. Lanche$emojiHamburger - [2]. Bebida$emojiBebida"
    )
}


fun menuLanche() {

    println(
        "\n===============================================================" +
                "\n\t\t\t\t\tNOSSOS LANCHES: " +
                "\n===============================================================" +
                "\n[1]. X-burger - [2]. X-salada"
    )

}

fun menuBebida() {

    println(
        "\n===============================================================" +
                "\n\t\t\t\t\tNOSSAS BEBIDAS: " +
                "\n===============================================================" +
                "\n[1]. Refrigerante - [2]. Suco"
    )
}