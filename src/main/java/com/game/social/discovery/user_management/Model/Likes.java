package com.game.social.discovery.user_management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "likes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    private String gameId; // The ID of the game being rated (foreign key to a Game entity)

    @Column(nullable = false)
    private String userId; // The ID of the user who gave the rating (optional, if you track users)

    @Column(nullable = false)
    private Long timestamp;
}
