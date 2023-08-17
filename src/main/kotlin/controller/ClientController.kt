package controller

import model.Client
import model.ClientRepository
import twilio.TwilioNotifier

class ClientController {
    companion object{
        private val clientRepository = ClientRepository()
    }
    private val twilioNotifier = TwilioNotifier(accountSid = "AC6011f071943cc90a826e3ec73e4c906c", authToken = "28b0bc9b92585fcd1008d80408f7adad")

    fun addClient(name: String, email: String, password:String, phone: String, cep: String): Boolean {
        val newClient = Client(name, email, password, phone, cep)
        phoneClient = phone
        clientRepository.addClient(newClient)

        val mensagem = "Bem-vindo, $name! Seu cadastro foi realizado com sucesso."
        twilioNotifier.enviarNotificacao(phone, mensagem)
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
