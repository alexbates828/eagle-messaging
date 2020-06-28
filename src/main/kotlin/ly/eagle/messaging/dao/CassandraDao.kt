package ly.eagle.messaging.dao

import ly.eagle.messaging.representations.Message
import ly.eagle.messaging.representations.MessageKey
import org.springframework.data.cassandra.repository.CassandraRepository

interface CassandraDao : CassandraRepository<Message, MessageKey> {
    fun findAllByMessageKeySenderIdAndMessageKeyRecipientId(senderId: Long, recipientId: Long): List<Message>
}