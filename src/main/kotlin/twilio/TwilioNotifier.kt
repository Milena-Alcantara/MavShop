package twilio


import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber

class TwilioNotifier(private val accountSid: String, private val authToken: String) {
    private val notifier = TwilioNotifier("AC4a2581c23a5a9f6f37abeedacdbad588", "608f3d1040e13560866ba3d784e59c75")

    init {
        Twilio.init(accountSid, authToken)
    }

    fun enviarNotificacao(numeroDestino: String, mensagem: String) {
        val message = Message.creator(
            PhoneNumber(numeroDestino),
            PhoneNumber("+17312514152"),
            mensagem
        ).create()
        val numeroDestino = "34996617947"
        println("Notificação enviada com SID: ${message.sid}")
        notifier.enviarNotificacao(numeroDestino, mensagem)
    }
}
