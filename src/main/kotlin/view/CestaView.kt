package view

import controller.CestaController
import model.CestaBasica
import model.Produto

fun main() {
    val cestaController = CestaController()
    val cestaBasica = cestaController.getCestaBasica()
    val cestaPlus = cestaController.getCestaPlus()

    println(
        "Escolha uma opção:" +
                "\n1 - Adicionar produto à cesta Plus" +
                "\n2 - Remover produto da cesta Plus" +
                "\n3 - Ver produtos na cesta Plus" +
                "\n4 - Ver produtos na cesta Básica" +
                "\n5 - Calcular valor total da cesta básica" +
                "\n6 - Calcular valor total da cesta plus" +
                "\n0 - Sair"
    )

    while (true) {
        print("Opção: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Produtos disponíveis:")
                Produto.ProdutosDisponiveis.produtos.forEachIndexed { index, produto ->
                    println("$index - ${produto.nome}")
                }

                print("Escolha o número do produto a adicionar: ")
                val produtoIndex = readlnOrNull()?.toIntOrNull()
                val produtoSelecionado = Produto.ProdutosDisponiveis.produtos.getOrNull(produtoIndex ?: -1)

                if (produtoSelecionado != null) {
                    cestaPlus.adicionarProduto(produtoSelecionado)
                    println("${produtoSelecionado.nome} adicionado à cesta Plus.")
                } else {
                    println("Produto não encontrado.")
                }
            }

            2 -> {
                println("Produtos na cesta Plus:")
                cestaPlus.produtos.forEachIndexed { index, produto ->
                    println("$index - ${produto.nome}")
                }

                print("Escolha o número do produto a remover: ")
                val produtoIndex = readlnOrNull()?.toIntOrNull()
                val produtoSelecionado = cestaPlus.produtos.getOrNull(produtoIndex ?: -1)

                if (produtoSelecionado != null) {
                    cestaPlus.removerProduto(produtoSelecionado)
                    println("${produtoSelecionado.nome} removido da cesta Plus.")
                } else {
                    println("Produto não encontrado na cesta.")
                }
            }

            3 -> {
                println("Produtos na cesta Plus:")
                cestaPlus.produtos.forEach { produto ->
                    println("${produto.nome} - Preço: ${produto.preco}")
                }
            }

            4 -> {
                println("Produtos na cesta Básica:")
                cestaBasica.produtos.forEach { produto ->
                    println("${produto.nome} - Preço: ${produto.preco}")
                }
            }

            5 -> {
                val valorTotal = CestaBasica().calcularValorTotalBasica()
                println("Valor total da cesta Básica: R$ $valorTotal")
            }

            6 -> {
                val valorTotal = cestaPlus.calcularValorTotalPlus()
                println("Valor total da cesta Plus: R$ $valorTotal")
            }

            0 -> {
                println("Saindo do sistema.")
                return
            }

            else -> {
                println("Opção inválida. Escolha uma opção válida.")
            }
        }
    }
}


