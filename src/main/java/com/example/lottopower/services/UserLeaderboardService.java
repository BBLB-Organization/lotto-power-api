package com.example.lottopower.services;

import com.example.lottopower.models.PageOfItems;
import com.example.lottopower.models.UserLeaderboard;
import com.example.lottopower.models.UserStats;
import com.example.lottopower.repositories.UserLeaderboardRepository;
import com.example.lottopower.repositories.UserStatsRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides logic and functionality to manage user leaderboard and sends information
 * back to controller pertaining to user leaderboard information.
 */
@Service
public class UserLeaderboardService {

    /**
     * Used to communicate with the User Stats and User Leaderboard schema in the database.
     */
    private UserStatsRepository userStatsRepository;
    private UserLeaderboardRepository userLeaderboardRepository;

    public UserLeaderboardService(UserStatsRepository userStatsRepository, UserLeaderboardRepository userLeaderboardRepository){
        this.userStatsRepository = userStatsRepository;
        this.userLeaderboardRepository = userLeaderboardRepository;
    }

    /**
     * Finds all user stats information in the database given page number and page size,
     * returns a page of user stats information to provide pagination functionality.
     * @param pageNumber Page number
     * @param pageSize Page size
     * @return
     */
    public PageOfItems<UserLeaderboard> getUserLeaderboard(int pageNumber, int pageSize){

        List<UserStats> userStats = this.userStatsRepository.findAll();
        UserLeaderboard userLeaderboard = new UserLeaderboard();
        List<UserLeaderboard> userLeaderboards = new ArrayList<>();

        for(UserStats user: userStats){
            //Sums up total winnings of each user
            Integer totalMoneyWon = user.getTotalMatchedTwoWinnings() + user.getTotalMatchedThreeWinnings() + user.getTotalMatchedFourWinnings() + user.getTotalMatchedFiveWinnings();

            //Sets each data point to the user in the user leaderboard
            userLeaderboard.setUsername(user.getUsername());
            if(user.getTotalGamesWonWhereMatchedFive().equals(0)){
                userLeaderboard.setHasJackpot(false);
            }
            else{
                userLeaderboard.setHasJackpot(true);
            }
            userLeaderboard.setTotalGamesPlayed(user.getTotalGamesPlayed());
            userLeaderboard.setTotalMoneySpent(user.getTotalMoneySpent());
            userLeaderboard.setTotalMoneyWon(totalMoneyWon);

            //Adds row to User Leaderboard schema
            userLeaderboards.add(userLeaderboard);
        }

        this.userLeaderboardRepository.saveAll(userLeaderboards);

        //Creates new instance of PageOfItems using the user leaderboard object
        PageOfItems<UserLeaderboard> pagesForLeaderboards = new PageOfItems<>();

        //Creates a page for user leaderboard given page number and size
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<UserLeaderboard> pageOfUsersOnLeaderboard = userLeaderboardRepository.findAll(paging);

        //Sets values into the instance created earlier for the UserLeaderboard class
        pagesForLeaderboards.setList(pageOfUsersOnLeaderboard.getContent());
        pagesForLeaderboards.setHasNext(pageOfUsersOnLeaderboard.hasNext());
        pagesForLeaderboards.setTotalElements(pageOfUsersOnLeaderboard.getSize());

        //Checks if there are any user stats available, if not, returns new instance of user leaderboard
        if(pagesForLeaderboards.getList().isEmpty()){
            return new PageOfItems<>();
        }
        else{
            return pagesForLeaderboards;
        }

    }

    public long getTotalNumberOfPlayers(){
        return this.userLeaderboardRepository.count();
    }

}
