package com.example.studySpringboot0001.temp.controller.restController;

import com.example.studySpringboot0001.temp.entity.testEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping("/restController")
    public Object restController() {
        testEntity result = new testEntity(1L, "abcd", "1234", "김준석");
        return result;
    }
}
