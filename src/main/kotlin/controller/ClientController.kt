package controller

import model.Client
import model.ClientRepository

class ClientController {
    private val clientRepository = ClientRepository()
    fun addClient(name: String, email: String, password:String, phone: String, cep: String): Boolean {
        val newClient = Client(name, email, password, phone, cep)
        clientRepository.addClient(newClient)
        return true
    }
    fun loginClient(email: String, password: String): Boolean{
        if (email.isBlank() || password.isBlank()){
          return false
        }else{
            clientRepository.loginClient(email,password)
            return true
        }

    }
    fun validateClientData(name: String, email: String, password:String, phone: String, cep: String): Boolean{
        if (name.isNullOrBlank() || email.isNullOrBlank() || password.isNullOrBlank() || phone.isNullOrBlank() || cep.isNullOrBlank()){
            return false
        }else return true
    }

}
