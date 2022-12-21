package com.example.studySpringboot0001.temp.controller.restController;

import com.example.studySpringboot0001.temp.entity.test2Entity;
import com.example.studySpringboot0001.temp.repository.Test2EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



//mission2 : 로그인 기능을 알아서 만드시오. (input_id/pw 값을 꺼내서 비교하고 로그인 완성)

//@RestController : controller 종류 중 하나로 HTML이 아니라 문자열만 return
//다른 서버와 통신을 위한 controller (flask, another spring..)
@RestController
public class JPAExampleController {

    @Autowired
    private Test2EntityRepository test2;

    //Object : 모든 참조 타입의 부모이기 때문에 어떤 참조 타입의 return 가능
    @GetMapping("/jap_example")
    public Object jap_example() {
        //DB에 접속해서 값 가져오기
        test2.save(new test2Entity(1L, "김준석"));
        return null;
    }
}
