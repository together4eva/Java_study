package com.example.studySpringboot0001.controller;

import com.example.studySpringboot0001.entity.PortfolioEntity;
import com.example.studySpringboot0001.entity.Signup;
import com.example.studySpringboot0001.entity.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;


//accounts.add(new Account(id1, pw1, email1, name1)); 배열에 새로운 인스턴스 계속 추가
//model.addAttribute("accountList", accounts); : model에 배열을 전달
//HTML에서 each 반복문 item : ${accountList} = (하나의 인스턴스 : ${배열명}) 데이터 하나씩 출력

//20221129 todo
//1. override : 메서드 재정의 : 동일한 메서드 명으로 다른 기능을 함으로써 메서드 명의 정의를 지속적으로 사용
//getInfo() : 인스턴스의 필드 조회라는 메서드 규칙(정의)를 계속 재정의(override)함으로써 기능 유지
//2. overloading(HashMap) : 생성자의 매개변수 갯수, 타입을 다양하게 함으로써 여러가지의 인스턴스 다양성를 생성
//3. CSS 상속 : header 만들기
//----CSS class는 하나의 tag에 속성 적용하되, 부모 속성이 동일할 경우 자식 속성이 덮어써서 적용됨
//----

@Controller
public class accountController {

//    static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Signup> signups = new ArrayList<>();
    static int count = 0;

//    @GetMapping("insertAccount")
//    public String insertAccount(
//            @RequestParam(value = "id", required = false)String id1,
//            @RequestParam(value = "pw", required = false)String pw1,
//            @RequestParam(value = "email", required = false)String email1,
//            @RequestParam(value = "name", required = false)String name1,
//            Model model
//            ) {
//
//        //new Account() : 새로 인스턴스 생성 : heap메모리에 새로 만들어서 전달 >> accounts배열에 전달
//        //(id1, pw1, email1, name1) : 생성자에 선물에 4개의 인자값 전달하여 인스턴스 생성
//        accounts.add(new Account(id1, pw1, email1, name1));
//        //(타입 변수명 : 배열)
//        model.addAttribute("accountList", accounts);
//        return "account/insertAccount";
//    }

    @GetMapping("signup")
    public String signup() {
        return "account/signup";
    }

    @GetMapping("signup_list")
    public String signup_list(Model model) {
        model.addAttribute("signup_list", signups);
        return "account/signup_list";
    }

    @PostMapping("signup")
    public String signup_post(
            @RequestParam(value = "id", required = false)String id,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "pw", required = false)String pw,
            @RequestParam(value = "email", required = false)String email,
            Model model
    ) {
        //@RequestParam(value="id"....
        //Signup signup = new Signup(매개변수);
        //*key값이 동일하면 value는 덮어써진다
        HashMap<String, String> input = new HashMap<>();
        input.put("id", id);
        input.put("name", name);
        input.put("pw", pw);
        input.put("email", email);
        Signup signup = new Signup(input);
        //* Map으로 생성자 매개변수 전달 <> Instance로 생성자 매개변수 전달
        signups.add(signup);

        Signup.setCount();
        return "login/login";
    }

}
