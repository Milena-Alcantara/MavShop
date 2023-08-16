package controller

import model.Produto

class ProdutoController {
    private val listaProdutos = mutableListOf<Produto>()

    fun adicionarProduto(produto: Produto){
        listaProdutos.add(produto)
    }
    fun removerProduto(produto: Produto){
        listaProdutos.remove(produto)
    }
    fun buscarProdutoPorNome(nome: String): Produto? {
        return listaProdutos.find { it.nome == nome }
    }
}