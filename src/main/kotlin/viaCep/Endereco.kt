package viaCep

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

data class Endereco(
    val logradouro: String,
    val bairro: String,
    val localidade: String,
    val uf: String
)

fun mostrarEndereco(cep: String){
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://viacep.com.br/ws/$cep/json/")
        .build()

    val response = client.newCall(request).execute()
    val responseBody = response.body?.string()

    val gson = Gson()
    val endereco = gson.fromJson(responseBody, Endereco::class.java)

    println("Logradouro: ${endereco.logradouro}")
    println("Bairro: ${endereco.bairro}")
    println("Cidade: ${endereco.localidade}")
    println("Estado: ${endereco.uf}")
}