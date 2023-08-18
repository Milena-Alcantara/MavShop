package view

import controller.CestaController
import model.CestaBasica
import model.CestaPlus
import useCase.ClienteUseCase
import useCase.ComprasUseCase
import useCase.PersonalizarUseCase
import kotlin.system.exitProcess

val clientService = ClienteUseCase()
var totalCarrinho = 0.0
fun main() {
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
    val comprasUseCase = ComprasUseCase()
    do {
        println("Informe a ação desejada: " +
                "\n\t1- Comprar Cesta Básica\n\t2- Comprar Cesta Plus\n\t3- Personalizar\n\t0- Sair")

        var choice = readln().toIntOrNull()
        when(choice){
            1-> {
                val cestaBasica = CestaBasica()
                comprasUseCase.comprarCestaBasica(cestaBasica)
            }
            2-> {
                val cestaPlus = CestaPlus()
                comprasUseCase.comprarCestaPlus(cestaPlus)
            }
            3-> menuPersonalizarCestas()
            0-> {println("Saindo do sistema")
                exitProcess(0)
                return}
            else-> println("Opção inválida")
        }
    }while (choice !in 0..3)
}

fun menuPersonalizarCestas(){
    val cestaController = CestaController()
    val personalizarUseCase = PersonalizarUseCase()
    val cestaPlus = cestaController.getCestaPlus()

    while (true) {
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
        print("Opção: ")

        when (readlnOrNull()?.toIntOrNull()) {
            1 -> {
                personalizarUseCase.mostrarProdutosDisponiveis()
                print("Escolha o número do produto a adicionar: ")
                val produtoIndex = readlnOrNull()?.toIntOrNull()
                personalizarUseCase.adicionarProdutoCestaPlus(produtoIndex)
            }
            2 -> {
                personalizarUseCase.mostrarProdutosPlus()
                print("Escolha o número do produto a remover: ")
                val produtoIndex = readlnOrNull()?.toIntOrNull()
                personalizarUseCase.removerProdutoCestaPlus(produtoIndex)
            }
            3 ->personalizarUseCase.mostrarProdutosPlus()
            4 ->personalizarUseCase.mostrarProdutosCestaBasico()
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

