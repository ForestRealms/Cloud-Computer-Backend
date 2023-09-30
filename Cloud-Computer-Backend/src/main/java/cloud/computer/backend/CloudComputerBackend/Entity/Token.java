package cloud.computer.backend.CloudComputerBackend.Entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Table
@Getter
@Setter
public class Token {

    @Column("value")
    private String value;

    @Column("expired_at")
    private Date expiration;
}
