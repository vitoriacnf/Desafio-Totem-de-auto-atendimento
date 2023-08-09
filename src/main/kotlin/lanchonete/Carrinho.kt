package lanchonete

val carrinho = mutableListOf<Produto>()

class Carrinho {

    fun adicionarAoCarrinho(carrinho: MutableList<Produto>, item: Produto, quantidade: Int) {
        carrinho.add(Produto(item.codigo, item.nome, item.preco, quantidade))
    }

    fun exibirCarrinho(carrinho: List<Produto>) {

        println("\n===============================================================" +
                "\n\t\t\t\t\tRESUMO DA COMPRA: " )
        carrinho.forEach {
            println("${it.codigo}.${it.nome} - Quantidade: ${it.quantidade} - Valor unitário: R$ ${String.format("%.2f", it.preco)}")
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