package cloud.computer.backend.CloudComputerBackend.Controller

import cloud.computer.backend.CloudComputerBackend.Entity.LoginResult
import cloud.computer.backend.CloudComputerBackend.Services.AuthenticationService
import com.alibaba.fastjson2.JSONObject
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserAuthenticationController {

    @Autowired
    lateinit var authenticationService: AuthenticationService


    @GetMapping("/login")
    fun login(@RequestParam username: String,
              @RequestParam password: String): JSONObject {
        val res = JSONObject()
        val loginResult = this.authenticationService.login(username, password) as LoginResult
        res["code"] = loginResult.result
        res["message"] = loginResult.message
        res["token"] = loginResult.tokenValue
        return res

    }
}