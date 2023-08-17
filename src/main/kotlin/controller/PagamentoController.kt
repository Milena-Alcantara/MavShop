package controller

import twilio.TwilioNotifier
private val mensagem = "Compra realizado com sucesso na MAV SHOP, prazo de entrega no seu endereço: 1 dia útil"
 var phoneClient = ""
class PagamentoController {
    companion object {
        private lateinit var numeroCartao: String
        private lateinit var cvv: String
        private var saldo: Double = 0.0
        private val twilioNotifier = TwilioNotifier(
            accountSid = "ACabb577250b257d0653aaafff9fdd1348",
            authToken = "3287f03a99f8a22d60c35acf25a16d2b"
        )



        fun processoPagamentoDinheiro(dinheiro: Double, total: Double) {
            if (dinheiro >= total) {
                var resultado = dinheiro - total
                println("Total da Compra: R$ $total".format())
                println("Troco: R$ $resultado".format())
                twilioNotifier.enviarNotificacao(phoneClient, mensagem)
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
            twilioNotifier.enviarNotificacao(phoneClient, mensagem)

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
                twilioNotifier.enviarNotificacao(phoneClient, mensagem)
            }else{
                println("Não foi possível realizar o pagamento.")
            }

        }
    }

}