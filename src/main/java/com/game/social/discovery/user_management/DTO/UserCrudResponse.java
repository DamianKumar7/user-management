package com.game.social.discovery.user_management.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCrudResponse {
    private Long success;
    private String message;
    private UserRequestDTO userDTO;
}
