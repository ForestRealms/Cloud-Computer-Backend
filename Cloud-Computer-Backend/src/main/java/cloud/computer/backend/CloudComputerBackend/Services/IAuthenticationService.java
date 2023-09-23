package cloud.computer.backend.CloudComputerBackend.Services;

import com.alibaba.fastjson2.JSONObject;

public interface IAuthenticationService {
    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    JSONObject login(String username, String password);

    /**
     * 注册功能
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    JSONObject register(String username, String password);
}
