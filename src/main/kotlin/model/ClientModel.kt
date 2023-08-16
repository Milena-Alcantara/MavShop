package model

data class Client(var name: String, var email: String,var password:String, var phone: String, var cep: String) {
}
class ClientRepository{
    private val clients = mutableListOf<Client>()
    fun addClient(client: Client): MutableList<Client> {
        clients.add(client)
        return clients
    }

    fun loginClient(email: String, password: String): Client? {
        return clients.firstOrNull { it.email == email && it.password == password}
    }
}
