package twilio

fun main() {
    val notifier = TwilioNotifier("AC4a2581c23a5a9f6f37abeedacdbad588", "608f3d1040e13560866ba3d784e59c75")

    val numeroDestino = ""
    val mensagem = "Sua compra foi realizada com sucesso!"

    notifier.enviarNotificacao(numeroDestino, mensagem)
}
