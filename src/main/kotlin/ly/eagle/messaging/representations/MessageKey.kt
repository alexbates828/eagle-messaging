package ly.eagle.messaging.representations

import org.springframework.data.cassandra.core.cql.Ordering
import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import java.io.Serializable
import java.sql.Timestamp
import java.time.Instant

@PrimaryKeyClass
class MessageKey(
        @PrimaryKeyColumn(name="senderId", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
        val senderId: Long,
        @PrimaryKeyColumn(name="recipientId", ordinal = 1, type = PrimaryKeyType.PARTITIONED)
        val recipientId: Long,
        @PrimaryKeyColumn(name = "timestamp", ordinal = 2, type = PrimaryKeyType.CLUSTERED, ordering = Ordering.DESCENDING)
        val timestamp: Timestamp = Timestamp.from(Instant.now())
) : Serializable