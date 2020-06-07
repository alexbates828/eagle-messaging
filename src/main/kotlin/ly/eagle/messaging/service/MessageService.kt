package ly.eagle.messaging.service

import ly.eagle.messaging.dao.CassandraDao
import ly.eagle.messaging.representations.Message
import org.springframework.stereotype.Component
import java.util.*

@Component
class MessageService(
        val cassandraDao: CassandraDao
) {
    fun postMessage(message: Message) {
        cassandraDao.save(message)
    }

    fun getMessagesSentToUser(userId: Long): List<Message> {
        TODO()
    }

    fun findOneBySenderId(userId: Long): Message {
        return cassandraDao.findOneOrNoneBySenderId(userId)
    }
}