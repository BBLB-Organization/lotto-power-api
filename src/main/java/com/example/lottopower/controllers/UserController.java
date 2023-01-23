package com.example.lottopower.controllers;

import com.example.lottopower.models.Users;
import com.example.lottopower.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("all")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @PostMapping("register-user")
    public Users registerUser(@RequestBody Users users){
        return this.userService.registerUser(users);
    }

}
