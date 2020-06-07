package ly.eagle.messaging.representations

import org.springframework.data.cassandra.core.cql.PrimaryKeyType
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn
import org.springframework.data.cassandra.core.mapping.Table
import java.sql.Timestamp
import java.time.Instant

@Table
data class Message (
        @PrimaryKey val messageKey: MessageKey,
        val body: String = ""
)