package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.config.MailConfig;
import africa.semicolon.gemstube.dto.EmailRequest;
import africa.semicolon.gemstube.dto.EmailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

import static org.springframework.http.HttpMethod.POST;

@Service
@RequiredArgsConstructor
public class MailService implements IMailService{
    private final MailConfig mailConfig;
    @Override
    public EmailResponse sendEmail(EmailRequest request) {

        final String  apiKey = mailConfig.getMailApiKey();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
        httpHeaders.set("api-key",apiKey);

        HttpEntity<EmailRequest> requestEntity = new RequestEntity<>(request, httpHeaders, POST, URI.create(""));

        ResponseEntity<EmailResponse> response = restTemplate.postForEntity(mailConfig.getBrevoMailUrl(), requestEntity, EmailResponse.class);

        var emailResponse = response.getBody();
         emailResponse.setStatusCode(response.getStatusCode().value());
        return emailResponse;
    }
}
