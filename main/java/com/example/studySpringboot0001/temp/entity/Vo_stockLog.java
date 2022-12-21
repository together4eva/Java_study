package com.example.studySpringboot0001.temp.entity;

public class Vo_stockLog {
    private String time;
    private String price;
    public Vo_stockLog(String time, String price) {
        this.time = time;
        this.price = price;
    }
    public String getTime() {
        return this.time;
    }
    public String getPrice() {
        return this.price;
    }
}
