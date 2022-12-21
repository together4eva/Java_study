package com.example.studySpringboot0001.controller.graph;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 그래프 html 파일 연동하는 controller
 */
@Controller
public class barGraphController {
    /**
     *
     * @return URL Source
     */
    @GetMapping("barGraph1")
    public String barGraph1() {
        return "graph/barGraph1";
    }
}
