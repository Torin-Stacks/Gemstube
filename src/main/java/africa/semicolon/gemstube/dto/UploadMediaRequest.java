package africa.semicolon.gemstube.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Data
public class UploadMediaRequest {
    private MultipartFile muiltipartfile;
    private Long creatorId;
    private  String Description;
    private String Title;
    private Optional<MultipartFile> subtitleFile;

}
