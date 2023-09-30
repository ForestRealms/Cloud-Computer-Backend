package cloud.computer.backend.CloudComputerBackend.DataAccess;

import cloud.computer.backend.CloudComputerBackend.Entity.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TokenDataAccess {
    private CassandraTemplate cassandraTemplate;

    @Autowired
    private void setCassandraTemplate(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public void addToken(Token token){
        this.cassandraTemplate.insert(token);
    }

    public void removeToken(Token token){
        this.cassandraTemplate.delete(token);
    }

    public List<Token> getTokens(){
        return this.cassandraTemplate.select("select * from `tokens`", Token.class);
    }


}
