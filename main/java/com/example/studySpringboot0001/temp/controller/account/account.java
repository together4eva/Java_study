package com.example.studySpringboot0001.temp.controller.account;

import com.example.studySpringboot0001.temp.repository.SignupExampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//mission : 회원가입을 완성하시오 (처음부터)
//1. view만들기 : templates/account/signupExample.html 을 만들어서 input_id/pw를 form태그를 만드시오
//2. @Controller 만들기 : controller/account/account.java 을 만들어서 @GetMapping("/signupExample")의 메서드를 만드시오
//3. Entity 만들기 : HTML form tag의 Name(KEY)에 맞춰서 id, input_id, pw 필드를 만들고 id는 @Id옵션 넣어 PK값으로 할당하시오
//4. Repository 만들기 : JpaRepository를 상속받는 repository/SignupExampleRepository 인터페이스를 만드시오
//5. @Controller 완성하기 : @Autowired 어노테이션을 갖는 SignupExampleRepository 필드값을 추가하고,
//SignupExampleRepository의 save 메서드에 Entity 인스턴스를 인자값으로 넣는 코드를 완성하시오
//6. DB에 잘 들어갔는지 확인하기

//mission. 클라이언트가 데이터 컬럼의 수정사항을 요청할 때
//1. 기존에 필드값에 name, email을 추가하고 id를 index로 바꾸시오 : entity 필드값 변경 혹은 추가
// + application.properties의 spring.jpa.hibernate.ddl-auto 변수를 변경
//2. 변경된 필드값에 맞춰 springboot와 html내용, mysql도 변경하시오 : 1번을 해결하면 springboot가 자동으로 변경
// + html form 구조 변경 + @RequestParam 추가

@Controller
public class account {

    @Autowired
    private SignupExampleRepository signupExampleRepository;

    Long inject = 1L;

    @GetMapping("/signupExample")
    public String signupExample(@RequestParam(value = "input_id", required = false)String input_id,
                              @RequestParam(value = "pw", required = false)String pw,
                                @RequestParam(value = "email", required = false)String email,
                                @RequestParam(value = "name", required = false)String name
                              ) {
        inject++;
//        signupExampleRepository.save(new SignupExample(inject, input_id, pw, email, name));
        return "account/signupExample";
    }
}
