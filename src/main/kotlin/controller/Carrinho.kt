package controller

class Carrinho {
    private var listaCarrinhoCesta = mutableListOf<Cesta>()
    private var listaCarrinhoProduto = mutableListOf<Cesta>()


    fun adicionarCestaAoCarrinho(cesta : Cesta){
        listaCarrinhoCesta.add(cesta)
    }
    fun editarCestaAoCarrinho(produto : Produto){

    }

}