package com.game.social.discovery.user_management.Respository;

import com.game.social.discovery.user_management.Model.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Likes,String> {
    List<Likes> findByUserId(String userId);
}
