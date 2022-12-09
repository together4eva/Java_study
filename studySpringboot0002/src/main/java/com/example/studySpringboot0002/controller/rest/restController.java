package com.example.studySpringboot0002.controller.rest;

import com.example.studySpringboot0002.entity.example.entityExample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

//@RestController : HTML 파일 경로를 찾지 않고, String 문자열(JSON)로 retrun하는 Controller = @ResponseBody
@RestController
public class restController {

    @GetMapping("/positionData")
    public Object positonData(){
        return null;
    }

    //String으로 전달
    @GetMapping("/restExample")
    public String restExample() {
        return "나는 김준석";
    }

    //1. entity return {}
    //2. arrayList return []
    //3. HashMap return {}
    //4. Integer return 숫자 = 클라이언트는 문자열

    //Entity(인스턴스)로 전달
    @GetMapping("entityExample")
    public Object entityExample() {
        entityExample result = new entityExample(10L, "김준석");
        entityExample result1 = new entityExample(10L, "박준석");
        entityExample result2 = new entityExample(10L, "이준석");
        ArrayList<entityExample> resultArray = new ArrayList<>();
        HashMap<String, entityExample> resultMap = new HashMap<>();
        resultArray.add(result);
        resultArray.add(result1);
        resultArray.add(result2);
        resultMap.put("1번", result);
        resultMap.put("2번", result2);
        Integer integerTest = 5000;
        String returnData = "김준석0001";
        return returnData;
    }
}
