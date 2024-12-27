package com.game.social.discovery.user_management.Respository;

import com.game.social.discovery.user_management.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRespository extends JpaRepository<UserData,String> {
}
