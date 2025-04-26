package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.entities.SessionToken;
import com.codingshuttle.project.uber.uberApp.entities.User;
import com.codingshuttle.project.uber.uberApp.repositories.SessionTokenRepository;
import com.codingshuttle.project.uber.uberApp.services.SessionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SessionServiceImpl implements SessionService {

    private final SessionTokenRepository sessionTokenRepository;

    public SessionToken createSession(User user, String refreshToken, Date expiryDate){
        int activeSessions = sessionTokenRepository.countByUser(user);

        if(activeSessions >= user.getSessionLimit()){
            removeOldestSession(user);
        }
        SessionToken sessionToken = SessionToken.builder()
                .user(user)
                .token(refreshToken)
                .expiryDate(expiryDate)
                .build();

        return sessionTokenRepository.save(sessionToken);
    }

    public void removeOldestSession(User user){
        List<SessionToken> sessions = sessionTokenRepository.findByUserOrderByExpiryDateAsc(user);
        if(!sessions.isEmpty())
        {
            sessionTokenRepository.delete(sessions.get(0));
        }
    }

    @Transactional
    public void removeSession(String token){
        sessionTokenRepository.deleteByToken(token);
    }

}
