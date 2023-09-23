package cloud.computer.backend.CloudComputerBackend.Controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAuthenticateController {

    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject info) throws JSONException {
        String username = info.getString("username");
        String password = info.getString("password");
        // TODO: 2023/9/5 完善处理逻辑和对应服务层的设计
        
        return null;

    }
}
