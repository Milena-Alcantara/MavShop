package controller

import twilio.TwilioNotifier

var phoneClient: String = ""
val mensagemDeEntrega: String = "Compra realizada com sucesso na MAV SHOP, tempo estimado de entrega: 1 (um) dia útil"
private val twilioNotifier = TwilioNotifier(accountSid = "AC6011f071943cc90a826e3ec73e4c906c", authToken = "28b0bc9b92585fcd1008d80408f7adad")

class PagamentoController {
    companion object{
    private lateinit var numeroCartao: String
    private lateinit var cvv: String
    private var saldo: Double = 0.0

        fun processoPagamentoDinheiro(dinheiro: Double, total: Double) {
            if (dinheiro >= total) {
                var resultado = dinheiro - total
                println("Total da Compra: R$ $total".format())
                println("Troco: R$ $resultado".format())
                twilioNotifier.enviarNotificacao(phoneClient, mensagemDeEntrega)
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
            twilioNotifier.enviarNotificacao(phoneClient, mensagemDeEntrega)

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
                twilioNotifier.enviarNotificacao(phoneClient, mensagemDeEntrega)
            }else{
                println("Não foi possível realizar o pagamento.")
            }

        }
    }

}