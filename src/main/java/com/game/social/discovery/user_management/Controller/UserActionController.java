package com.game.social.discovery.user_management.Controller;

import com.game.social.discovery.user_management.DTO.UserActionResponseDTO;
import com.game.social.discovery.user_management.Service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/user-action")
public class UserActionController {

    @Autowired
    UserActionService userActionService;

    @PostMapping("/likes")
    public ResponseEntity<?> getLikedGamesByUserId(@RequestParam("userId")String userId){
        UserActionResponseDTO response = userActionService.getLikedGamesByUser(userId);
        if(!ObjectUtils.isEmpty(response.getSuccess()) && response.getSuccess() == 1){
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
