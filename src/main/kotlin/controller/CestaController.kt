package controller

import model.Cesta
import model.CestaBasica
import model.CestaPlus
import model.Produto


class CestaController {
    private val cestaBasica: CestaBasica = CestaBasica()
    private val cestaPlus: CestaPlus = CestaPlus()

    fun getCestaBasica(): Cesta {
        return cestaBasica
    }

    fun getCestaPlus(): CestaPlus {
        return cestaPlus
    }

    fun editarCesta(cesta: CestaPlus, opcao: Int, produto: Produto) {
        cesta.editarCesta(opcao, produto)
    }
}


