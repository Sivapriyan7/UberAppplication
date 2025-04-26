package com.codingshuttle.project.uber.uberApp.services.impl;

import com.codingshuttle.project.uber.uberApp.entities.User;
import com.codingshuttle.project.uber.uberApp.entities.Wallet;
import com.codingshuttle.project.uber.uberApp.entities.WalletTransaction;
import com.codingshuttle.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.codingshuttle.project.uber.uberApp.repositories.UserRepository;
import com.codingshuttle.project.uber.uberApp.repositories.WalletRepository;
import com.codingshuttle.project.uber.uberApp.services.UserService;
import com.codingshuttle.project.uber.uberApp.services.WalletTransactionService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Slf4j
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class WalletServiceImplTest {

    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    void testaddMoneyToWallet()
    {
        double addAmount = 100L;
        double userId = 3L;
        User user = userRepository.findById(3L)
                .orElseThrow(()-> new ResourceNotFoundException("User not found with id "+3));
        Wallet wallet = walletRepository.findByUser(user)
                .orElseThrow(()-> new ResourceNotFoundException("wallet not found with id : "+user.getId()));
        wallet.setBalance(wallet.getBalance()+addAmount);
        log.info("Wallet amount added successfully : "+wallet.getBalance());
        walletRepository.save(wallet);

    }
}