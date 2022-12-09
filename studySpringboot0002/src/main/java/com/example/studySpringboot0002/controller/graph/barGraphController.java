package com.example.studySpringboot0002.controller.graph;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class barGraphController {

    @GetMapping("barGraph1")
    public String barGraph1() {
        return "graph/barGraph1";
    }
}
