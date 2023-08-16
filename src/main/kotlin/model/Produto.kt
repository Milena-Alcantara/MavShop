package model

import java.lang.IllegalArgumentException

data class Produto(val nome: String, val preco: Double, val estoqueMaximo: Int) {
    private var quantidadeDisponivel: Int = 0

    init {
        if (estoqueMaximo < 0) {
            throw IllegalArgumentException("O estoque maximo dever ser um valor nao negativo")
        }
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