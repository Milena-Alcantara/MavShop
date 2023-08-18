package useCase

import controller.ClientController
import controller.ValidarRepository

class ClienteUseCase {
    private val clientController = ClientController()
    lateinit var name : String
    lateinit var email : String
    lateinit var password : String
    lateinit var phone: String
    lateinit var cep: String

    fun register():Boolean {
        while (true){
        println("Informe seu nome: ")
        name = readln()
       while (!ValidarRepository.validarNome(name)) {
           println("Nome inválido, digite novamente")
           name = readln()
       }

        println("Informe seu e-mail: ")
         email = readln()
        while (!ValidarRepository.validarEmail(email)) {
            println("Email inválido, digite novamentes")
            email = readln()
        }

        println("Digite uma senha de no mínimo 8 caracteres entre números, letras e caracteres especiais: ")
            password = readln()
        while(!ValidarRepository.validarSenha(password)) {
            println("Senha inválida, a senha deve conter no mínimo 8 caracteres")
            password = readln()
        }

        println("Digite seu telefone: ")
         phone = readln()
        while(!ValidarRepository.validarTelefone(phone)) {
            println("Digite um numero válido")
            phone = readln()
        }

        println("Digite seu CEP: ")
         cep = readln()
        while (!ValidarRepository.validarCEP(cep)) {
            println("Digite um cep válido")
            cep = readln()
        }

        if (!clientController.validateClientData(name, email, password, phone, cep)) {
            println("Dados inválidos, digite novamente.")
            register()
        } else
            clientController.addClient(name, email, password, phone, cep)
        println("Cadastro realizado com sucesso!")
        return true
        }
    }

        fun login() {
            println("Informe seu e-mail: ")
            var email = readln()
            println("Informe sua senha: ")
            var password = readln()
            if (clientController.loginClient(email, password)) {
                println("Cliente logado com sucesso!")
            } else {
                println("E-mail ou senha não cadastrados em nosso sistema.")
                println("Efetue seu cadastro: ")
                register()
            }
        }
    }