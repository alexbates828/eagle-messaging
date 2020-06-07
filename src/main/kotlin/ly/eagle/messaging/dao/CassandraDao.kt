package ly.eagle.messaging.dao

import ly.eagle.messaging.representations.Message
import org.springframework.data.cassandra.repository.CassandraRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import java.util.*

interface CassandraDao : CassandraRepository<Message, Long> {
    fun findOneOrNoneBySenderId(senderId: Long): Message
}