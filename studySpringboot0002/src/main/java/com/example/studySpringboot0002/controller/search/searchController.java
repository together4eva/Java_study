package com.example.studySpringboot0002.controller.search;

import com.example.studySpringboot0002.entity.search.searchHistory;
import com.example.studySpringboot0002.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//dispaherServlet이 클라이언트 마다 할당되어서 @Controller에 에스코스
//이후 service 또는 repository 또는 html(model)에 이동을 안내해 줌
@Controller
public class searchController {

    private final SearchService searchService;

    @Autowired
    public searchController(SearchService service) {
        this.searchService = service;
    }

    @PostMapping("search")
    public String search(
            @RequestParam(value = "search", required = false)String searchData,
            Model model
    ) {
        this.searchService.saveSearchHistory(new searchHistory(10L, searchData, "ip_example", "time_example"));
        return "resultDB/search";
    }
}