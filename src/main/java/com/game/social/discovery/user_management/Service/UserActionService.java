package com.game.social.discovery.user_management.Service;

import com.game.social.discovery.user_management.DTO.UserActionResponseDTO;
import com.game.social.discovery.user_management.Model.Likes;
import com.game.social.discovery.user_management.Respository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserActionService {

    @Autowired
    LikeRepository likeRepository;

    public UserActionResponseDTO getLikedGamesByUser(String userId) {
        UserActionResponseDTO userActionResponseDTO = new UserActionResponseDTO();
        try{
            List<Likes> likes = likeRepository.findByUserId(userId);
            if(likes.isEmpty()){
                userActionResponseDTO.setSuccess(1);
                userActionResponseDTO.setMessage("Query Returned Empty List");
                return userActionResponseDTO;
            }
            userActionResponseDTO.setSuccess(1);
            userActionResponseDTO.setMessage("Found liked games by a user");
            List<String> gameIds = likes.stream().map(Likes::getGameId).toList();
            userActionResponseDTO.setResult(gameIds);
        } catch (Exception e) {
            userActionResponseDTO.setSuccess(0);
            userActionResponseDTO.setMessage(e.getMessage());
        }
        return userActionResponseDTO;
    }
}
