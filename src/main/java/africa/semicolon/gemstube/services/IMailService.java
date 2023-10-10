package africa.semicolon.gemstube.services;

import africa.semicolon.gemstube.dto.EmailRequest;
import africa.semicolon.gemstube.dto.EmailResponse;

public interface IMailService {
    public EmailResponse sendEmail(EmailRequest request) ;

}
