package cloud.computer.backend.CloudComputerBackend.Entity;


import com.sun.jdi.IntegerType;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.math.BigInteger;
import java.util.List;


@Table("users")
public class User {

    @PrimaryKey("userid")
    private BigInteger id;

    @Column("username")
    private String username;

    @Column("password")
    private String password;

    @Column("instances")
    private List<String> instances;

    @Column("token")
    private String tokenValue;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getInstances() {
        return instances;
    }

    public void setInstances(List<String> instances) {
        this.instances = instances;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
