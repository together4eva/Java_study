package com.example.studySpringboot0001.temp.component;

import com.example.studySpringboot0001.temp.controller.stockController;
import org.springframework.stereotype.Component;

@Component
public class CalcComponent {

    //500px, 가장 비싼 주식(메서드로 구하기), 가장 싼 주식(메서드로 구하기)
    //MaxWidth, A값(Max), B값(min) > width: 200px;문자열에 값 넣기

    /**
     * @참조메서드 maxWidth_ratio(), high_stock_value(), low_stock_value()
     * @return css의 style width 문자열 값을 만들어서 출력하는 메서드
     */
    public static String style_text_max_width() {
        return "width: "+maxWidth_ratio(500, high_stock_value(), low_stock_value())+"px";
    }

    /**
     * @param maxWidth 전체 길이
     * @param maxValue 가장 비싼 주식
     * @param minValue 가장 싼 주식
     * @return 전체 길이 수치를 기준으로 가장 싼 주식의 길이를 출력하는 메서드
     */
    public static Integer maxWidth_ratio(
            Integer maxWidth,
            Integer maxValue,
            Integer minValue
    ) {
        return (int)(((double)maxWidth * (double) minValue) / (double)maxValue);
    }


    /**
     * @Since 가장 비싼 주식 구하는 메서드 : stock_list배열을 조회하여 가장 비싼 주식을 비교하여 출력
     * @Return Integer 값
     */
    public static Integer high_stock_value() {
        //검색 - 주식 1주 가격 꺼내오기
        int data1 = stockController.stock_list.get("애플").getOne_stock_money();
        int data2 = stockController.stock_list.get("삼성전자").getOne_stock_money();
        int data3 = stockController.stock_list.get("테슬라").getOne_stock_money();
        //검색 - 가장 비싼 주식 찾기
        Integer winStockPrice = data1;
        if(data1 >= data2) {
            if(data1 <= data3) {
                winStockPrice = data3;
            }
        }else {
            winStockPrice = data2;
            if(data2 <= data3) {
                winStockPrice = data3;
            }
        }
        return winStockPrice;
    }

    /**
     * @Since 가장 싼 주식 구하는 메서드 : stock_list배열을 조회하여 가장 싼 주식을 비교하여 출력
     * @Return Integer 값
     */
    public static Integer low_stock_value() {
        //검색 - 주식 1주 가격 꺼내오기
        int data1 = stockController.stock_list.get("애플").getOne_stock_money();
        int data2 = stockController.stock_list.get("삼성전자").getOne_stock_money();
        int data3 = stockController.stock_list.get("테슬라").getOne_stock_money();
        //검색 - 가장 작은 주식 찾기
        Integer loseStockPrice = data1;
        if(data1 >= data2) {
            loseStockPrice = data2;
            if(data2 >= data3) {
                loseStockPrice = data3;
            }
        }else {
            if(data1 >= data3) {
                loseStockPrice = data3;
            }
        }
        return loseStockPrice;
    }
}
