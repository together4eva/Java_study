package com.example.studySpringboot0001.controller;

import com.example.studySpringboot0001.component.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


//accounts.add(new Account(id1, pw1, email1, name1)); 배열에 새로운 인스턴스 계속 추가
//model.addAttribute("accountList", accounts); : model에 배열을 전달
//HTML에서 each 반복문 item : ${accountList} = (하나의 인스턴스 : ${배열명}) 데이터 하나씩 출력

@Controller
public class accountController {

    static ArrayList<Account> accounts = new ArrayList<>();

    @GetMapping("insertAccount")
    public String insertAccount(
            @RequestParam(value = "id", required = false)String id1,
            @RequestParam(value = "pw", required = false)String pw1,
            @RequestParam(value = "email", required = false)String email1,
            @RequestParam(value = "name", required = false)String name1,
            Model model
            ) {

        //new Account() : 새로 인스턴스 생성 : heap메모리에 새로 만들어서 전달 >> accounts배열에 전달
        //(id1, pw1, email1, name1) : 생성자에 선물에 4개의 인자값 전달하여 인스턴스 생성
        accounts.add(new Account(id1, pw1, email1, name1));
        //(타입 변수명 : 배열)
        model.addAttribute("accountList", accounts);
        return "account/insertAccount";
    }

}
