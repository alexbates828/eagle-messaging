package ly.eagle.messaging.controller

import org.springframework.stereotype.Component
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import javax.websocket.server.PathParam

@RestController
@RequestMapping("messages")
class MessageController {

    @GetMapping
    fun healthCheck(): String {
        return "Hello world!"
    }

}
