package com.example.studySpringboot0002.controller.graph;

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
    @GetMapping("barGraph2")
    public String barGraph2() {
        return "graph/barGraph2";
    }
    @GetMapping("barGraph3")
    public String barGraph3() {
        return "graph/barGraph3";
    }
    @GetMapping("barGraph4")
    public String barGraph4() {
        return "graph/barGraph4";
    }




}
