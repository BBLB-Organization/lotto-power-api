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

    @GetMapping
    public ResponseEntity getUserStats(@RequestBody Users userWithInfo){
        UserStats userStats = new UserStats();
        Users user = this.userService.getUserByUserName(userWithInfo.getUsername());
        try {
            if (user != null) {
                userStats = this.userStatsService.getUserStats(user.getEmailAddress());
                return new ResponseEntity<>(userStats, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(userStats, HttpStatus.UNAUTHORIZED);
            }
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(userStats, HttpStatus.BAD_REQUEST);
        }
    }

}
