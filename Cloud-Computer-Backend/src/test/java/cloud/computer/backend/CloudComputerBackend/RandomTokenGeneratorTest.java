package cloud.computer.backend.CloudComputerBackend;

import cloud.computer.backend.CloudComputerBackend.Entity.BasicRandomTokenGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RandomTokenGeneratorTest {

    private BasicRandomTokenGenerator basicRandomTokenGenerator;

    @Autowired
    public void setBasicRandomTokenGenerator(BasicRandomTokenGenerator basicRandomTokenGenerator) {
        this.basicRandomTokenGenerator = basicRandomTokenGenerator;
    }

    @Test
    public void test(){

    }
}
