package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.EmailRequest;
import africa.semicolon.gemstube.dto.Recipient;
import africa.semicolon.gemstube.dto.RegisterRequest;
import africa.semicolon.gemstube.dto.RegisterResponse;
import africa.semicolon.gemstube.exceptions.GemstubeException;
import africa.semicolon.gemstube.models.User;
import africa.semicolon.gemstube.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.catalina.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements IUserService {

    private final UserRepository userRepository;
    private final MailService mailService;



    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());
        User savedUser = userRepository.save(user);
        EmailRequest emailRequest = new EmailRequest();
        emailRequest.setRecipients(List.of(new Recipient(savedUser.getEmail(), "Fred")));
        emailRequest.setHtmlContent("<p>this is it<p>");
        emailRequest.setSubject("Welcome to gemstube streaming service");
        mailService.sendEmail(emailRequest);
        return new RegisterResponse(savedUser.getId());

    }

    @Override
    public User getUserById(Long creatorId) throws GemstubeException {
        return userRepository.findById(creatorId).orElseThrow(()->new GemstubeException(String.format("user with id %d not found", creatorId)));
    }
}
