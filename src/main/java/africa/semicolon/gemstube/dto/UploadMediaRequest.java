package africa.semicolon.gemstube.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
@Data
public class UploadMediaRequest {
    MultipartFile muiltipartfile;
    private Long creatorId;
    private  String Description;
    private String Title;
}
