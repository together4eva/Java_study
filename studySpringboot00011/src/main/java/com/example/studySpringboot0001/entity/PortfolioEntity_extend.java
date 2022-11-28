package com.example.studySpringboot0001.entity;

import com.example.studySpringboot0001.component.Account;

public class PortfolioEntity_extend extends Account {

    //필드 : 데이터
    private String title;
    private String subject;
    private int category;
    private String date;
    private String link;

    //생성자 : 초기값 : 오버로딩(매개변수 갯수, 타입에 따라 다양한 초기값을 설정하여 인스턴스 생성)
    public PortfolioEntity_extend() {};
    public PortfolioEntity_extend(String title, String subject, int category,
                           String date, String link
    ) {
        super(title, subject, category, date, link);
    }
    //메서드
    public String getTitle() {
        return this.title;
    }
    public String getSubject() {
        return this.subject;
    }
    public int getCategory() {
        return this.category;
    }
    public String getDate() {
        return this.date;
    }
    public String getLink() {
        return this.link;
    }
}
