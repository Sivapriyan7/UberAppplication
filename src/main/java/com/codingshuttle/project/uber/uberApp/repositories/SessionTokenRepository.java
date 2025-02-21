package com.codingshuttle.project.uber.uberApp.repositories;

import com.codingshuttle.project.uber.uberApp.entities.SessionToken;
import com.codingshuttle.project.uber.uberApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionTokenRepository extends JpaRepository<SessionToken, Long> {

    int countByUser(User user);

    List<SessionToken> findByUserOrderByExpiryDateAsc(User user);

    void deleteByToken(String token);
}
