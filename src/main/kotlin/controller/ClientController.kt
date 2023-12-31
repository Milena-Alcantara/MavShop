package controller

import model.Client
import model.ClientRepository
import twilio.TwilioNotifier
import viaCep.Endereco
import viaCep.mostrarEndereco

class ClientController {
    companion object{
        private val clientRepository = ClientRepository()
    }

    private val twilioNotifier = TwilioNotifier(accountSid = "ACabb577250b257d0653aaafff9fdd1348", authToken = "3287f03a99f8a22d60c35acf25a16d2b")

    fun addClient(name: String, email: String, password:String, phone: String, cep: String): Boolean {
        val newClient = Client(name, email, password, phone, cep)
        phoneClient = phone
        clientRepository.addClient(newClient)

        val mensagem = "Bem-vindo, $name! Seu cadastro foi realizado com sucesso."
        twilioNotifier.enviarNotificacao(phone, mensagem)

        mostrarEndereco(cep)
        return true
    }
    fun loginClient(email: String, password: String): Boolean{
        if (email.isBlank() || password.isBlank()){
          return false
        }else{
            return clientRepository.loginClient(email,password)
        }

    }
    fun validateClientData(name: String, email: String, password:String, phone: String, cep: String): Boolean{
        if (name.isNullOrBlank() || email.isNullOrBlank() || password.isNullOrBlank() || phone.isNullOrBlank() || cep.isNullOrBlank()){
            return false
        }else return true
    }

}
