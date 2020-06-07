package ly.eagle.messaging.configuration

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories

@Configuration
@EnableCassandraRepositories
class CassandraConfiguration : AbstractCassandraConfiguration() {

    override fun getKeyspaceName(): String {
        return "example"
    }

    override fun getLocalDataCenter(): String? {
        return "datacenter1"
    }

    override fun getEntityBasePackages(): Array<String> {
        return arrayOf("ly.eagle.messaging.representations")
    }

    override fun getSchemaAction(): SchemaAction {
        return SchemaAction.CREATE_IF_NOT_EXISTS
    }

    override fun getKeyspaceCreations(): MutableList<CreateKeyspaceSpecification> {
        val specification = CreateKeyspaceSpecification.createKeyspace(keyspaceName)
                .ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true)
                .withSimpleReplication()

        return mutableListOf(specification)
    }

    override fun getKeyspaceDrops(): MutableList<DropKeyspaceSpecification> {
        return mutableListOf(DropKeyspaceSpecification.dropKeyspace(keyspaceName))
    }

}
