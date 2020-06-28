package ly.eagle.messaging.service

import ly.eagle.messaging.dao.CassandraDao
import ly.eagle.messaging.representations.Message
import org.springframework.stereotype.Component

@Component
class MessageService(
        val cassandraDao: CassandraDao
) {
    fun postMessage(message: Message) {
        cassandraDao.save(message)
    }

    fun getMessagesSentFromTo(userId1: Long, userId2: Long): List<Message> {
        return cassandraDao.findAllByMessageKeySenderIdAndMessageKeyRecipientId(userId1, userId2)
    }

    fun getAllMessagesBetween(userId1: Long, userId2: Long): List<Message> {
        return (getMessagesSentFromTo(userId1, userId2) + getMessagesSentFromTo(userId2, userId1)).sortedBy {
            it.messageKey.timestamp
        }
    }
}