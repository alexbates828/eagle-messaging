package ly.eagle.messaging.representations

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.sql.Timestamp
import java.time.Instant

@Table
data class Message (
        @PrimaryKeyColumn(type=PrimaryKeyType.PARTITIONED) val senderId: Long,
        val recipientId: Long,
        val body: String = "",
        val timestamp: Timestamp = Timestamp.from(Instant.now())
)