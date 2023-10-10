package africa.semicolon.gemstube.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
@Data

public class EmailRequest {
    private Sender sender;
    @JsonProperty("to")
    private List<Recipient> recipients;
    private String subject;
    private String htmlContent;


    public  EmailRequest(){
        this.sender = new Sender("gemstube@hotmail.africa", "gemstube.inc");
    }
}
