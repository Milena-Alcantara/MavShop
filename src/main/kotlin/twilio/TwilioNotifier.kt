package twilio


import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber

class TwilioNotifier(private val accountSid: String, private val authToken: String) {

    init {
        Twilio.init(accountSid, authToken)
    }

    fun enviarNotificacao(numeroDestino: String, mensagem: String) {
        val message = Message.creator(
            PhoneNumber(numeroDestino),
            PhoneNumber("+17312514152"),
            mensagem
        ).create()

        println("Notificação enviada com SID: ${message.sid}")
    }
}
