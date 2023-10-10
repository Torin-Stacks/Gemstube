package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.RegisterResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;
    @Test
    public void register(){
        RegisterRequest registerRequest= new RegisterRequest();
        registerRequest.setEmail("johndoe@gmail.com");
        registerRequest.setPassword("johndoe");

        RegisterResponse registerResponse = userService.register(registerRequest);
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());

    }
}
