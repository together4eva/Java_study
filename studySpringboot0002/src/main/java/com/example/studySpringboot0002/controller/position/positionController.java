package com.example.studySpringboot0002.controller.position;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

//@Controller : HTML로 연결
@Controller
public class positionController {
    @GetMapping("positon/input")
    public String input_get(){
        return "position/input";
    }
    @PostMapping("position/input")
    public String input(
            @RequestParam("category")String category,
            @RequestParam("name")String name,
            Model model
    ){
        try{
            URL url = new URL("http://192.168.42.100:8090/data/randomPosition?name="+name+"&category="+category);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            String returnLine = bufferedReader.readLine();

        }catch (Exception e){

        }
        HashMap<String,String> result = new HashMap<>();
        String positionData = "";
        result.put(name, positionData);

        String resultData =
        model.addAttribute("resultData",resultData);
        model.addAttribute("name",name);


        return "position/position";
    }

    @GetMapping("result/position")
    public String position() {

        //메모리 주소 변경없이 데이터 변화
        StringBuffer result = new StringBuffer();

        String returnLine = "";

        //try {} 코드에서 에러가 나면 catch 로 빠져나감 : 네트워크 연결의 불안성 때문에 자바에서 try/catch 강제함
        try {
            URL url = new URL("http://192.168.42.100:8090/data/randomPosition"); // URL 주소로 연결하는 객체
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(); // Http 프로토콜로 연결
            httpURLConnection.connect(); //url주소로 연결 (서로 소통 됨)

            BufferedInputStream bufferedInputStream = new BufferedInputStream(
                    httpURLConnection.getInputStream()); //바아트 배열로 데이터 받아옴
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream)); //조각난 바이트 배열 합치기

            //영어권 네트워크, 컴퓨터 = 2진수 <> 문자열 (영어) << 한글/아랍어/중국어..
            returnLine = bufferedReader.readLine();

        }catch (Exception e) {

        }

        System.out.println(returnLine);

        return null;
    }


}