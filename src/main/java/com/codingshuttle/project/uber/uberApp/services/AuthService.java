package com.codingshuttle.project.uber.uberApp.services;

import com.codingshuttle.project.uber.uberApp.dto.DriverDto;
import com.codingshuttle.project.uber.uberApp.dto.LoginResponseDto;
import com.codingshuttle.project.uber.uberApp.dto.SignupDto;
import com.codingshuttle.project.uber.uberApp.dto.UserDto;
import com.codingshuttle.project.uber.uberApp.entities.Vehicle;

public interface AuthService {

    String[] login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId, Vehicle vehicle);

    void logout(String token);

    String refreshToken(String refreshToken);
}
