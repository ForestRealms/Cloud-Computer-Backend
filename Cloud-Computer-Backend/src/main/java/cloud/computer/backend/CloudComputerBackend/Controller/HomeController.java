package cloud.computer.backend.CloudComputerBackend.Controller;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

@RestController
public class HomeController {

    public static final JSONObject SYSTEM_INFORMATION = new JSONObject();
    public static final String SPRING_FRAMEWORK_VERSION = SpringVersion.getVersion();
    public static final String SPRING_BOOT_VERSION = SpringBootVersion.getVersion();
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final int NUMBER_OF_CPU_CORE = Runtime.getRuntime().availableProcessors();



    public HomeController() {
        SYSTEM_INFORMATION.put("系统名称", "云电脑后端应用程序");
        SYSTEM_INFORMATION.put("系统版本", "1.0.0.0");
        SYSTEM_INFORMATION.put("SpringBoot版本", SPRING_BOOT_VERSION);
        SYSTEM_INFORMATION.put("SpringFramework版本", SPRING_FRAMEWORK_VERSION);
        SYSTEM_INFORMATION.put("操作系统", OS_NAME);
        SYSTEM_INFORMATION.put("操作系统版本", OS_VERSION);
        SYSTEM_INFORMATION.put("Java版本", JAVA_VERSION);
        SYSTEM_INFORMATION.put("CPU核心数", NUMBER_OF_CPU_CORE);


    }

    @GetMapping("/")
    public JSONObject home(){

        return SYSTEM_INFORMATION;
    }
}
