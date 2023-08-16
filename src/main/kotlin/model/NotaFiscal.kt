package model

class NotaFiscal {
    fun gerarNotaFiscalCestaBasica(cestaBasica: CestaBasica): String {
        val valorTotal = cestaBasica.calcularValorTotalBasica()

        val builder = StringBuilder()
        builder.append(
            "Nota Fiscal\n" +
                    "==============\n" +
                    "Itens da Cesta:\n"
        )
        for (produto in cestaBasica.produtos) {
            builder.append("${produto.nome} - ${produto.preco}\n")
        }
        builder.append(
            "==============\n" +
                    "Valor Total: $valorTotal\n"
        )

        return builder.toString()
    }

    fun gerarNotaFiscalCestaplus(cestaPlus: CestaPlus): String {
        val valorTotal = cestaPlus.calcularValorTotalPlus()

        val builder = StringBuilder()
        builder.append(
            "Nota Fiscal\n" +
                    "==============\n" +
                    "Itens da Cesta:\n"
        )
        for (produto in cestaPlus.produtos) {
            builder.append("${produto.nome} - ${produto.preco}\n")
        }
        builder.append(
            "==============\n" +
                    "Valor Total: $valorTotal\n"
        )

        return builder.toString()
    }

}


