package com.example.lottopower.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class UserStats {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String emailAddress;

    LocalDate joinedDate;
    LocalDate lastSeenDate;
    Integer totalMoneySpent;
    Integer totalMatchedTwoWinnings;
    Integer totalMatchedThreeWinnings;
    Integer totalMatchedFourWinnings;
    Integer totalMatchedFiveWinnings;
    Integer totalGamesPlayed;
    Integer totalGamesWon;
    Integer totalGamesWonWhereMatchedTwo;
    Integer totalGamesWonWhereMatchedThree;
    Integer totalGamesWonWhereMatchedFour;
    Integer totalGamesWonWhereMatchedFive;

    public UserStats(){}

    public UserStats(Integer id, String emailAddress, LocalDate joinedDate, LocalDate lastSeenDate, Integer totalMoneySpent, Integer totalMatchedTwoWinnings, Integer totalMatchedThreeWinnings, Integer totalMatchedFourWinnings, Integer totalMatchedFiveWinnings, Integer totalGamesPlayed, Integer totalGamesWon, Integer totalGamesWonWhereMatchedTwo, Integer totalGamesWonWhereMatchedThree, Integer totalGamesWonWhereMatchedFour, Integer totalGamesWonWhereMatchedFive) {
        this.id = id;
        this.emailAddress = emailAddress;
        this.joinedDate = joinedDate;
        this.lastSeenDate = lastSeenDate;
        this.totalMoneySpent = totalMoneySpent;
        this.totalMatchedTwoWinnings = totalMatchedTwoWinnings;
        this.totalMatchedThreeWinnings = totalMatchedThreeWinnings;
        this.totalMatchedFourWinnings = totalMatchedFourWinnings;
        this.totalMatchedFiveWinnings = totalMatchedFiveWinnings;
        this.totalGamesPlayed = totalGamesPlayed;
        this.totalGamesWon = totalGamesWon;
        this.totalGamesWonWhereMatchedTwo = totalGamesWonWhereMatchedTwo;
        this.totalGamesWonWhereMatchedThree = totalGamesWonWhereMatchedThree;
        this.totalGamesWonWhereMatchedFour = totalGamesWonWhereMatchedFour;
        this.totalGamesWonWhereMatchedFive = totalGamesWonWhereMatchedFive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public LocalDate getLastSeenDate() {
        return lastSeenDate;
    }

    public void setLastSeenDate(LocalDate lastSeenDate) {
        this.lastSeenDate = lastSeenDate;
    }

    public Integer getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(Integer totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public Integer getTotalMatchedTwoWinnings() {
        return totalMatchedTwoWinnings;
    }

    public void setTotalMatchedTwoWinnings(Integer totalMatchedTwoWinnings) {
        this.totalMatchedTwoWinnings = totalMatchedTwoWinnings;
    }

    public Integer getTotalMatchedThreeWinnings() {
        return totalMatchedThreeWinnings;
    }

    public void setTotalMatchedThreeWinnings(Integer totalMatchedThreeWinnings) {
        this.totalMatchedThreeWinnings = totalMatchedThreeWinnings;
    }

    public Integer getTotalMatchedFourWinnings() {
        return totalMatchedFourWinnings;
    }

    public void setTotalMatchedFourWinnings(Integer totalMatchedFourWinnings) {
        this.totalMatchedFourWinnings = totalMatchedFourWinnings;
    }

    public Integer getTotalMatchedFiveWinnings() {
        return totalMatchedFiveWinnings;
    }

    public void setTotalMatchedFiveWinnings(Integer totalMatchedFiveWinnings) {
        this.totalMatchedFiveWinnings = totalMatchedFiveWinnings;
    }

    public Integer getTotalGamesPlayed() {
        return totalGamesPlayed;
    }

    public void setTotalGamesPlayed(Integer totalGamesPlayed) {
        this.totalGamesPlayed = totalGamesPlayed;
    }

    public Integer getTotalGamesWon() {
        return totalGamesWon;
    }

    public void setTotalGamesWon(Integer totalGamesWon) {
        this.totalGamesWon = totalGamesWon;
    }

    public Integer getTotalGamesWonWhereMatchedTwo() {
        return totalGamesWonWhereMatchedTwo;
    }

    public void setTotalGamesWonWhereMatchedTwo(Integer totalGamesWonWhereMatchedTwo) {
        this.totalGamesWonWhereMatchedTwo = totalGamesWonWhereMatchedTwo;
    }

    public Integer getTotalGamesWonWhereMatchedThree() {
        return totalGamesWonWhereMatchedThree;
    }

    public void setTotalGamesWonWhereMatchedThree(Integer totalGamesWonWhereMatchedThree) {
        this.totalGamesWonWhereMatchedThree = totalGamesWonWhereMatchedThree;
    }

    public Integer getTotalGamesWonWhereMatchedFour() {
        return totalGamesWonWhereMatchedFour;
    }

    public void setTotalGamesWonWhereMatchedFour(Integer totalGamesWonWhereMatchedFour) {
        this.totalGamesWonWhereMatchedFour = totalGamesWonWhereMatchedFour;
    }

    public Integer getTotalGamesWonWhereMatchedFive() {
        return totalGamesWonWhereMatchedFive;
    }

    public void setTotalGamesWonWhereMatchedFive(Integer totalGamesWonWhereMatchedFive) {
        this.totalGamesWonWhereMatchedFive = totalGamesWonWhereMatchedFive;
    }
}
