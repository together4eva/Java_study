package com.example.studySpringboot0001.temp.controller;

import com.example.studySpringboot0001.temp.entity.Stock;
import com.example.studySpringboot0001.temp.entity.StockLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.studySpringboot0001.temp.component.CalcComponent.style_text_max_width;

//1. static = 서버 기동시 초기값 설정과 1개만 존재
//2. return redirect:/stock >> @GetMapping("stock")으로 이동
//3. spring boot에서 구조 설계 기획 (플로우차트, class diagram)

/*
20221202 week todo
               
1. Client와 Server(@GetMapping과 HTML)의 흐름
---- Client의 URL요청에 따라 @GetMapping 메서드가 실행되고 HTML에 Model전달하여 Client에 표시
2. data의 객체 정의
---- Stock(각 주식의 메타데이터) / StockLog(주식 구매 기록)/ Signup(회원가입 정보)
---- 반복적으로 생성되는 데이터를 체계화 필드값을 정의하고 설계하는 방법
3. class와 상속
---- class(this)의 필드, 생성자, 메서드 개념을 나누고 기능 사용 / extends 문법으로 부모 클래스 자원을 물려받음(super)
4. memory의 instance와 static
---- instance : class(설계도)기반으로 데이터 필요에 따라 지속적 객체 생성
---- static : 1개의 공용 데이터로 서버가 실행될 때 JVM이 만듬
5. grid와 flex
---- flex의 1차원배열 표현, grid의 2차원배열 표현
6. Javascript와 css의 타임리프문법 적용             
---- css : th:attrappend="style=${MODEL의 KEY}
---- javascript : th:inline="javascript"
7. 시점에 따른 개발자의 기술
---- 사용자 시점에서 서비스를 어떻게 제공해야 되는지,
---- 개발자와 커뮤니케이션을 위해 어떻게 코드를 작성해야 하는지,
---- 컴퓨터에게 좋은 코드란 무엇인지.
*/


@Controller
public class stockController {

    public static HashMap<String, Stock> stock_list = new HashMap<>(){{
        put("삼성전자", new Stock("삼성전자"));
        put("애플", new Stock("애플"));
        put("테슬라", new Stock("테슬라"));
    }};

    /**
     * @Since 주식 구매 기록 저장 : static 공용데이터
     */
    public static ArrayList<StockLog> stockLogs = new ArrayList<>();

