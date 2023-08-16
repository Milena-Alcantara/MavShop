package model

data class Client(var name: String, var email: String,var password:String, var phone: String, var cep: String) {
}
class ClientRepository{
    companion object{
        private val clients = mutableListOf<Client>()
    }

    fun addClient(client: Client): MutableList<Client> {
        clients.add(client)
        return clients
    }

    fun loginClient(email: String, password: String): Boolean {
       for (client in clients){
           if (client.email == email && client.password == password){
               return true
           }
       }
        return false
    }
}
