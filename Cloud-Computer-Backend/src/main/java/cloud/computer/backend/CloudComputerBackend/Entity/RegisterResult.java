package cloud.computer.backend.CloudComputerBackend.Entity;

import lombok.Getter;
import lombok.Setter;


public class RegisterResult implements AuthenticationResult{

    public static final int USER_ALREADY_EXISTS = -1;
    public static final int REGISTER_SUCCESSFULLY = 1;

    @Setter
    private int result;

    @Setter
    private String message;

    @Setter
    private String tokenValue;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getTokenValue() {
        return tokenValue;
    }
}
