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
            Produto("Azeite Extra Virge Premium - 500ml", 27.00, 2),
            Produto("Bolo de Pistache e Framboesa - 2kg", 35.00, 2),
            Produto("Bolachas de Queijo Parmesão e Ervas Finas - 150g", 8.00, 3),
            Produto("Bolo de Chocolate Amargo com Caramelo Salgado - 1kg", 25.00, 2),
            Produto("Suco de pêssego - 1L", 6.99, 3),
            Produto("Iogurte Natural - 200ml", 8.00, 3)
        )
    }
    fun adicionarQuantidade(quantidade: Int) {
        if (quantidade < 0) {
            throw IllegalArgumentException("A quantidade adiconada deve ser numeros positivos")
        }
        val novaQuantidade = quantidadeDisponivel + quantidade
        if (novaQuantidade > estoqueMaximo) {
            throw IllegalArgumentException("O estoque maximo nao deve ser valor negativo")
        }
        quantidadeDisponivel = novaQuantidade
    }

    fun removerQuantidade(novaQuantidade: Int) {
        if (novaQuantidade < 0) {
            throw IllegalArgumentException("A qauntidade a ser removida execede a quantidade disponivel")
        }
        quantidadeDisponivel = novaQuantidade
    }
}