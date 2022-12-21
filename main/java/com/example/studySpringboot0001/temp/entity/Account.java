package com.example.studySpringboot0001.temp.entity;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;

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
    //getInfo() : 필드의 값을 조회하는 메서드
    public void getInfo() {
        System.out.println(this.id);
        System.out.println(this.pw);
        System.out.println(this.email);
        System.out.println(this.name);
    }
    public ArrayList<String> getViewInfo() {
        //<KEY, VALUE> map타입으로 return

        //가변배열로 묶어서 return하는 메서드
        ArrayList<String> returnData = new ArrayList<>();
        returnData.add(getId());
        returnData.add(getEmail());
        returnData.add(getName());
        return returnData;
    }
}
