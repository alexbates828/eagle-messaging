package ly.eagle.messaging.controller

import ly.eagle.messaging.representations.Message
import ly.eagle.messaging.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("messages")
class MessageController(
        val messageService: MessageService
) {

    @GetMapping
    fun healthCheck(): String {
        return "Hello world!"
    }

    @PostMapping("/send")
    @ResponseStatus(HttpStatus.OK)
    fun postMessage(@RequestBody message: Message) {
        messageService.postMessage(message)
    }

//    @GetMapping("/{userId}")
//    fun getMessagesSentByUser(@PathVariable userId: Long): List<Message> {
//        return messageService.getMessagesSentByUser(userId)
//    }

    @GetMapping("/{userId}")
    fun getOneMessageSentByUser(@PathVariable userId: Long): Message {
        return messageService.findOneBySenderId(userId)
    }

}
