package controller

import model.Cesta
import model.Produto

class CarrinhoController {
    private var listaCarrinhoCesta = mutableListOf<Cesta>()
    private var listaCarrinhoProduto = mutableListOf<Cesta>()

    fun adicionarCestaAoCarrinho(cesta: Cesta) {
        listaCarrinhoCesta.add(cesta)
    }
}