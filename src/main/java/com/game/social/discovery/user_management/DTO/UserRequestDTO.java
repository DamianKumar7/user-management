package com.game.social.discovery.user_management.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRequestDTO {
    String userId;
    String username;
    String emailAddres;
    String nickname;

}
