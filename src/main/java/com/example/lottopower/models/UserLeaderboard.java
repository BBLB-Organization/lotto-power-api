package com.example.lottopower.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLeaderboard {

    @Id
    String username;

    Integer totalGamesPlayed;
    Integer totalMoneySpent;
    Integer totalMoneyWon;
    Boolean hasJackpot;

    public UserLeaderboard() {}

    public UserLeaderboard(String username, Integer totalGamesPlayed, Integer totalMoneySpent, Integer totalMoneyWon, Boolean hasJackpot) {
        this.username = username;
        this.totalGamesPlayed = totalGamesPlayed;
        this.totalMoneySpent = totalMoneySpent;
        this.totalMoneyWon = totalMoneyWon;
        this.hasJackpot = hasJackpot;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(Integer totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public Integer getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(Integer totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public Integer getTotalMoneyWon() {
        return totalMoneyWon;
    }

    public void setTotalMoneyWon(Integer totalMoneyWon) {
        this.totalMoneyWon = totalMoneyWon;
    }

    public Boolean getHasJackpot() {
        return hasJackpot;
    }

    public void setHasJackpot(Boolean hasJackpot) {
        this.hasJackpot = hasJackpot;
    }
}
