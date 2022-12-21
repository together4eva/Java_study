package com.example.studySpringboot0001.temp.entity;

public class Stock {
    //필드
    private String company_name;
    private Integer stock_count;
    private Integer one_stock_money;


    //생성자
    public Stock(String company_name) {
        this.company_name = company_name;
        stock_count = 100;
        one_stock_money = 10000;
    }
    //메서드
    public void setStock_count(Integer stock_count) {
        this.stock_count = stock_count;
    }
    public void setOne_stock_money(Integer one_stock_money) {
        this.one_stock_money = one_stock_money;
    }
    public String getCompany_name() {
        return this.company_name;
    }
    public Integer getOne_stock_money() {
        return this.one_stock_money;
    }
    public Integer getStock_count() {
        return this.stock_count;
    }
}
