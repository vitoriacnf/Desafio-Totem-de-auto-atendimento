package lanchonete


data class Produtos(val codigo: Int, val nome: String, val preco: Double, var quantidade: Int)

val lanches = listOf(
    Produtos(1, "X-burger", 10.00, 0),
    Produtos(2, "X-salada", 12.00, 0)
)
val bebidas = listOf(
    Produtos(1, "Refrigerante", 8.00, 0),
    Produtos(2, "Suco", 6.00, 0)
)



