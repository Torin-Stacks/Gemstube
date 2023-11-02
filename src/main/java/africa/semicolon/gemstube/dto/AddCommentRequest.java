package africa.semicolon.gemstube.dto;

import lombok.Data;

@Data
public class AddCommentRequest {
    private String comment;
    private Long commenterId;

}