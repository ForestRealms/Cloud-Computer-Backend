package cloud.computer.backend.CloudComputerBackend;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.CqlSessionBuilder;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.openstack.OSFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.cassandra.config.CqlSessionFactoryBean;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.stereotype.Component;

@Component
public class Initializer {

    /**
     * 自动注入管理员用户ID
     */
    @Value("${openstack.admin-user-id}")
    public String userid;

    /**
     * 自动注入管理员用户密码
     */
    @Value("${openstack.admin-user-password}")
    public String password;

    /**
     * 自动注入Keystone的URL
     */
    @Value("${openstack.keystone-url}")
    public String KEYSTONE_URL;

    /**
     * 自动注入管理员用户所在Project的名称
     */
    @Value("${openstack.admin-project}")
    public String ADMIN_PROJECT;

    /**
     * 自动注入管理员用户所在域的名称
     */
    @Value("${openstack.admin-domain}")
    public String ADMIN_DOMAIN;

    public Initializer() {
    }

    public boolean initialize(){
        try {
            CloudComputerBackendApplication.client = OSFactory.builderV3()
                    .endpoint(KEYSTONE_URL)
                    .credentials(userid, password)
                    .scopeToProject(Identifier.byName(ADMIN_PROJECT), Identifier.byName(ADMIN_DOMAIN))
                    .authenticate();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    @Bean(name = "client")
    public OSClient.OSClientV3 getClient(){
        return OSFactory.builderV3()
                .endpoint(KEYSTONE_URL)
                .credentials(userid, password)
                .scopeToProject(Identifier.byName(ADMIN_PROJECT), Identifier.byName(ADMIN_DOMAIN))
                .authenticate();

    }






}
