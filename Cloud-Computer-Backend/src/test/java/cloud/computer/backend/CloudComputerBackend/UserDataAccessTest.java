package cloud.computer.backend.CloudComputerBackend;

import cloud.computer.backend.CloudComputerBackend.DataAccess.UserDataAccess;
import cloud.computer.backend.CloudComputerBackend.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserDataAccessTest {

    private UserDataAccess userDataAccess;

    @Autowired
    public void setUserDataAccess(UserDataAccess userDataAccess) {
        this.userDataAccess = userDataAccess;
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
}
