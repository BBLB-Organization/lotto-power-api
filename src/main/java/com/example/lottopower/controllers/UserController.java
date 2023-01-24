package com.example.lottopower.controllers;

import com.example.lottopower.config.TokenGenerator;
import com.example.lottopower.models.Users;
import com.example.lottopower.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("user")
public class UserController {

    private UserService userService;

    private static final String ROLE_USER = "ROLE_USER";

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("register-user")
    public Users registerUser(@RequestBody Users users){
        users.setRoles(ROLE_USER);
        return this.userService.registerUser(users);
    }

    @PostMapping("login")
    public ResponseEntity<String> checkLoginCredentials(@RequestBody Users user) {
        try {
            if (userService.checkLoginCredentials(user.getEmailAddress(), user.getPassword())) {
                String [] roles = {"ROLE_USER"};
                String token = TokenGenerator.generateToken(user.getEmailAddress(), roles);
                return new ResponseEntity<>("Login Successful, here is your token: "+token, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Incorrect Email or Password", HttpStatus.UNAUTHORIZED);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("all")
    //@PreAuthorize("hasRole('ROLE_USER')")
    public List<Users> getAllUsers(){
        return this.userService.getAllUsers();
    }



}
