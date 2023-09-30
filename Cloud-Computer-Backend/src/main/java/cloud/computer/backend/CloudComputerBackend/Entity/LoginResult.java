package cloud.computer.backend.CloudComputerBackend.Entity;


import lombok.Getter;
import lombok.Setter;


public class LoginResult implements AuthenticationResult{

    /**
     * 表示用户登录成功的状态
     */
    public static final int SUCCESS = 1;

    /**
     * 表示凭据无效的状态
     */
    public static final int INVALID_CREDENTIALS = 0;

    /**
     * 表示用户找不到的状态
     */
    public static final int USER_NOT_FOUND = -1;


    @Setter
    private int result;


    @Setter
    private String tokenValue;


    @Setter
    private String message;

    public LoginResult() {
    }

    @Override
    public int getResult() {
        return result;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
