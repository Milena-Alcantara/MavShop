package useCase

import controller.CestaController
import model.Produto

class PersonalizarUseCase {
    val cestaController = CestaController()
    val cestaBasica = cestaController.getCestaBasica()
    val cestaPlus = cestaController.getCestaPlus()
    fun adicionarProdutoCestaPlus(produtoIndex:Int?){
        val produtoSelecionado = Produto.ProdutosDisponiveis.produtos.getOrNull(produtoIndex ?: -1)

        if (produtoSelecionado != null) {
            cestaPlus.adicionarProduto(produtoSelecionado)
            println("${produtoSelecionado.nome} adicionado à cesta Plus.")
        } else {
            println("Produto não encontrado.")
        }
    }

    fun removerProdutoCestaPlus(produtoIndex:Int?){
        val produtoSelecionado = cestaPlus.produtos.getOrNull(produtoIndex ?: -1)

        if (produtoSelecionado != null) {
            cestaPlus.removerProduto(produtoSelecionado)
            println("${produtoSelecionado.nome} removido da cesta Plus.")
        } else {
            println("Produto não encontrado na cesta.")
        }
    }

    fun mostrarProdutosDisponiveis(){
        println("Produtos disponíveis:")
        Produto.ProdutosDisponiveis.produtos.forEachIndexed { index, produto ->
            println("$index  - $produto.nome")
        }
    }
    fun mostrarProdutosPlus(){
        println("Produtos na cesta Plus:")
        cestaPlus.produtos.forEach { produto ->
            println("${produto.nome} - Preço: R$${produto.preco}")
        }
    }
    fun mostrarProdutosCestaBasico(){
        println("Produtos na cesta Básica:")
        cestaBasica.produtos.forEach { produto ->
            println("${produto.nome} - Preço: R$${produto.preco}")
        }
    }

}