package com.example.lottopower.controllers;

import com.example.lottopower.models.PageOfItems;
import com.example.lottopower.models.UserLeaderboard;
import com.example.lottopower.models.UserStats;
import com.example.lottopower.services.UserLeaderboardService;
import com.example.lottopower.services.UserService;
import com.example.lottopower.services.UserStatsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Allows users to view their stats information on a leaderboard.
 */
@RestController
@RequestMapping("user-leaderboard")
public class UserLeaderboardController {

    /**
     * All these fields are used to communicate with all the available services
     * should if needed.
     */
    private UserService userService;
    private UserStatsService userStatsService;
    private UserLeaderboardService userLeaderboardService;

    /**
     * Constructor for controller
     * @param userService
     * @param userStatsService
     * @param userLeaderboardService
     */
    public UserLeaderboardController(UserService userService, UserStatsService userStatsService, UserLeaderboardService userLeaderboardService){
        this.userService = userService;
        this.userStatsService = userStatsService;
        this.userLeaderboardService = userLeaderboardService;
    }

    /**
     * When the user is logged in, they will be able to view the user leaderboard
     * given the page number they are on and size.
     * @param pageNumber Page number
     * @param pageSize Page results
     * @return
     */
    @GetMapping
    public ResponseEntity<PageOfItems<UserLeaderboard>> getPageOfUserLeaderboard(@RequestParam(defaultValue = "0") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize){

        PageOfItems<UserLeaderboard> pageOfUserLeaderboard = this.userLeaderboardService.getUserLeaderboard(pageNumber, pageSize);

        try{
            if(pageOfUserLeaderboard != null){
                return new ResponseEntity<>(pageOfUserLeaderboard, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        catch(IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
