package africa.semicolon.gemstube.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Getter
@Setter
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   private String comment;
   @OneToOne
   private User commenter;
   @OneToOne
   private Media media;
}
