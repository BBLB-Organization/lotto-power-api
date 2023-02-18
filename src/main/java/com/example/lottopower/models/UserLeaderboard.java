package com.example.lottopower.models;

import java.util.List;

public class UserLeaderboard<T> {

    List<T> userStatsList;
    Boolean hasNext;
    int totalElements;

    public UserLeaderboard(List<T> userStatsList, Boolean hasNext, int totalElements) {
        this.userStatsList = userStatsList;
        this.hasNext = hasNext;
        this.totalElements = totalElements;
    }

    public UserLeaderboard() {}

    public List<T> getUserStatsList() {
        return userStatsList;
    }

    public void setUserStatsList(List<T> userStatsList) {
        this.userStatsList = userStatsList;
    }

    public Boolean getHasNext() {
        return hasNext;
    }

    public void setHasNext(Boolean hasNext) {
        this.hasNext = hasNext;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }
}
