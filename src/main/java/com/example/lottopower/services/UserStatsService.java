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

    public UserStats getUserStats(String emailAddress){
        UserStats userStats = this.userStatsRepository.findByEmailAddress(emailAddress);
        return userStats;
    }

    public UserStats createUserStats(String emailAddress){
        Integer initialValue = 0;
        UserStats userStats = new UserStats();
        LocalDate dateAccountCreated = LocalDate.now();
        LocalDate dateLastSeen = LocalDate.now();

        //Setting initial values
        userStats.setEmailAddress(emailAddress);
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

}
