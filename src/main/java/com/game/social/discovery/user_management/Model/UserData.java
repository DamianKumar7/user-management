package com.game.social.discovery.user_management.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigInteger;

@Entity
@Table(name = "user_data")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column
    private String username;

    @Column
    private String emailAddress;

    @Column
    private String nickname;
}
