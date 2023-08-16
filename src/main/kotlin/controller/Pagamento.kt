package controller
class Pagamento {
    companion object{
    private var  total = 0.0
    private lateinit var numeroCartao: String
    private lateinit var cvv: String
    private var saldo: Double = 0.0

        fun processoPagamentoDinheiro(dinheiro: Double) {
            if (dinheiro >= total) {
                var resultado = dinheiro - total
                println("Troco: $resultado")
            } else {
                println("Dinheiro insuficiente")
            }
        }
        fun processoPagamentoCartaoCredito(numeroCartao: String, cvv: String) {
            require(ValidarPagamento.validaNumeroCartao(numeroCartao)) { "Numero de cartão invalido" }
            require(ValidarPagamento.validarCVV(cvv)) { "Numero Cvv inválido" }
            this.numeroCartao = numeroCartao
            this.cvv = cvv
        }
        fun processoPagamentoCartaoDebito(numeroCartao: String, cvv: String, saldo : Double) : Boolean{
            require(ValidarPagamento.validaNumeroCartao(numeroCartao)) { "Numero de cartão invalido" }
            require(ValidarPagamento.validarCVV(cvv)) { "Numero Cvv inválido" }
            this.numeroCartao = numeroCartao
            this.cvv = cvv
            this.saldo = saldo

            if (saldo >= total){
                saldo - total
                return true
            }
            return false
        }
    }

}