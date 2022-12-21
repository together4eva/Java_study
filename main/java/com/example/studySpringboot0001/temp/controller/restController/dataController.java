package com.example.studySpringboot0001.temp.controller.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.HashMap;

//HTML 파일이 아니라 문자열로 전달
@RestController
public class dataController {

    //@GetMapping : URL 요청 받음
    //public Object : 외부에서 접근가능 + return 타입은 모두 가능(Object)
    @GetMapping("/data/randomPosition")
    public Object randomPostion(
            @RequestParam(value = "id",required = false)String id,
            @RequestParam(value = "pw",required = false)String pw
            ) {
        if(id==null) {
            id = "없음";
        }
        if(pw==null) {
            pw= "없음";
        }

        //1. Class 인스턴스 만들어서 return (규칙, 원칙 정하는 거 좋아하는 분)

        //2. String문자열 return (내 맘대로 만들어서 return)

        //3. ArrayList/Map return (자바에서 만든 타입대로 전달하는 거 좋아하는 분)
        //Map 타입은 KEY, VALUE로 데이터 저장

//        String returnData = Integer.toString((int)(Math.random()*11));
        String resultWord = "";
        if(id.equals("kim")) {
            resultWord = "true";
        }else {
            resultWord = "false";
        }

        HashMap<String, String> result = new HashMap<>();
//        HashMap<String, String> position = new HashMap<>();
        result.put("result", resultWord);
        //put() : 저장하기
//        result.put("header", "type=application/json, solution=change postion");
//        result.put("body", position);
//        System.out.println(result);
        return result;
    }
}
