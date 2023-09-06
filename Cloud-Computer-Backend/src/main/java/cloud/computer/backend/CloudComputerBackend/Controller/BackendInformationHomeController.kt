package cloud.computer.backend.CloudComputerBackend.Controller
import cloud.computer.backend.CloudComputerBackend.Constants.*
import com.alibaba.fastjson2.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BackendInformationHomeController() {
    var SYSTEM_INFORMATION : JSONObject = JSONObject();

    init {
        SYSTEM_INFORMATION["系统名称"] = "云电脑后端应用程序"
        SYSTEM_INFORMATION["系统版本"] = "1.0.0.0"
        SYSTEM_INFORMATION["SpringBoot版本"] = SPRING_BOOT_VERSION
        SYSTEM_INFORMATION["SpringFramework版本"] = SPRING_FRAMEWORK_VERSION
        SYSTEM_INFORMATION["操作系统"] = OS_NAME
        SYSTEM_INFORMATION["操作系统版本"] = OS_VERSION
        SYSTEM_INFORMATION["Java版本"] = JAVA_VERSION
        SYSTEM_INFORMATION["CPU核心数"] = NUMBER_OF_CPU_CORE
    }
    
    @GetMapping("/")
    fun home(): JSONObject {
        return this.SYSTEM_INFORMATION;
    }
}