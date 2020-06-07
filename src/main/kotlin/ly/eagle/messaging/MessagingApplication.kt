package ly.eagle.messaging

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableAutoConfiguration
class MessagingApplication

fun main(args: Array<String>) {
	runApplication<MessagingApplication>(*args)
}
