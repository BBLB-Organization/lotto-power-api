package com.example.lottopower.services;

import com.example.lottopower.config.TokenGenerator;
import com.example.lottopower.models.Users;
import com.example.lottopower.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Users registerUser(Users users){
        users.setPassword(passwordEncoder().encode(users.getPassword()));
        return this.userRepository.save(users);
    }

    public boolean checkLoginCredentials(String email, String userProvidedPassword) {
        Users user = userRepository.findByEmailAddress(email);
        if (user != null) {
            String encodedPassword = user.getPassword();
            if (passwordEncoder().matches(userProvidedPassword, encodedPassword)) {
                return true;
            }
            else{
                return false;
            }
        }
        else {
            throw new IllegalArgumentException("User not found with email: " + email);
        }
    }

    public void updateAccessTokenForUserLoggedIn(String email, String token){
        Users user = userRepository.findByEmailAddress(email);
        if(user != null){
            String encodedToken = passwordEncoder().encode(token);
            user.setAccessToken(encodedToken);
            userRepository.save(user);
        }
        else{
            throw new IllegalArgumentException("User not found with email: "+email);
        }
    }

    public boolean isAuthenticated(Users user){
        Users userAuthenticated = userRepository.findByEmailAddress(user.getEmailAddress());
        if(userAuthenticated != null){
            String encodedAccessToken = userAuthenticated.getAccessToken();
            if(passwordEncoder().matches(user.getAccessToken(),encodedAccessToken)){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            throw new IllegalArgumentException("User not authenticated");
        }
    }

    public Users getUserByUserName(String username){
        Users user = this.userRepository.findByUsername(username);
        return user;
    }


}
