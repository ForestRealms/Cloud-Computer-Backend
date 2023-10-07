package cloud.computer.backend.CloudComputerBackend.Controller

import cloud.computer.backend.CloudComputerBackend.Entity.LoginResult
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import cloud.computer.backend.CloudComputerBackend.Entity.RegisterResult
import cloud.computer.backend.CloudComputerBackend.Services.IAuthenticationService
import com.alibaba.fastjson.JSONObject
import org.springframework.web.bind.annotation.*
//@RestController
//class UserAuthenticationController {
//
//    @Autowired
//    lateinit var authenticationService: AuthenticationService
//
//
//    @GetMapping("/login")
//    fun login(@RequestParam username: String,
//              @RequestParam password: String): JSONObject {
//        val res = JSONObject()
//        val loginResult = this.authenticationService.login(username, password) as LoginResult
//        res["code"] = loginResult.result
//        res["message"] = loginResult.message
//        res["token"] = loginResult.tokenValue
//        return res
//
//    }
//}

@RestController
//@RequestMapping("/auth")
class UserAuthenticationController @Autowired constructor(
    private val authenticationService: IAuthenticationService
) {

    @PostMapping("/login")
    fun login(@RequestParam("username") username: String,
              @RequestParam("password") password: String): JSONObject {
        val loginResult = authenticationService.login(username, password) as LoginResult
        val res = JSONObject()
        res["code"] = loginResult.result
        res["message"] = loginResult.message
        if (loginResult.tokenValue != null) {
            res["token"] = loginResult.tokenValue
        }
        return res
    }

    @PostMapping("/register")
    fun register(@RequestParam("username") username: String,
                 @RequestParam("password") password: String): JSONObject {
        val RegisterResult = authenticationService.register(username, password) as RegisterResult
        val res = JSONObject()
        res["code"] = RegisterResult.result
        res["message"] = RegisterResult.message
        if (RegisterResult.tokenValue != null) {
            res["token"] = RegisterResult.tokenValue
        }
        return res
    }
}
