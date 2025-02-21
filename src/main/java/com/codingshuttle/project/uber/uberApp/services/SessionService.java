package com.codingshuttle.project.uber.uberApp.services;

import com.codingshuttle.project.uber.uberApp.entities.SessionToken;
import com.codingshuttle.project.uber.uberApp.entities.User;

import java.util.Date;

public interface SessionService {
     SessionToken createSession(User user, String refreshToken, Date expiryDate);

     void removeOldestSession(User user);

     void removeSession(String token);

}
