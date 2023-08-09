package lanchonete

class Menu {
    fun mostrarMenuPrincipal() {
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
                    "\n[1]. Lanche$emojiHamburger - [2]. Bebida$emojiBebida "
        )
    }


    fun mostrarMenuLanche() {

        println(
            "\n===============================================================" +
                    "\n\t\t\t\t\tNOSSOS LANCHES: " +
                    "\n===============================================================" +
                    "\n[1]. X-burger - [2]. X-salada"
        )

    }

    fun mostrarMenuBebida() {

        println(
            "\n===============================================================" +
                    "\n\t\t\t\t\tNOSSAS BEBIDAS: " +
                    "\n===============================================================" +
                    "\n[1]. Refrigerante - [2]. Suco"
        )
    }

    fun gerenciarAlteracoesPedido() {
        println(
            "\n[1]. Comprar mais itens " +
                    "\n[2]. Editar um item " +
                    "\n[3]. Remover item " +
                    "\n[4]. Finalizar o pedido"
        )

        when (readln().toInt()) {
            1 -> mostrarMenuPrincipal()
            2 -> {
                Carrinho().editarProdutos()
            }

            3 -> {
                Carrinho().removerProdutos()
            }

            4 -> {
                Carrinho().exibirCarrinho(carrinho)
                Pagamento(carrinho).efetuarPagamento()
            }
            else -> println("Opção inválida, tente novamente.")
        }
    }
}