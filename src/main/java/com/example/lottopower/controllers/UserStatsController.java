package com.example.lottopower.controllers;

import com.example.lottopower.models.UserStats;
import com.example.lottopower.models.Users;
import com.example.lottopower.services.UserService;
import com.example.lottopower.services.UserStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-stats")
public class UserStatsController {

    private UserStatsService userStatsService;
    private UserService userService;

    public UserStatsController(UserStatsService userStatsService, UserService userService){
        this.userStatsService = userStatsService;
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity getUserStats(@PathVariable String username){
        UserStats userStats = new UserStats();
        Users user = this.userService.getUserByUserName(username);
        try {
            if (user != null) {
                userStats = this.userStatsService.getUserStats(username);
                return new ResponseEntity<>(userStats, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(userStats, HttpStatus.UNAUTHORIZED);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(userStats, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity updateUserStats(@RequestBody UserStats updatedUserStats){
        UserStats newUserStats = new UserStats();
        Users user = this.userService.getUserByUserName(updatedUserStats.getUsername());
        try {
            if (user != null) {
                newUserStats = this.userStatsService.updateUserStats(updatedUserStats);
                return new ResponseEntity<>(newUserStats, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(newUserStats, HttpStatus.UNAUTHORIZED);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(newUserStats, HttpStatus.BAD_REQUEST);
        }

    }

}
