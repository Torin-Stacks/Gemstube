package africa.semicolon.gemstube.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

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
    @OneToOne(fetch = FetchType.EAGER)
    private User uploader;


}
