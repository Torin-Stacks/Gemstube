package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.EmailRequest;
import africa.semicolon.gemstube.dto.EmailResponse;
import africa.semicolon.gemstube.dto.Recipient;
import africa.semicolon.gemstube.dto.Sender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest

public class MailServiceTest {
    @Autowired
    private IMailService mailService;
    @Test
    public void sendEmail(){

        Recipient recipient = new Recipient();
        recipient.setName("Timileyin Bamgbose");
        recipient.setEmail("timileyinbamgbose7@gmail.com");
        List<Recipient> recipients = List.of( recipient );

        EmailRequest emailRequest = new EmailRequest();


        emailRequest.setRecipients(recipients);
        emailRequest.setSubject("testing our app");
        emailRequest.setHtmlContent("<p>testing our app<p/>");

       EmailResponse emailResponse = mailService.sendEmail(emailRequest);

        Assertions.assertNotNull(emailResponse);
        Assertions.assertNotNull(emailResponse.getStatusCode());

    }
}
