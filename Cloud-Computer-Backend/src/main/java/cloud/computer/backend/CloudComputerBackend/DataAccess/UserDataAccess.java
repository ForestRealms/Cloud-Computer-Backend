package cloud.computer.backend.CloudComputerBackend.DataAccess;

import cloud.computer.backend.CloudComputerBackend.Entity.User;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;
import com.datastax.oss.driver.api.core.cql.StatementBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.math.BigInteger;
import java.util.List;

@Repository
public class UserDataAccess {

    private CassandraTemplate cassandraTemplate;

    @Autowired
    private void setCassandraTemplate(CassandraTemplate cassandraTemplate) {
        this.cassandraTemplate = cassandraTemplate;
    }

    public List<User> getUsers(){
        return this.cassandraTemplate.select("select * from users;", User.class);
    }

    @Nullable
    public User getUserByUsername(String username){
        return this.cassandraTemplate.selectOne("select * from users where username='" + username + "' allow filtering;", User.class);
    }

    public void addUser(User user){
        this.cassandraTemplate.insert(user);
    }

    public void removeUser(User user){
        this.cassandraTemplate.delete(user);
    }

    public boolean userIsExist(String username){
        return getUserByUsername(username) == null;
    }

    public BigInteger getMaximumUserId(){
        BigInteger max = BigInteger.ZERO;
        for (User user : getUsers()) {
            if(user.getId().compareTo(max) > 0) max = user.getId();
        }
        return max;
    }

    public void updateUser(User user){
        this.cassandraTemplate.update(user);

    }
}
