package com.game.social.discovery.user_management.Controller;

import com.game.social.discovery.user_management.DTO.UserCrudResponse;
import com.game.social.discovery.user_management.DTO.UserRequestDTO;
import com.game.social.discovery.user_management.Service.UserCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-data")
public class UserManagementController {

    @Autowired
    UserCrudService userCrudService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserRequestDTO userRequestDTO){
        UserCrudResponse response = userCrudService.createNewUser(userRequestDTO);
        if(response.getSuccess() == 1){
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserData(@PathVariable String id){
        UserCrudResponse response = userCrudService.getUserDataById(id);
        if(response.getSuccess() == 1){
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserRequestDTO userRequestDTO){
        UserCrudResponse response = userCrudService.updateUser(userRequestDTO,id);
        if(response.getSuccess() == 1){
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        UserCrudResponse response = userCrudService.deleteUser(id);
        if(response.getSuccess() == 1){
            return ResponseEntity.ok(response);
        }
        else{
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
