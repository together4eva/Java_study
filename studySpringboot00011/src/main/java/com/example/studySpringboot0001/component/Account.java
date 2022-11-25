package com.example.studySpringboot0001.component;

import org.springframework.stereotype.Component;

//Springboot가 본 클래스를 객체(인스턴스)로 검색할 수 있도록 선언
public class Account {
    //필드
    String id;
    String pw;
    String email;
    String name;

    //생성자
    public Account(String id, String pw, String email, String name) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.name = name;
    }

    public String getId() {
        return this.id;
    }
    public String getPw() {
        return this.pw;
    }
    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }

    //메서드
    public void getInfo() {
        System.out.println(this.id);
        System.out.println(this.pw);
        System.out.println(this.email);
        System.out.println(this.name);
    }
}
