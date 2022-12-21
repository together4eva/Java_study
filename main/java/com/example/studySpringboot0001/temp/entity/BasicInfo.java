package com.example.studySpringboot0001.temp.entity;

import java.util.ArrayList;

public class BasicInfo {

    //필드
    private String ipAdr;
    public String resident;
    
    //생성자
    BasicInfo() {
        this.ipAdr = "값없음";
        this.resident = "값없음";
    }
    
    //메서드
    public ArrayList<String> getInfo() {
        ArrayList<String> returnData = new ArrayList<>();
        returnData.add(this.ipAdr);
        returnData.add(this.resident);
        return returnData;
    }
}
