package com.example.studySpringboot0001.temp.controller;

import com.example.studySpringboot0001.temp.entity.account.AccountImpl;
import com.example.studySpringboot0001.temp.controller.tempSaveData.saveData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class loginController {

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("fail_message", "");
        return "login/login";
    }

    //로그인을 성공하면 login_success.html로 이동
    //로그인을 실패하면 login.html로 이동하고 로그인이 실패했다는 메세지 출력
    //--1. html 하단에 model로 데이터 받은 실패 메세지 출력 (타임리프 문법 사용하기)
    //*타임리프 문법 중에 th:if문 혹은 ""값이 없는 key를 던져서 분기점 만들기
    //--2. 자바스크립트 alert() 함수를 출력하여 에러메세지 출력. 단, 에러메세지는 타임리프의 model데이터로 출력
    //*자바스크립트로 그래프 그리기를 참조
    @PostMapping("login")
    public String login_post(
            @RequestParam("id")String id,
            @RequestParam("pw")String pw,
            Model model
            ) {
        for(AccountImpl item : saveData.accountImplList) {
            if(item.getId().equals(id) && item.getPw().equals(pw)) {
                return "login/login_success";
            }
        }

        model.addAttribute("fail_message", "로그인이 실패했습니다");
        return "login/login";
    }
}
