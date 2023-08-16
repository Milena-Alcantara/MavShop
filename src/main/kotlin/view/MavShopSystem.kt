package view

import controller.CarrinhoController
import controller.CestaController
import model.CestaBasica
import model.CestaPlus
import model.NotaFiscal
import model.Produto

val clientService = ClientView()
var totalCarrinho = 0.0
fun main(args: Array<String>) {
    menuClient()
    comprarCestas()
}
fun menuClient(){
    do {
        println()
        println("----------Bem vindo ao MAV SHOP!----------")
        println("Informe a opção desejada: " +
                "\n\t 1- Efetuar cadastro\n\t 2- Logar ")
        var choice = readln().toIntOrNull() ?: 0

        when(choice){
            1 -> {clientService.register()
                println()
            clientService.login()}
            2-> { clientService.login()
            }

            else-> println("Opção inválida")
        }
        println()
    }while (choice !in 1..2)
}
fun comprarCestas(){
    val carrinhoController = CarrinhoController()
    val notaFiscal =  NotaFiscal()
    do {
        println("Informe a ação desejada: " +

                "\n\t1- Comprar Cesta Básica\n\t2- Comprar Cesta Plus\n\t3- Personalizar")

                "\n\t1- Comprar Cesta Básica\n\t2- Comprar Cesta Plus\n\t3- Personalizar\n\t0- Sair")

        var choice = readln().toIntOrNull()
        when(choice){
            1-> { val cestaBasica = CestaBasica()
                carrinhoController.adicionarCestaAoCarrinho(cestaBasica)
                totalCarrinho += cestaBasica.calcularValorTotalBasica()
                println("Valor total até o momento: R$${cestaBasica.calcularValorTotalBasica()}")
                finalizarCompra()
                notaFiscal.gerarNotaFiscalCestaBasica(cestaBasica)
            }
            2-> {
                val cestaPlus = CestaPlus()
                carrinhoController.adicionarCestaAoCarrinho(cestaPlus)
                totalCarrinho+=cestaPlus.calcularValorTotalPlus()
                println("Valor total até o momento: R$${cestaPlus.calcularValorTotalPlus()}")
                finalizarCompra()
                notaFiscal.gerarNotaFiscalCestaplus(cestaPlus)
            }
            3-> menuPersonalizarCestas()
            0-> {println("Saindo do sistema")
                return}
            else-> println("Opção inválida")
        }
    }while (choice !in 0..3)
}

fun menuPersonalizarCestas(){
    val cestaController = CestaController()
    val cestaBasica = cestaController.getCestaBasica()
    val cestaPlus = cestaController.getCestaPlus()

    println(
        "Escolha uma opção:" +
                "\n1 - Adicionar produto na cesta Plus" +
                "\n2 - Remover produto da cesta Plus" +
                "\n3 - Ver produtos na Cesta Plus" +
                "\n4 - Ver produtos na Cesta Básica" +
                "\n5 - Calcular valor total da cesta básica" +
                "\n6 - Calcular valor total da cesta plus" +
                "\n0 - Voltar ao menu anterior"
    )

    while (true) {
        print("Opção: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                println("Produtos disponíveis:")
                Produto.ProdutosDisponiveis.produtos.forEachIndexed { index, produto ->
                    println("${index } - ${produto.nome}")
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
                    println("${produto.nome} - Preço: R$${produto.preco}")
                }
            }

            4 -> {
                println("Produtos na cesta Básica:")
                cestaBasica.produtos.forEach { produto ->
                    println("${produto.nome} - Preço: R$${produto.preco}")
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
                comprarCestas()
            }

            else -> {
                println("Opção inválida. Escolha uma opção válida.")
            }
        }
    }
}

fun finalizarCompra(){
    do {
        println()
        println("Deseja finalizar sua compra? \n\t1- Sim, quero finalizar \n\t2- Não, quero continuar comprando")
        var choice = readln().toIntOrNull()
        when(choice){
            1-> {
                println("Valor total: R$$totalCarrinho")
                PagamentoView().escolherFormaPagamento()}
            2-> comprarCestas()
            else-> println("Opção inválida")
        }
    }while (choice !in 1..2)

}

