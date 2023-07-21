package lanchonete

val carrinho = mutableListOf<Produtos>()

class Carrinho {

    fun adicionarAoCarrinho(carrinho: MutableList<Produtos>, item: Produtos, quantidade: Int) {
        carrinho.add(Produtos(item.codigo, item.nome, item.preco, quantidade))
    }

    fun exibirCarrinho(carrinho: List<Produtos>) {

        println("\n===============================================================" +
                "\n\t\t\t\t\tRESUMO DA COMPRA: " )
        carrinho.forEach {
            println("${it.nome} - Quantidade: ${it.codigo} - Valor: R$ ${String.format("%.2f", it.preco)}")
        }
        println( "\n===============================================================")
    }

    fun editarProdutos() {
        print("Informe o código do produto que deseja editar: ")
        val codigo = readln().toInt()
        val produto = carrinho.find { it.codigo == codigo }

        if (produto != null) {
            print("Informe a nova quantidade:")
            val novaQuantidade = readln().toInt()
            adicionarAoCarrinho(carrinho, produto, novaQuantidade)
            carrinho.remove(produto)
        } else {
            println("Código de produto inválido.")
        }
    }

    fun removerProdutos() {
        print("Informe o código do produto que deseja remover: ")
        val codigo = readln().toInt()
        val produto = carrinho.find { it.codigo == codigo }

        if (produto != null) {
            carrinho.remove(produto)
            println("Produto removido.")
        } else {
            println("Código de produto inválido.")
        }
    }
}