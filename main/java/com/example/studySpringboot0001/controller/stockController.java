package com.example.studySpringboot0001.controller;

import com.example.studySpringboot0001.entity.Stock;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class stockController {

    static private HashMap<String, Stock> stock_list = new HashMap<>(){{
        put("삼성전자", new Stock("삼성전자"));
        put("애플", new Stock("애플"));
        put("테슬라", new Stock("테슬라"));
    }};

    @GetMapping("/stock")
    public String stock(Model model) {
        model.addAttribute("stock_list", stock_list);
        return "stock/stock";
    }
    @GetMapping("/stock_buy")
    public String stock_buy(
            @RequestParam(value = "button1", required = false)String data
    ) {
        stock_list.get(data).setStock_count(stock_list.get(data).getStock_count()-1);
        //HTML로 이동하는 것이 아니라, @GetMapping("/stock")으로 이동
        return "redirect:/stock";
    }

    public Integer calc_stock(Integer baseData, String companey_name){
        Integer resultl= stock_list.get(companey_name).getOne_stock_money() +
                stock_list.get(companey_name).getOne_stock_money()*(baseData/100);
        System.out.println(resultl);
        return resultl;
    }
}
