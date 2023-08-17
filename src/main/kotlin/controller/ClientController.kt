package controller

import model.Client
import model.ClientRepository
import twilio.TwilioNotifier


class ClientController {
    companion object{
        private val clientRepository = ClientRepository()
    }
    private val twilioNotifier = TwilioNotifier(accountSid = "AC4a2581c23a5a9f6f37abeedacdbad588", authToken = "608f3d1040e13560866ba3d784e59c75")

    fun addClient(name: String, email: String, password:String, phone: String, cep: String): Boolean {
        val newClient = Client(name, email, password, phone, cep)
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
