package cloud.computer.backend.CloudComputerBackend.DataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TokenDataAccess {
    private CassandraTemplate cassandraTemplate;

    @Autowired
    private void setCassandraTemplate(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public
}
