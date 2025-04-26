package com.codingshuttle.project.uber.uberApp.entities;

import com.codingshuttle.project.uber.uberApp.entities.enums.Role;
import com.codingshuttle.project.uber.uberApp.entities.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "app_user", indexes = {
        @Index(name = "idx_user_email", columnList = "email")
})

private String name;

@Column(unique = true)pe.IDENTITY)
private Long id;
    }

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    return roles.stream()
            .map(role -> new SimpleGrantedAuthority("ROLE_"+role.name()))
            .collect(Collectors.toSet());
}

@Override

private String email;
private String password;

@ElementCollection(fetch = FetchType.EAGER)
@Enumerated(EnumType.STRING)
private Set<Role> roles;

@Enumerated(EnumType.STRING)
private SubscriptionType subscriptionType;

public int getSessionLimit(){
    return switch (subscriptionType){
        case FREE -> 1;
        case BASIC -> 2;
        case PREMIUM -> 3;
    };
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationTy  public String getUsername() {
        return email;
    }
}
