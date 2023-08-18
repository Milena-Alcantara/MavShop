package controller

class ValidarPagamento {
    companion object {
        fun validarCVV(cvv: String): Boolean {
            if (cvv.length != 3) {
                return false
            }
            return (!cvv.matches("\\d+".toRegex()))
        }

        fun validaNumeroCartao(numeroCartao: String): Boolean {
            if (numeroCartao.length != 16) {
                return false
            }
            if (!numeroCartao.matches("\\d+".toRegex())) {
                return false
            }
            var sum = 0
            var doubleDigit = false
            for (i in numeroCartao.length - 1 downTo 0) {
                var digit = Character.getNumericValue(numeroCartao[i])
                if (doubleDigit) {
                    digit *= 2
                    if (digit > 9) {
                        digit = digit % 10 + 1
                    }
                }
                sum += digit
                doubleDigit = !doubleDigit
            }
            return sum % 10 == 0
        }
    }
}
