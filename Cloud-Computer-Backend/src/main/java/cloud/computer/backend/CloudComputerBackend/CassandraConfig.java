package cloud.computer.backend.CloudComputerBackend;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.cassandra.keyspace-name}")
    private String keyspace;

    @Value("${spring.cassandra.contact-points}")
    private String contactPoints;

    @Value("${spring.cassandra.port}")
    private int port;

    @Value("${spring.cassandra.username}")
    private String username;

    @Value("${spring.cassandra.password}")
    private String password;


    @Override
    protected String getKeyspaceName() {
        return this.keyspace;
    }

    @Override
    protected String getContactPoints() {
        return this.contactPoints;
    }

    @Override
    protected int getPort() {
        return this.port;
    }

    @Override
    public CqlSessionFactoryBean cassandraSession() {
        CqlSessionFactoryBean bean = super.cassandraSession();
        bean.setUsername(this.username);
        bean.setPassword(this.password);
        bean.setPort(this.port);
        bean.setContactPoints(this.contactPoints);
        bean.setKeyspaceName(this.keyspace);
        return bean;
    }


}
