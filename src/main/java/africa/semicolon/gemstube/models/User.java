package africa.semicolon.gemstube.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO )
    @Id
    private Long id;

    private String email;

    private String password;
}
