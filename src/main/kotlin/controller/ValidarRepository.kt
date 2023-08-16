package controller

class ValidarRepository {
    companion object {
        fun validarNome(nome: String): Boolean {
        val regex = Regex("^[a-zA-Z\\s]+\$")
        return regex.matches(nome)
    }
        fun validarEmail(email: String): Boolean {
            while (!email.contains("@") && !email.contains(".")) {
                println("Digite o email novamente, certifique-se que o email contenha @ e .")
                return false
            }
            return true
        }

        fun validarSenha(password: String) : Boolean {
            return password.length >= 8
        }

        fun validarTelefone(telefone: String): Boolean {
            val regex = Regex("[0-9]+")
            return regex.matches(telefone) && telefone.length >= 8
        }

        fun validarCEP(cep: String): Boolean {
            val cepNumeros = cep.replace("[^0-9]".toRegex(), "")
            return cepNumeros.length == 8
        }

    }
}
