package org.example.Instagram.Backend.Practice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Authentication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    private String token;

    private LocalDate tokenCreationDate;

    @OneToOne
    private User user;

    public Authentication(User user)
    {
        this.user = user;
        this.token = UUID.randomUUID().toString();
        this.tokenCreationDate = LocalDate.now();
    }
}
