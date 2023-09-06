package cloud.computer.backend.CloudComputerBackend;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.boot.SpringBootVersion;
import org.springframework.core.SpringVersion;

public class Constants {
    public static final JSONObject SYSTEM_INFORMATION = new JSONObject();
    public static final String SPRING_FRAMEWORK_VERSION = SpringVersion.getVersion();
    public static final String SPRING_BOOT_VERSION = SpringBootVersion.getVersion();
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String OS_VERSION = System.getProperty("os.version");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final int NUMBER_OF_CPU_CORE = Runtime.getRuntime().availableProcessors();
}