    //mission : stockTable() 메서드를 완성하여 stock/stockTable.html에 로그 정보를 출력하시오
    //1. 로그정보는 숫자로 구성되어 있는 문자열(String)으로 전달 : plot에서 해석할 수 있는 포맷 형식이 숫자 문자열
    //2. 배열로 전달된 값을 그래프로 표기
    @GetMapping("/stockTable")
    public String stockTable(Model model) {
        model.addAttribute("stock_logs", stockLogs);
        //(삼성전자)x축 데이터 시각과 y축 데이터 1주당 가격을 모델에 넣기
        ArrayList<Integer> samsungXdataTime = new ArrayList<>();
        ArrayList<Integer> samsungYdataPrice = new ArrayList<>();
        //(애플)x축 데이터 시각과 y축 데이터 1주당 가격을 모델에 넣기
        ArrayList<Integer> appleXdataTime = new ArrayList<>();
        ArrayList<Integer> appleYdataPrice = new ArrayList<>();
        //(테슬라)x축 데이터 시각과 y축 데이터 1주당 가격을 모델에 넣기
        ArrayList<Integer> teslaXdataTime = new ArrayList<>();
        ArrayList<Integer> teslaYdataPrice = new ArrayList<>();

        //배열의 갯수 확인 변수
        int count_samsung = 0;
        int count_apple = 0;
        int count_tesla = 0;

        //stockLogs배열의 0부터 끝까지 조회해서 > samsungXdataTime 배열에 저장
        //model 전달할 데이터 배열에 값 넣기
        //for(초기식;조건식;증감식)
        for(int i=stockLogs.size()-1; i>=0; i--) {
            if(stockLogs.get(i).getCompany_name().equals("삼성전자")) {
                count_samsung++;
                if(count_samsung <= 100) {
                    samsungXdataTime.add(Integer.parseInt(stockLogs.get(i).getTime()));
                    samsungYdataPrice.add(stockLogs.get(i).getBuy_one_stock_price());
                }
            }
            if(stockLogs.get(i).getCompany_name().equals("애플")) {
                count_apple++;
                if(count_apple <= 100) {
                    appleXdataTime.add(Integer.parseInt(stockLogs.get(i).getTime()));
                    appleYdataPrice.add(stockLogs.get(i).getBuy_one_stock_price());
                }
            }
            if(stockLogs.get(i).getCompany_name().equals("테슬라")) {
                count_tesla++;
                if(count_tesla <= 100) {
                    teslaXdataTime.add(Integer.parseInt(stockLogs.get(i).getTime()));
                    teslaYdataPrice.add(stockLogs.get(i).getBuy_one_stock_price());
                }
            }
        }


        //모델에 저장하기
        model.addAttribute("xdataSamsung", samsungXdataTime);
        model.addAttribute("ydataSamsung", samsungYdataPrice);
        model.addAttribute("xdataApple", appleXdataTime);
        model.addAttribute("ydataApple", appleYdataPrice);
        model.addAttribute("xdataTesla", teslaXdataTime);
        model.addAttribute("ydataTesla", teslaYdataPrice);


        //progress bar 데이터
        String result1 = style_text_max_width();
        String result2 = "width: 300px;";
        String result3 = "width: 400px;";
        ArrayList<String> resultArray = new ArrayList<>();
        resultArray.add(result1);
        resultArray.add(result2);
        resultArray.add(result3);
        model.addAttribute("progress_array", resultArray);
        return "stock/stockTable";
    }

    @GetMapping("/stock")
    public String stock(Model model) {
        model.addAttribute("stock_list", stock_list);
        return "stock/stock";
    }
    @GetMapping("/stock_buy")
    public String stock_buy(
            @RequestParam(value = "company_name", required = false)String company_name,
            @RequestParam(value = "stock_buy_count", required = false)String stock_buy_count
    ) {
        for(Stock item : stock_list.values()) {
            if(company_name.equals(item.getCompany_name())) {
                stock_list.get(company_name).setStock_count(stock_list.get(company_name).getStock_count()-1);
                stock_list.get(company_name).setOne_stock_money(calc_stock(Integer.parseInt(stock_buy_count), company_name));
                System.out.println(stock_list.get(company_name).getOne_stock_money());
            }
        }
//
//        if(!data1.equals("0")) {
//            stock_list.get(data1).setStock_count(stock_list.get(data1).getStock_count()-1);
//            stock_list.get(data1).setOne_stock_money(calc_stock(1, data1));
//            System.out.println(stock_list.get(data1).getOne_stock_money());
//        }
//        if(!data2.equals("0")) {
//            stock_list.get(data2).setStock_count(stock_list.get(data2).getStock_count()-3);
//            stock_list.get(data2).setOne_stock_money(calc_stock(3, data2));
//            System.out.println(stock_list.get(data2).getOne_stock_money());
//        }
//        if(!data3.equals("0")) {
//            stock_list.get(data3).setStock_count(stock_list.get(data3).getStock_count()-5);
//            stock_list.get(data3).setOne_stock_money(calc_stock(5, data3));
//            System.out.println(stock_list.get(data3).getOne_stock_money());
//        }

        //HTML로 이동하는 것이 아니라, @GetMapping("/stock")으로 이동
        return "redirect:/stock";
    }

    static public Integer calc_stock(Integer baseData, String company_name) {
        double result = (double) stock_list.get(company_name).getOne_stock_money() +
                ((double)stock_list.get(company_name).getOne_stock_money()*((double)baseData/100.0));
        return (int) result;
    }
}
