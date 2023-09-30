package cloud.computer.backend.CloudComputerBackend.Services;

import cloud.computer.backend.CloudComputerBackend.DataAccess.UserDataAccess;
import cloud.computer.backend.CloudComputerBackend.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;

@Service
public class AuthenticationService implements IAuthenticationService{

    private UserDataAccess userDataAccess;

    private Environment environment;

    private RandomTokenGenerator randomTokenGenerator;

    @Autowired
    private void setUserDataAccess(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    @Autowired
    private void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Autowired
    public void setRandomTokenGenerator(BasicRandomTokenGenerator basicRandomTokenGenerator) {
        this.randomTokenGenerator = basicRandomTokenGenerator;
    }



    /**
     * 登录功能
     * 用户名和项目名称是相同的
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    @Override
    public LoginResult login(String username, String password) {
        LoginResult result = new LoginResult();
        User user = this.userDataAccess.getUserByUsername(username);
        if (user == null) {
            result.setResult(LoginResult.USER_NOT_FOUND);
            result.setMessage(this.environment.getProperty("language.user.UserNotFound"));
            result.setTokenValue(null);
            return result;
        }
        if (!user.getPassword().equals(password)) {
            result.setResult(LoginResult.INVALID_CREDENTIALS);
            result.setMessage(this.environment.getProperty("language.user.InvalidCredentials"));
            result.setTokenValue(null);
        }else {
            result.setResult(LoginResult.SUCCESS);
            result.setMessage(this.environment.getProperty("language.user.SuccessfulLogin"));
            String s = this.randomTokenGenerator.generate();
            user.setTokenValue(s);
            result.setTokenValue(s);
            this.userDataAccess.updateUser(user);
        }
        return result;
    }

    /**
     * 注册功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 处理结果
     */
    @Override
    public RegisterResult register(String username, String password) {
        RegisterResult result = new RegisterResult();

        if (!this.userDataAccess.userIsExist(username)) {
            result.setResult(RegisterResult.USER_ALREADY_EXISTS);
            result.setMessage(this.environment.getProperty("language.user.UserAlreadyExists"));
            result.setTokenValue(null);
        }else {
            User user = new User();
            user.setId(this.userDataAccess.getMaximumUserId().add(BigInteger.ONE));
            user.setUsername(username);
            user.setPassword(password);
            user.setInstances(new ArrayList<>());
            this.userDataAccess.addUser(user);
            result.setResult(RegisterResult.REGISTER_SUCCESSFULLY);
            result.setMessage("language.user.RegisterSuccessfully");
            LoginResult loginResult = this.login(username, password);
            result.setTokenValue(loginResult.getTokenValue());

        }

        return result;


    }
}
