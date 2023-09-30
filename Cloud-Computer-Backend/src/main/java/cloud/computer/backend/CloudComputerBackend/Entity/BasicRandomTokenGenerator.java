package cloud.computer.backend.CloudComputerBackend.Entity;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

@Component
public class BasicRandomTokenGenerator implements RandomTokenGenerator{


    private int length = 128;
    private SecureRandom secureRandom;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String generate() {
        this.secureRandom.reseed();
        byte[] token = new byte[length];
        secureRandom.nextBytes(token);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(token);
    }
}
