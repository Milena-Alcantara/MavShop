package useCase

import controller.CarrinhoController
import model.CestaBasica
import model.CestaPlus
import model.NotaFiscal
import view.finalizarCompra
import view.totalCarrinho

class ComprasUseCase {
    val carrinhoController = CarrinhoController()
    val notaFiscal =  NotaFiscal()

    fun comprarCestaBasica(cestaBasica:CestaBasica){
        carrinhoController.adicionarCestaBasicaAoCarrinho(cestaBasica)
        totalCarrinho += cestaBasica.calcularValorTotalBasica()
        println("Valor total até o momento: R$${cestaBasica.calcularValorTotalBasica()}")
        finalizarCompra()
        notaFiscal.gerarNotaFiscalCestaBasica(cestaBasica)

    }

    fun comprarCestaPlus(cestaPlus: CestaPlus){
        carrinhoController.adicionarCestaPlusAoCarrinho(cestaPlus)
        totalCarrinho+=cestaPlus.calcularValorTotalPlus()
        println("Valor total até o momento: R$${cestaPlus.calcularValorTotalPlus()}")
        finalizarCompra()
        notaFiscal.gerarNotaFiscalCestaplus(cestaPlus)
    }
}