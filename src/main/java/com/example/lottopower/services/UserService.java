package com.example.lottopower.services;

import com.example.lottopower.models.Users;
import com.example.lottopower.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return this.userRepository.findAll();
    }

    public Users registerUser(Users users){
        return this.userRepository.save(users);
    }
}
