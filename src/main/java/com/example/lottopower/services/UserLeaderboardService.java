package com.example.lottopower.services;

import com.example.lottopower.models.UserLeaderboard;
import com.example.lottopower.models.UserStats;
import com.example.lottopower.repositories.UserStatsRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Provides logic and functionality to manage user leaderboard and sends information
 * back to controller pertaining to user leaderboard information.
 */
@Service
public class UserLeaderboardService {

    /**
     * Used to communicate with the User Stats schema in the database.
     */
    private UserStatsRepository userStatsRepository;

    public UserLeaderboardService(UserStatsRepository userStatsRepository){this.userStatsRepository = userStatsRepository;}

    /**
     * Finds all user stats information in the database given page number and page size,
     * returns a page of user stats information to provide pagination functionality.
     * @param pageNumber Page number
     * @param pageSize Page size
     * @return
     */
    public UserLeaderboard<UserStats> getUserLeaderboard(int pageNumber, int pageSize){

        //Creates new instance of UserLeaderboard class
        UserLeaderboard<UserStats> pageOfUserStatsLeaderboard = new UserLeaderboard<>();

        //Creates a page of user stats given page number size
        Pageable paging = PageRequest.of(pageNumber, pageSize);
        Page<UserStats> pageOfUserStats = userStatsRepository.findAll(paging);

        //Sets values into the instance created earlier for the UserLeaderboard class
        pageOfUserStatsLeaderboard.setUserStatsList(pageOfUserStats.getContent());
        pageOfUserStatsLeaderboard.setHasNext(pageOfUserStats.hasNext());
        pageOfUserStatsLeaderboard.setTotalElements(pageOfUserStats.getSize());

        //Checks if there are any user stats available, if not, returns new instance of user leaderboard
        if(pageOfUserStatsLeaderboard.getUserStatsList().isEmpty()){
            return new UserLeaderboard<>();
        }
        else{
            return pageOfUserStatsLeaderboard;
        }

    }

}
