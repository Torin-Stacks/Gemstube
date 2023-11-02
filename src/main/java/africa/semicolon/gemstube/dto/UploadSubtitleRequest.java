package africa.semicolon.gemstube.dto;

import africa.semicolon.gemstube.models.Media;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data

public class UploadSubtitleRequest {

    private Long mediaId;
    @OneToOne(fetch = FetchType.EAGER)
    private MultipartFile subtitleFIle;



}
