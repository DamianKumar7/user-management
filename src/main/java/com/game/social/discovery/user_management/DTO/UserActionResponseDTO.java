package com.game.social.discovery.user_management.DTO;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserActionResponseDTO {
    Integer success;
    String message;
    List<?> result;
}
