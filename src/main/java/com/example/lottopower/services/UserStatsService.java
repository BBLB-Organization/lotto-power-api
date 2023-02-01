package com.example.lottopower.services;

import com.example.lottopower.models.UserStats;
import com.example.lottopower.models.Users;
import com.example.lottopower.repositories.UserStatsRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Service
public class UserStatsService {

    private UserStatsRepository userStatsRepository;
    private UserService userService;

    public UserStatsService(UserStatsRepository userStatsRepository){
        this.userStatsRepository = userStatsRepository;
    }

    public UserStats getUserStats(String username){
        UserStats userStats = this.userStatsRepository.findByUsername(username);
        return userStats;
    }

    public UserStats createUserStats(String username){
        Integer initialValue = 0;
        UserStats userStats = new UserStats();
        LocalDate dateAccountCreated = LocalDate.now();
        LocalDate dateLastSeen = LocalDate.now();

        //Setting initial values
        userStats.setUsername(username);
        userStats.setJoinedDate(dateAccountCreated);
        userStats.setLastSeenDate(dateLastSeen);
        userStats.setTotalMoneySpent(initialValue);
        userStats.setTotalMatchedTwoWinnings(initialValue);
        userStats.setTotalMatchedThreeWinnings(initialValue);
        userStats.setTotalMatchedFourWinnings(initialValue);
        userStats.setTotalMatchedFiveWinnings(initialValue);
        userStats.setTotalGamesPlayed(initialValue);
        userStats.setTotalGamesWon(initialValue);
        userStats.setTotalGamesWonWhereMatchedTwo(initialValue);
        userStats.setTotalGamesWonWhereMatchedThree(initialValue);
        userStats.setTotalGamesWonWhereMatchedFour(initialValue);
        userStats.setTotalGamesWonWhereMatchedFive(initialValue);

        //Saves user stats to database
        return this.userStatsRepository.save(userStats);
    }

    public UserStats updateUserStats(UserStats oldUserStats){
        UserStats updatedUserStats = this.userStatsRepository.findByUsername(oldUserStats.getUsername());

        //Sets new users stats based on what the user does
        updatedUserStats.setLastSeenDate(oldUserStats.getLastSeenDate());
        updatedUserStats.setTotalMoneySpent(oldUserStats.getTotalMoneySpent());
        updatedUserStats.setTotalMatchedTwoWinnings(oldUserStats.getTotalMatchedTwoWinnings());
        updatedUserStats.setTotalMatchedThreeWinnings(oldUserStats.getTotalMatchedThreeWinnings());
        updatedUserStats.setTotalMatchedFourWinnings(oldUserStats.getTotalMatchedFourWinnings());
        updatedUserStats.setTotalMatchedFiveWinnings(oldUserStats.getTotalMatchedFiveWinnings());
        updatedUserStats.setTotalGamesPlayed(oldUserStats.getTotalGamesPlayed());
        updatedUserStats.setTotalGamesWon(oldUserStats.getTotalGamesWon());
        updatedUserStats.setTotalGamesWonWhereMatchedTwo(oldUserStats.getTotalGamesWonWhereMatchedTwo());
        updatedUserStats.setTotalGamesWonWhereMatchedThree(oldUserStats.getTotalGamesWonWhereMatchedThree());
        updatedUserStats.setTotalGamesWonWhereMatchedFour(oldUserStats.getTotalGamesWonWhereMatchedFour());
        updatedUserStats.setTotalGamesWonWhereMatchedFive(oldUserStats.getTotalGamesWonWhereMatchedFive());

        //Saves new user stats to the database
        return this.userStatsRepository.save(updatedUserStats);
    }

}
