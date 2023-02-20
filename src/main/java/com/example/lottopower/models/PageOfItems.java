package com.example.lottopower.models;

import java.util.List;

public class PageOfItems<T> {

    List<T> list;
    Boolean hasNext;
    int totalElements;

    public PageOfItems(List<T> list, Boolean hasNext, int totalElements) {
        this.list = list;
        this.hasNext = hasNext;
        this.totalElements = totalElements;
    }

    public PageOfItems() {}

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
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
