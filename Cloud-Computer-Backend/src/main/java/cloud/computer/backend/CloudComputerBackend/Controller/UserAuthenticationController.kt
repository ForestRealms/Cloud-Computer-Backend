package cloud.computer.backend.CloudComputerBackend.Controller

import com.alibaba.fastjson2.JSONObject
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserAuthenticationController {

    @GetMapping("/login")
    fun login(@RequestParam username: String,
              @RequestParam password: String): JSONObject {
        // TODO: 设计登录逻辑

        val res = JSONObject()
        res["username"] = username
        res["password"] = password
        return res;
    }
}