package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private IUserService userService;

    RegisterResponse registerResponse;
    RegisterRequest registerRequest;

    @BeforeEach
    public void setUp(){
        registerRequest = new RegisterRequest();
        registerRequest.setEmail("johndoe@gmail.com");
        registerRequest.setPassword("johndoe");
        registerResponse = userService.register(registerRequest);

    }

    @Test
    public void register(){
        assertNotNull(registerResponse);
        assertNotNull(registerResponse.getId());

    }

    @Test
    public void testGetUserById() throws GemstubeException {
       registerResponse = userService.register(registerRequest);
        User foundUser = userService.getUserById(registerResponse.getId());
        assertNotNull(foundUser);
    }
}
