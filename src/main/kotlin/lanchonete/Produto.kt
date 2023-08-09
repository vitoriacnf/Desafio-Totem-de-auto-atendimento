package lanchonete


data class Produto(val codigo: Int, val nome: String, val preco: Double, var quantidade: Int)

val lanchesLista = listOf(
    Produto(123, "X-burger", 10.00, 0),
    Produto(321, "X-salada", 12.00, 0)
)
val bebidasLista = listOf(
    Produto(456, "Refrigerante", 8.00, 0),
    Produto(654, "Suco", 6.00, 0)
)



