package cloud.computer.backend.CloudComputerBackend.Services;

import cloud.computer.backend.CloudComputerBackend.Entity.AuthenticationResult;

public interface IAuthenticationService {
    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    AuthenticationResult login(String username, String password);

    /**
     * 注册功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    AuthenticationResult register(String username, String password);
}
