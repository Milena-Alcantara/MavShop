package controller
class Pagamento {
    companion object{
    private lateinit var numeroCartao: String
    private lateinit var cvv: String
    private var saldo: Double = 0.0

        fun processoPagamentoDinheiro(dinheiro: Double, total: Double) {
            if (dinheiro >= total) {
                var resultado = dinheiro - total
                println("Total da Compra: $total")
                println("Troco: $resultado")
            } else {
                println("Dinheiro insuficiente")
            }
        }
        fun processoPagamentoCartaoCredito(numeroCartao: String, cvv: String, total: Double) {
            require(ValidarPagamento.validaNumeroCartao(numeroCartao)) { "Numero de cartão invalido" }
            require(ValidarPagamento.validarCVV(cvv)) { "Numero Cvv inválido" }
            this.numeroCartao = numeroCartao
            this.cvv = cvv
            println("Total da Compra: $total")
            println("Pagamento realizado com sucesso!")
        }
        fun processoPagamentoCartaoDebito(numeroCartao: String, cvv: String, saldo : Double,total: Double){
            require(ValidarPagamento.validaNumeroCartao(numeroCartao)) { "Numero de cartão invalido" }
            require(ValidarPagamento.validarCVV(cvv)) { "Numero Cvv inválido" }
            this.numeroCartao = numeroCartao
            this.cvv = cvv
            this.saldo = saldo

            if (saldo >= total){
                saldo - total
                println("Total da Compra: $total")
                println("Pagamento realizado com sucesso!")
            }else{
                println("Não foi possível realizar o pagamento.")
            }

        }
    }

}