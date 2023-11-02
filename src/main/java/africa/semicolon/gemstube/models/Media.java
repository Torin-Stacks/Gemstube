package africa.semicolon.gemstube.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
@Entity
@Data

public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String url;
    private LocalDateTime createdAt;
    @ManyToOne(fetch = FetchType.EAGER)
    private User uploader;
    private String subtitleUrl;



    @PrePersist // use this for events you want to happen before saving your object to the database
    public void setCreatedAt(){
        this.createdAt = LocalDateTime.now();
    }


}
