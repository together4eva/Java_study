package com.example.studySpringboot0001.temp.controller;

import com.example.studySpringboot0001.temp.entity.PortfolioEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//1. post방식으로 데이터를 받아서 출력하기 (DOM 이해하기)
//2. 상속 : extends : 부모 자산 물려받기(필드, 생성자, 메서드) = 클래스 구조를 다양하게 만들고 활용

@Controller
public class portfolioController {

    static ArrayList<PortfolioEntity> arr = new ArrayList<>();

    //1. post방식으로 데이터를 받아서 출력하기 (DOM 이해하기)
    //1-1. 하단에 있는 @GetMapping 메서드와 동일하게 코드를 작성
    //1-2. HTML에 tag속성 중 method를 POST로 변경
    
    //*자식클래스의 인스턴스 만들 때, 부모클래스가 생성되어야 만들어짐!!
    //2. 상속 : extends : 부모 자산 물려받기(필드, 생성자, 메서드) = 클래스 구조를 다양하게 만들고 활용
    //Account 클래스의 데이터를 portfolioEntity 클래스가 상속을 받아서,
    //portfolioEntity에서 id/email,name 데이터를 출력하는 메서드를 만들고 HTML 테이블에서 출력하도록 구성하시오
    //PortfolioEntity 인스턴스의 메서드 실행
    //인스턴스의 메서드 중에 super클래스(부모클래스)의 필드 값 중 id, email, name값을 조회하여 출력하는 메서드 만들고 실행
    //실행 시점을 HTML table에서 실행하기
    // A) 자식클래스를 새로 생성(new 인스턴스) 할 때,
    // 먼저, 부모클래스의 인스턴스 생성 후(super();) 최종적으로 자식클래스 생성
    // 부모클래스의 메서드는 자식 인스턴스가 실행 가능

    //*HTML form tag에 enctype="multipart/form-data" : byte[]로 서버에 데이터를 전달한다는 선언
    //3. CSS(GRID/TABLE)로 게시판 꾸미기
    //portfolio 객체를 출력하는 HTML를 구현하시고,
    //3-1. 링크를 클릭하면 이미지가 출력되는 테이블 컨텐츠를 만드시오.
    //<a>문자열</a> : 문자열을 클릭하면 link위치로 이동
    //ex) <a href="/rps">가위바위보 게임으로 이동</a>
    //테이블(혹은 GRID)구조로 title, subject.. link컬럼에는 <a>링크로 클릭하면 이미지 전체화면이 출력되는
    //구조로 포트폴리오 목록 페이지를 작성하시오. (listPortfolio.html파일과 @GetMapping("listPortfolio")..등등
    //하단에 insertPortfolio로 이동하는 <a>링크를 추가하고,
    //insertPortfolio.html에서는 listPortfolio.html로 이동하는 링크를 서로 작성하여 이동 가능토록 구성하시오

    // MultipartFile는 byte[] getBytes() throws IOException; 메서드로 데이터를 순차적으로 저장하여
    // 가져오는 객체
    @PostMapping("insertPortfolio")
    public String insertPortfolio_post(
            @RequestParam(value = "title", required = false)String title,
            @RequestParam(value = "subject", required = false)String subject,
            @RequestParam(value = "category", required = false)String category,
            @RequestParam(value = "date", required = false)String date,
            @RequestParam(value = "link", required = false)String link,
            @RequestParam(value = "file_upload", required = false) MultipartFile file_upload,
            Model model
            ) throws IOException {
        System.out.println("POST로 접속");
        System.out.println(file_upload.getName());
        System.out.println(file_upload.getOriginalFilename());
        //File : 실제로 저장된 파일의 메타정보를 저장하는 객체
        File saveFileName = new File(file_upload.getOriginalFilename());
        //서버에 특정 폴더(application.properties:springboot에서 사용하는 상수저장 파일)에 파일 저장
        file_upload.transferTo(saveFileName);
        int changeType;
        //try {} 코드 안에서 에러가 생겼을 때, 바로 catch{} 코드로 이동
        //catch {} 안에 코드가 실행
        try {
            //Integer.parseInt(category) : category String 값을 int로 형변환 코드 실행(메서드)
            //만일, 에러가 나면, catch로 이동
            changeType = Integer.parseInt(category);
            //Exception 에러에 관한 모든 정보를 담고 있는 객체(인스턴스)
        }catch (Exception exception) {
            changeType = 0;
            System.out.println(exception.fillInStackTrace());
        }
        String imgLink = "http://localhost:8080/image/"+file_upload.getOriginalFilename();
        //img업로드 시,
        PortfolioEntity inputData = new PortfolioEntity(
                title, subject, changeType, date, imgLink
        );
        //getInfo() : 부모클래스(account)의 getInfo(); 메서드
        inputData.getInfo();
        arr.add(inputData);

        model.addAttribute("arr", arr);
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
        System.out.println("GET로 접속");
        //Integer : 참조타입(메모리 heap)의 int
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
        int changeType;
        try {
            changeType = Integer.parseInt(category);
        }catch (Exception e) {
            changeType = 0;
        }
            PortfolioEntity inputData = new PortfolioEntity(
                    title, subject, changeType, date, link
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

    @GetMapping("listPortfolio")
    public String listPortfolio(Model model) {
        //model 객체 : 장바구니 : model은 springboot Container에서 자동 생성되어 주입된다
        model.addAttribute("arr", arr);
        return "portfolio/listPortfolio";
    }
}
