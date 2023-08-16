package view

import controller.ClientController

class ClientService {
    private val clientController = ClientController()

    fun register(){
            println("Informe seu nome: ")
            var name = readln()
            println("Informe seu e-mail: ")
            var email =  readln()
            println("Digite uma senha de no mínimo 8 caracteres entre números, letras e caracteres especiais: ")
            var password = readln()
            println("Digite seu telefone: ")
            var phone = readln()
            println("Digite seu CEP: ")
            var cep = readln()
         if (!clientController.validateClientData(name, email, password, phone, cep)){
             println("Dados inválidos, digite novamente.")
         }else
        clientController.addClient(name, email, password, phone, cep)
        println("Cadastro realizado com sucesso!")
    }

    fun login(){
        println("Informe seu e-mail: ")
        var email = readln()
        println("Informe sua senha: ")
        var password = readln()
        if (clientController.loginClient(email, password)){
            println("Cliente logado com sucesso!")
        }else{
            println("E-mail ou senha não cadastrados em nosso sistema.")
        }
    }
}