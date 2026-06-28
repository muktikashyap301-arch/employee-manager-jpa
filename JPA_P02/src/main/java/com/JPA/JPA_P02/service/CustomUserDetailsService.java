package com.JPA.JPA_P02.service;

import com.JPA.JPA_P02.entity.User;
import com.JPA.JPA_P02.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User existingUser = userRepo.findByUsername(username)
        .orElseThrow(()->new UsernameNotFoundException("Username not found: " + username));


        return org.springframework.security.core.userdetails.User
                .withUsername(existingUser.getUsername())
                .password(existingUser.getPassword())
                .roles(existingUser.getRole())
                .build();
    }
}
