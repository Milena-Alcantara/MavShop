package view

import controller.Pagamento

class PagamentoView : Pagamento(){
    fun cadastrarCartãoDebito(){
        println("Digite o numero do cartão")
        var numeroCartão = readln()
        println("Digite o cvv do cartão")
        var cvv = readln()
        println("Digite o saldo do cartão")
        var valor = readln().toDoubleOrNull()

        if (valor != null) {
            Pagamento.processoPagamentoCartaoDebito(numeroCartão,cvv,valor)
        }
    }
    fun cadastrarCartaoCredito(){
        println("Digite o numero do cartão")
        var numeroCartão = readln()
        println("Digite o cvv cartão")
        var cvv = readln()
        Pagamento.processoPagamentoCartaoCredito(numeroCartão,cvv)
    }
    fun inserirDinheiro(){
        println("Digite o valor do pagamento")
        var valor = readln().toDoubleOrNull()
        if (valor != null) {
            Pagamento.processoPagamentoDinheiro(valor)
        }else {
            println("Pagamento inválido")
        }

    }
    fun escolherFormaPagamento(){
        println("1 - Dinheiro")
        println("2 - Cartão de débito")
        println("3 - Cartão de crédito")
        var input = readln().toIntOrNull()
        when (input){
            1 -> inserirDinheiro()
            2 -> cadastrarCartãoDebito()
            3 -> cadastrarCartaoCredito()
        }
    }
}
