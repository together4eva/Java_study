package com.example.studySpringboot0001.controller;

import com.example.studySpringboot0001.entity.PortfolioEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class portfolioController {

    static ArrayList<PortfolioEntity> arr = new ArrayList<>();

//    1. post 방식으로 데이터를 받아서 출력하기
//    1-1 하단에 있는 @GetMapping 메서드와 동일하게 코드를 작성
//    1-2 HTML에 TAG 속성 중 method를 POST로 변경

//    2. 상속 : extends : 부모 자산 물려받기(필드, 생성자 , 메서드)
//    account 클래스의 데이터를 portfolioEntity 클래스가 상속받아서
//    portfolioEntity에서 id/email,name 데이터를 출력하는 메서드를 만들고
//    html 테이블에서 출력하도록 구성하시오
//    portfolioEntity 인스턴스의 메서드 실행
//    인스턴스의 메서드 중에 super 클래스(부모 클래스)의 필드 값 중 id, email, name 값을 조회하여 출력하는 메서드
//    실행 시점을 HTML table에서 실행하기
//    먼저 부모 클래스의 인스턴스 생성 후



    @PostMapping("insertPortfolio")
//    public String insertPortfolio(PortfolioEntity portfolioEntity){
        public String insertPortfolio_post(
                //@RequestParam : 클라이언트에서 전달하는 데이터를 받는 어노테이션
                //value : form 태그의 name과 연결 (값이 같아야 함)
                //required = false : 값이 없어도 괜찮다고 선언
                @RequestParam(value = "title", required = false)String title,
                @RequestParam(value = "subject", required = false)String subject,
                @RequestParam(value = "category", required = false)String category,
                @RequestParam(value = "date", required = false)String date,
                @RequestParam(value = "link", required = false)String link,
                Model model
    ) {
            System.out.println("post 접속");
            System.out.println(title);
//        try {} 코드 안에서 에러가 생겼을 떄 바로 catch{}코드로 이동
//        catch {} 안에 코드가 실행
        int changeType;
        try{
//            Integer.parseInt(category) : category String 값을 int로 형변환 코드 실행
//            만일, 에러가 나면, catch로 이동
            changeType = Integer.parseInt(category);
        }catch(Exception exception){
            changeType = 0;
            System.out.println(exception.fillInStackTrace());
        }
        PortfolioEntity inputData = new PortfolioEntity(
                title, subject, changeType, date, link
        );
        return "portfolio/insertPortfolio";
        }


    @GetMapping("insertPortfolio")
    public String insertPortfolio(
            //@RequestParam : 클라이언트에서 전달하는 데이터를 받는 어노테이션
            //value : form 태그의 name과 연결 (값이 같아야 함)
            //required = false : 값이 없어도 괜찮다고 선언
            @RequestParam(value = "title", required = false)String title,
            @RequestParam(value = "subject", required = false)String subject,
            @RequestParam(value = "category", required = false)String category,
            @RequestParam(value = "date", required = false)String date,
            @RequestParam(value = "link", required = false)String link,
            Model model
    ) {
        if(category == null) {
            category = "0";
        }


        //1. HTML은 TEXT로 구성된 언어로써 int와 같은 정수 타입이 없다, A) 항상 받을 때는 String으로 바꾸기
        //2. @GetMapping으로 접근할 때 어떠한 값도 없이 @RequestParam으로 데이터를 받으므로,
        //NULL데이터로 입력받음 (초기 접근값)
        //3. NULL값을 받아서 Integer.parseInt메서드로 정수 변환이 불가능한 문제
        // A)NULL을 어떻게 처리? 숫자로 강제 변환하자!

        //클라이언트에서 데이터를 받아오고, 데이터 기반으로 인스턴스 객체 생성
        //타입 변수명 = new 타입;

        PortfolioEntity inputData = new PortfolioEntity(
                title, subject, Integer.parseInt(category), date, link
        );


        //생성된 객체를 배열에 저장 (추후에 데이터베이스에 저장)
        arr.add(inputData);

        //model를 활용해서 html에 전달
        model.addAttribute("arr", arr);
        return "portfolio/insertPortfolio";
    }

    //1. 중앙정렬
    //grid로 2*2를 만들어서, 0,0에 포트폴리오 입력 form을 넣고
    //0,1에 입력된 값을 출력하는 table을 넣어서 출력하시오
    //grid는 중앙정렬, table도 중앙정렬하여 출력하시오
}
