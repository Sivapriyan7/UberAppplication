package com.codingshuttle.project.uber.uberApp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String accessToken;
}
