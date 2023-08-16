package model

import java.lang.IllegalArgumentException

data class Produto(val nome: String, val preco: Double, val estoqueMaximo: Int) {
    private var quantidadeDisponivel: Int = 0

    init {
        if (estoqueMaximo < 0) {
            throw IllegalArgumentException("O estoque maximo dever ser um valor nao negativo")
        }
    }

    object ProdutosDisponiveis {
        val produtos: List<Produto> = listOf(
            Produto("Arroz Tipo 1 - 5kg", 12.00, 1),
            Produto("Feijão Carioquinha - 1kg", 6.99, 2),
        )
    }
}