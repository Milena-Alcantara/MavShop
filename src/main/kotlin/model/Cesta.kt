package model

import java.lang.IllegalArgumentException

open class Cesta {
    var produtos: MutableList<Produto> = mutableListOf()
}

class CestaBasica : Cesta(){
    init {
        val arroz = Produto("Arroz Tipo 1 - 5kg", 12.00, 1)
        val feijao = Produto("Feijão Carioquinha - 1kg", 6.99, 2)
        val acucarRefinado = Produto("Açucar refinado - 1kg", 10.00, 2)
        val salRefinado = Produto("Sal Refinado - 1kg", 6.00, 1)
        val oleo = Produto("Óleo de soja - 900ml", 4.90, 2)
        val cafe = Produto("Café - 250g", 11.98, 1)
        val macarrao = Produto("Macarrão Espaguete - 500g", 3.80, 1)
        val farinhaDeTrigo = Produto("Farinha de Trigo - 1kg", 7.00, 1)
        val milhoPipoca = Produto("Milho de Pipoca - 500g", 3.99, 1)
        val biscoitoMaizena = Produto("Biscoito Maizena - 200g", 4.00, 2)
        val molhoPronto = Produto("Molho Fugini - 130g", 2.69, 1)

        produtos.add(arroz)
        produtos.add(feijao)
        produtos.add(acucarRefinado)
        produtos.add(salRefinado)
        produtos.add(oleo)
        produtos.add(cafe)
        produtos.add(macarrao)
        produtos.add(farinhaDeTrigo)
        produtos.add(milhoPipoca)
        produtos.add(biscoitoMaizena)
        produtos.add(molhoPronto)
    }

    fun calcularValorTotalBasica(): Double {
        var valorTotal = 0.0
        for (produto in produtos) {
            valorTotal += produto.preco
        }
        return valorTotal
    }

}

class CestaPlus : Cesta(){

    init {
        val arroz = Produto("Arroz Tipo 1 - 5kg", 12.00, 1)
        val feijao = Produto("Feijão Carioquinha - 1kg", 6.99, 2)
        val acucarRefinado = Produto("Açucar refinado - 1kg", 10.00, 2)
        val salRefinado = Produto("Sal Refinado - 1kg", 6.00, 1)
        val oleo = Produto("Óleo de soja - 900ml", 4.90, 2)
        val cafe = Produto("Café - 250g", 11.98, 1)
        val macarrao = Produto("Macarrão Espaguete - 500g", 3.80, 1)
        val farinhaDeTrigo = Produto("Farinha de Trigo - 1kg", 7.00, 1)
        val milhoPipoca = Produto("Milho de Pipoca - 500g", 3.99, 1)
        val biscoitoMaizena = Produto("Biscoito Maizena - 200g", 4.00, 2)
        val molhoPronto = Produto("Molho Fugini - 130g", 2.69, 1)
        val papelHigienico = Produto("Papel Higiênico - 24 rolos", 35.95, 2)
        val achocolatado = Produto("Achocolatado em pó - 400g", 5.00, 2)
        val cremeDeLeite = Produto("Creme de leite - 1 lata", 4.00, 2)

        produtos.add(arroz)
        produtos.add(feijao)
        produtos.add(acucarRefinado)
        produtos.add(salRefinado)
        produtos.add(oleo)
        produtos.add(cafe)
        produtos.add(macarrao)
        produtos.add(farinhaDeTrigo)
        produtos.add(milhoPipoca)
        produtos.add(biscoitoMaizena)
        produtos.add(molhoPronto)
        produtos.add(papelHigienico)
        produtos.add(achocolatado)
        produtos.add(cremeDeLeite)
    }
    fun adicionarProduto(produto: Produto){
        produtos.add(produto)
    }
    fun removerProduto(produto: Produto){
        produtos.remove(produto)
    }
    fun editarCesta(opcao: Int, produto: Produto){
        when(opcao){
            1 -> adicionarProduto(produto)
            2 -> removerProduto(produto)
            else -> throw IllegalArgumentException("Opção inválida")
        }
    }

    fun calcularValorTotalPlus(): Double {
        var valorTotal = 0.0
        for (produto in produtos) {
            valorTotal += produto.preco
        }
        return valorTotal
    }
}