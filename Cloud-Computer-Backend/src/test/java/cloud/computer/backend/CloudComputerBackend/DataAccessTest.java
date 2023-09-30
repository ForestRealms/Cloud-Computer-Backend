package cloud.computer.backend.CloudComputerBackend;

import cloud.computer.backend.CloudComputerBackend.DataAccess.TokenDataAccess;
import cloud.computer.backend.CloudComputerBackend.DataAccess.UserDataAccess;
import cloud.computer.backend.CloudComputerBackend.Entity.BasicRandomTokenGenerator;
import cloud.computer.backend.CloudComputerBackend.Entity.Token;
import cloud.computer.backend.CloudComputerBackend.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@SpringBootTest
public class DataAccessTest {

    private UserDataAccess userDataAccess;
    private TokenDataAccess tokenDataAccess;
    private BasicRandomTokenGenerator basicRandomTokenGenerator;

    @Autowired
    public void setUserDataAccess(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
    }

    @Autowired
    public void setTokenDataAccess(TokenDataAccess tokenDataAccess) {
        this.tokenDataAccess = tokenDataAccess;
    }

    @Autowired
    public void setBasicRandomTokenGenerator(BasicRandomTokenGenerator basicRandomTokenGenerator) {
        this.basicRandomTokenGenerator = basicRandomTokenGenerator;
    }

    @Test
    public void listAllUsers(){
        for (User user : this.userDataAccess.getUsers()) {
            System.out.println(
                      "ID=" + user.getId() + "\t"
                    + "username=" + user.getUsername() + "\t"
                    + "password=" + user.getPassword() + "\t"
                    + "instances=" + user.getInstances() + "\t"
                    + "token=" + user.getTokenValue()
            );
        }
    }

    @Test
    public void addToken(){
        Token token = new Token();
        token.setValue(this.basicRandomTokenGenerator.generate());
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(ZoneId.of("Asia/Shanghai")));
        calendar.add(Calendar.DATE, 7);
        token.setExpiration(calendar.getTime());
        this.tokenDataAccess.addToken(token);
    }


}
