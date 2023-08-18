package controller

import model.CestaBasica
import model.CestaPlus

class CarrinhoController : Pagamento(){
        private var listaCarrinhoCestaBasica = mutableListOf<CestaBasica>()
        private var listaCarrinhoCestaPlus = mutableListOf<CestaPlus>()

        fun adicionarCestaBasicaAoCarrinho(cesta : CestaBasica){
            listaCarrinhoCestaBasica.add(cesta)
        }
        fun adicionarCestaPlusAoCarrinho(cesta : CestaPlus){
            listaCarrinhoCestaPlus.add(cesta)
        }
        fun calcularTotalCestaBásica() : Double{
            if (listaCarrinhoCestaBasica.isNotEmpty()) {
                for (cesta in listaCarrinhoCestaBasica) {
                    for (produto in cesta.produtos) {
                       total += produto.preco
                    }
                }
            }else{ println("Você não tem itens adicionado") }
            return total
        }
        fun calcularTotalCestaPlus() : Double {
          if (listaCarrinhoCestaPlus.isNotEmpty()) {
            for (cesta in listaCarrinhoCestaPlus) {
                for (produto in cesta.produtos) {
                    total += produto.preco
                }
            }
          } else { println("Você não tem itens adicionado") }
          return total
        }

}
