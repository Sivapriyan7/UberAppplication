package com.codingshuttle.project.uber.uberApp;


import com.codingshuttle.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplcationTests{

    @Autowired
    private EmailSenderService emailSenderService;

    @Test
    void contextLoads(){
        emailSenderService.sendEmail(
                "sivapriyanm11@gmail.com",
                "This is the Testing Email from Spring Boot",
                "Body of the Email");
    }

    @Test
    void sendEmailMultiple(){
        String emails[] = {
                "sivapriyanm11@gmail.com"
        };
        emailSenderService.sendEmail(emails,
                "Testing email",
                "body of the mail");
    }
 
}