package view

val clientService = ClientService()
fun main(args: Array<String>) {
    menuClient()
}

fun menuClient(){
    do {
        println("Informe a opção desejada: " +
                "\n\t 1- Efetuar cadastro\n\t 2- Logar ")
        var choice = readln().toIntOrNull() ?: 0

        when(choice){
            1 -> clientService.register()
            2-> clientService.login()
            else-> println("Opção inválida")
        }
        println()
    }while (choice !in 1..2)

}