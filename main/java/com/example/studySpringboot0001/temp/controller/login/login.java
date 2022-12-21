package com.example.studySpringboot0001.temp.controller.login;

import com.example.studySpringboot0001.temp.entity.account.SignupExample;
import com.example.studySpringboot0001.temp.repository.SignupExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

//mission : login기능을 추가하시오
//1. html form tag만들기 (input_id, pw를 입력받는 form)
//2. controller 만들기 (@RequestParam으로 클라이언트 데이터를 받기)
//3. Repository 주입 받기 (@Autowired를 써서 Repository 메서드 활용가능한 필드 만들기)
//4. Repository.?() 메서드를 사용하여 튜플 모두 가져오기 (혹은 특정 튜플만 가져오는 메서드 실행)
//5. 가져온 튜플과 클라이언트에서 받아온 input_id/pw를 비교해서 같은 값이 있는지를 html로 메세지 전달하기

@Controller
public class login {

    @Autowired
    private SignupExampleRepository signupExampleRepository;

    @GetMapping("/loginExample")
    public String loginExample(Model model) {
        model.addAttribute("loginMessage", "login");
        return "login/loginExample";
    }

    @PostMapping("/loginExample")
    public String loginExample_post(@RequestParam(value = "input_id", required = false)String input_id,
                                    @RequestParam(value = "pw", required = false)String pw,
                                    Model model

    ) {
        //signupExampleRepository.findAll(); : repository의 findAll() 이라는 메서드를 실행 : 모든 튜플값 가져오기
        //*repository 인터페이스를 조회하여 주석으로 유추(설명서 읽기)
        //List<SignupExample> result = : findAll() 메서드의 return 타입이 List<T> 이므로, list타입으로 변수 선언
        // : List 안에 데이터 타입은 SignupExample 인스턴스
        List<SignupExample> result = signupExampleRepository.findAll();
        System.out.println(result.size());
        System.out.println(result.get(0).getInput_id());
        String message = "";

        //result 라는 변수의 길이 만큼 for(반복문)을 돌리겠다 + i는 0부터 시작해서 한 번 반복할 때마다 1씩 증가
        for(int i = 0; i<result.size(); i++) {
            //result의 i번째 칸에 있는 SignupExample 인스턴스의 getInput_id() 메서드를 실행하여 가져온 input_id의 필드값과
            //매개변수 input_id를 비교한다 (equals())
            if(result.get(i).getInput_id().equals(input_id)) {
                //result의 i번째에 있는 인스턴스의 pw값과
                //매개변수 pw의 값을 equals메서드로 비교
                if(result.get(i).getPw().equals(pw)) {
                    //로그인 성공
                    message = "success";
                    break;
                } else {
                    message = "fail";
                }
            } else {
                message = "fail";
            }
        }
        model.addAttribute("loginMessage", message);
        return "login/loginExample";
    }
}
