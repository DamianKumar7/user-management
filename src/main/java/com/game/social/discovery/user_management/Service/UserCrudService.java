package com.game.social.discovery.user_management.Service;

import com.game.social.discovery.user_management.Constants.ErrorConstants;
import com.game.social.discovery.user_management.DTO.UserCrudResponse;
import com.game.social.discovery.user_management.DTO.UserRequestDTO;
import com.game.social.discovery.user_management.Exceptions.UserCrudException;
import com.game.social.discovery.user_management.Model.UserData;
import com.game.social.discovery.user_management.Respository.UserDataRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.math.BigInteger;
import java.util.Optional;

@Service
public class UserCrudService {

    @Autowired
    UserDataRespository userDataRespository;

    public UserCrudResponse createNewUser(UserRequestDTO userRequestDTO) {
        UserCrudResponse response =  new UserCrudResponse();
        try {
            UserData userData = new UserData();
            userData.setNickname(userRequestDTO.getNickname());
            userData.setUsername(userRequestDTO.getUsername());
            userData.setEmailAddress(userRequestDTO.getEmailAddres());
            userDataRespository.save(userData);
            response.setSuccess(1L);
            response.setMessage("User Created Successfully");
        } catch (Exception e) {
            response.setSuccess(0L);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public UserCrudResponse getUserDataById(String userId) {
        UserCrudResponse response = new UserCrudResponse();
        try{
            Optional<UserData> userData  = userDataRespository.findById(new BigInteger(userId));
            if(userData.isEmpty()){
                throw new UserCrudException(ErrorConstants.COULD_NOT_FIND_USER);
            }
            UserRequestDTO userRequestDTO = decorateUserDTO(userData.get());
            response.setMessage("FOUND SUCESSFULLY");
            response.setUserDTO(userRequestDTO);
            response.setSuccess(1L);
        } catch (Exception e) {
            response.setSuccess(0L);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    private UserRequestDTO decorateUserDTO(UserData userData){
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setUserId(String.valueOf(userData.getId()));
        userRequestDTO.setNickname(userData.getNickname());
        userRequestDTO.setEmailAddres(userData.getEmailAddress());
        userRequestDTO.setUsername(userData.getUsername());

        return userRequestDTO;
    }

    public UserCrudResponse updateUser(UserRequestDTO userRequestDTO, String userId) {
        UserCrudResponse response = new UserCrudResponse();
        try{
            Optional<UserData> userData  = userDataRespository.findById(new BigInteger(userId));
            if(userData.isEmpty()){
                throw new UserCrudException(ErrorConstants.COULD_NOT_FIND_USER);
            }
            UserData user = userData.get();
            user.setEmailAddress(userRequestDTO.getEmailAddres());
            user.setNickname(userRequestDTO.getNickname());
            user.setUsername(userRequestDTO.getUsername());
            userDataRespository.save(user);
        } catch (Exception e) {
            response.setSuccess(0L);
            response.setMessage(e.getMessage());
        }
        return response;
    }

    public UserCrudResponse deleteUser(String userId) {
        UserCrudResponse response = new UserCrudResponse();
        try{
            Optional<UserData> userData  = userDataRespository.findById(new BigInteger(userId));
            if(userData.isEmpty()){
                throw new UserCrudException(ErrorConstants.COULD_NOT_FIND_USER);
            }
            userDataRespository.delete(userData.get());

        } catch (Exception e) {
            response.setSuccess(0L);
            response.setMessage(e.getMessage());
        }
        return response;
    }
}
