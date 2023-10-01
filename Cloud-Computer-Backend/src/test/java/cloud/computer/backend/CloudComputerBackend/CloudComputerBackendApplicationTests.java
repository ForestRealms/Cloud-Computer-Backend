package cloud.computer.backend.CloudComputerBackend;

import cloud.computer.backend.CloudComputerBackend.Entity.RegisterResult;
import cloud.computer.backend.CloudComputerBackend.Services.AuthenticationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CloudComputerBackendApplicationTests {

	private AuthenticationService authenticationService;

	private CloudDesktopService cloudDesktopService;

	@Autowired
	public void setAuthenticationService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@Autowired
	public void setCloudDesktopService(CloudDesktopService cloudDesktopService) {
		this.cloudDesktopService = cloudDesktopService;
	}

	@Test
	void contextLoads() {
	}

	@Test
	void registerUser(){
		RegisterResult result = this.authenticationService.register("testuser", "111111");
		System.out.println(result.getResult());
		System.out.println(result.getMessage());
	}

	@Test
	public void getAllServers(){
		System.out.println(this.cloudDesktopService.getServerList());
	}

	@Test
	public void startupServer(){
		this.cloudDesktopService.startup("instance-00000028");
	}

	@Test
	public void stopServer(){
		this.cloudDesktopService.shutdown("instance-00000028");
	}

	@Test
	public void getPowerStatus(){
		System.out.println(this.cloudDesktopService.getPowerStatus("instance-00000028"));
	}



}
