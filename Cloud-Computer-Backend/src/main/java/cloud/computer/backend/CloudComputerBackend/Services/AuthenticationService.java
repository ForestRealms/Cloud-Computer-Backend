package cloud.computer.backend.CloudComputerBackend.Services;

import cloud.computer.backend.CloudComputerBackend.CloudComputerBackendApplication;
import com.alibaba.fastjson2.JSONObject;

public class AuthenticationService implements IAuthenticationService{

    /**
     * 登录功能
     * 用户名和项目名称是相同的
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    @Override
    public JSONObject login(String username, String password) {

        return null;
    }

    /**
     * 注册功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    @Override
    public JSONObject register(String username, String password) {
        return null;
    }
}
