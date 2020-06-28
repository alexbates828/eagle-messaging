package ly.eagle.messaging.controller

import ly.eagle.messaging.representations.Message
import ly.eagle.messaging.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

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

    @GetMapping("/{userId1}/{userId2}")
    fun getAllMessagesBetween(@PathVariable userId1: Long, @PathVariable userId2: Long): List<Message> {
        return messageService.getAllMessagesBetween(userId1, userId2)
    }

}
