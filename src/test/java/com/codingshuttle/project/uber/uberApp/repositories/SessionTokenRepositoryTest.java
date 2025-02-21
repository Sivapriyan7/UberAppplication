package com.codingshuttle.project.uber.uberApp.repositories;

import com.codingshuttle.project.uber.uberApp.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class SessionTokenRepositoryTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionTokenRepository sessionTokenRepository;

    @Test
    void testcountByUser() {
        User user = userRepository.findById(41L).get();
        int session_count = sessionTokenRepository.countByUser(user);
        log.info("session coutn: " + session_count );
    }
}