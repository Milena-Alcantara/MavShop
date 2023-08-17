package twilio

import com.twilio.Twilio
import com.twilio.rest.api.v2010.account.Message
import com.twilio.type.PhoneNumber

class TwilioNotifier(private val accountSid: String, private val authToken: String) {

    init {
        Twilio.init(accountSid, authToken)
    }

    fun enviarNotificacao(destino: String, mensagem: String) {
        val numeroDestino = PhoneNumber(destino)

        val remetente = PhoneNumber("+18149294860")

        val message = Message.creator(numeroDestino, remetente, mensagem).create()

        println("SID da mensagem: ${message.sid}")
    }
}

