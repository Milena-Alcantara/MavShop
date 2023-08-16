package controller
class Pagamento {
    private var  total = 0.0
    fun processarPagamentoDinheiro( dinheiro : Double){
        if (dinheiro > total){
        var resultado = dinheiro - total
            println("Troco: $resultado")
        } else{
            println("Dinheiro insuficiente")
        }
    }  fun processarPagamentoCartão( entrada: Int){
        when (entrada){
            1, 2, 3 -> println("Compra finalizada")
        }
    }

}