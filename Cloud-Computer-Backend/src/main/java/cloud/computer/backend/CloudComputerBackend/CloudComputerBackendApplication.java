package cloud.computer.backend.CloudComputerBackend;

import org.openstack4j.api.OSClient;
import org.openstack4j.model.common.Identifier;
import org.openstack4j.openstack.OSFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.cassandra.CassandraAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication(exclude = {CassandraAutoConfiguration.class})
public class CloudComputerBackendApplication {
	public static ConfigurableApplicationContext context;
	public static Logger logger = LoggerFactory.getLogger(CloudComputerBackendApplication.class);

	/**
	 * 客户端实体
	 */
	public static OSClient.OSClientV3 client;

	public static void main(String[] args) {
		context = SpringApplication.run(CloudComputerBackendApplication.class, args);
		Initializer initializer = context.getBean(Initializer.class);
		client = context.getBean(OSClient.OSClientV3.class);
		if (initializer.initialize()) {
			logger.info("初始化成功");
		}else {
			logger.info("初始化失败");
		}


	}






}
