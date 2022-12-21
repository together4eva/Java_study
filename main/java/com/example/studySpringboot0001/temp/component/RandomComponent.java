package com.example.studySpringboot0001.temp.component;

import com.example.studySpringboot0001.temp.entity.StockLog;
import com.example.studySpringboot0001.temp.controller.stockController;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//20221201 mission
//1. stockLogs배열에 있는 데이터 기반으로 stock/stockTable.html에 차트그래프를 그리는 코드를 구현하시오
//css(일반 css), javascript(plotly lib) 중 선택하여 차트그래프 모형으로 그리시오.
//x축은 시각, y축은 가격으로 표기하시오.

//인터럽트 : 2개 이상의 작업(일꾼, 쓰레드)가 하나의 자원을 접근하여 순서적인 문제가 발생하는 이슈
//예) 메서드1과 메서드2가 동시에 실행 될 때 (유저A, 유저B가 동시에 메서드 실행될 때) 변수의 값이 변경 실행시의 문제


//@Component = @Controller 속성 선언(검색)
@Component
public class RandomComponent {


    //public : 외부 패키지의 class에서 사용할 수 있도록 오픈
    //static : 인스턴스 안 만들어도 사용 : 1개만 존재
    public static String random(int maxInt) {
        //(Math.random()*100) 0.000~99.999숫자 중에 랜덤으로 하나 출력
        //(int)(Math.random()*100) : int로 형변환 : 소수점 자르기
        //Integer.toString() : int를 String문자열로 형변환
        return Integer.toString((int)(Math.random()*maxInt));
    }

    public static int randomInt(int maxInt) {
        return (int)(Math.random()*maxInt);
    }

    public static String randomColor() {
        String[] randomColor = {"yellow","red","blue","black"};
        //random(4) : 랜덤으로 maxRandom 인자값 기준으로 뽑기
        //Integer.parseInt() : int로 형변환
        //randomColor[] : 고정배열에 몇 번 째 칸에 있는 String 값 뽑아오기
        return randomColor[Integer.parseInt(random(4))];
    }

    //int같은 숫자 연산은 2진수를 거치기 때문에 정확하지 않다! (Bigdecimal 타입 활용)
    //max값 안에서 3등분을 랜덤으로 출력하기
    public static String[] thirdGraph(String maxHeight) {
        //매개변수 maxHeight타입을 int로 변환
        int maxHeightInt = Integer.parseInt(maxHeight);
        //maxHeightInt 값보다 적은 숫자의 랜덤 출력
        int data0001 = Integer.parseInt(random(maxHeightInt));
        //maxHeightInt - data0001 값보다 작은 숫자 랜덤 출력
        int data0002 = Integer.parseInt(random(maxHeightInt-(data0001)));
        int data0003 = maxHeightInt-(data0001)-(data0002);
//        String[] result = {Integer.toString(data0001), Integer.toString(data0002), Integer.toString(data0003)};

        String abc = new String();
        //매개변수 maxHeight타입을 BigDecimal로 변환
        BigDecimal maxHeightBigDecimal = new BigDecimal(maxHeight);
        //maxHeightInt 값보다 적은 숫자의 랜덤 출력
        BigDecimal data0011 = new BigDecimal(random(maxHeightInt));
        BigDecimal data0012 = new BigDecimal(random(Integer.parseInt((maxHeightBigDecimal.subtract(data0011)).toString())));
        BigDecimal data0013 = maxHeightBigDecimal.subtract(data0011).subtract(data0012);

        String[] result = {data0011.toString(), data0012.toString(), data0013.toString()};
        return result;
    }

    public void stock_buy(String lowStockName, Integer buy_count) {
        stockController.stock_list.get(lowStockName).setOne_stock_money(stockController.calc_stock(buy_count, lowStockName));
    }

    //mission : 검색(10초당 3개 주식 중 가장 작은 가격의 주식 1주)를 기능(구매하는) 스케쥴링을 구현하시오
    //구매 후 어떤 회사의 1주를 구매했는지 System.out.println으로 출력하시오 (이후, 다 완성되면 구매 정보를 저장하는 배열을 만들어보시오)
    //mission2 :
    //*기능(구매)로 구현한 코드를 메서드로 만들어서 갖다가 쓰도록 리팩토링하시오
    //구매 정보를 저장하는 배열을 만들어보시오 = (stockController에 전역변수 ArrayList<StockLog>를 만드시고), 지속적으로 저장하시오.
    //단, (StockLog 클래스에서는 필드값 time, company_name, buy_count 3개의 변수를 선언하고, 인스턴스)를 만들어 배열에 저장하시오
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduled_one_stock_buy() {
        //* stockController에 stock_buy을 참조하여 만드시오
        //검색 - 주식 1주 가격 꺼내오기
        int data1 = stockController.stock_list.get("애플").getOne_stock_money();
        int data2 = stockController.stock_list.get("삼성전자").getOne_stock_money();
        int data3 = stockController.stock_list.get("테슬라").getOne_stock_money();
        //검색 - 가장 작은 주식 찾기
        String loseStockName = "애플";
        Integer loseStockPrice = data1;
        if(data1 >= data2) {
            loseStockName = "삼성전자";
            loseStockPrice = data2;
            if(data2 >= data3) {
                loseStockName = "테슬라";
                loseStockPrice = data3;
            }
        }else {
            if(data1 >= data3) {
                loseStockName = "테슬라";
                loseStockPrice = data3;
            }
        }
        //기능(구매)
        System.out.println("현재 가장 저렴한 주식은 "
                +loseStockName
                +"이며, "
                + stockController.stock_list.get(loseStockName).getOne_stock_money());
        stock_buy(loseStockName, 1);
        System.out.println(loseStockName+" 주식을 1주 샀습니다");


        //시간을 출력하는 객체 중 LocalDateTime타입
        LocalDateTime dateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HHmmss");
        String logDate = dateTime.format(formatter);
        System.out.println(logDate);

        //로그저장 (항상 시각 기록)
        stockController.stockLogs.add(new StockLog(logDate, loseStockName, 1, loseStockPrice));
    }

    //mission : 스케쥴링을 활용하여
    //전역변수 signups와 전역변수 stock_list의 값을 지속적으로 출력하도록 메서드를 완성하고 출력하시오 (반복문 활용)
    @Async
    @Scheduled(fixedRate = 1000)
    public void scheduled_example() throws InterruptedException {
        System.out.println("------------scheduled");

//        //배열은 size가 있음, 인덱스(칸 번호) 필요
//        for(int i =0; i<signups.size(); i++) {
//            signups.get(i).getInfo();
//        }
//        //map도 사이즈 있음, get() 꺼내올 때 인덱스(칸 번호) 필요 없음
//        //map타입은 key, value로 되어 있기 때문에 반복문으로 꺼내오는 것은 value라고 코드 작성 필요 = stock_list.values()
//        for(Stock item : stock_list.values()) {
//            System.out.println(item.getCompany_name());
//        }

        int index = randomInt(6);
        if(index == 0) {
            stockController.stock_list.get("애플").setOne_stock_money(stockController.calc_stock(1, "애플"));
        }else if (index == 1) {
            stockController.stock_list.get("삼성전자").setOne_stock_money(stockController.calc_stock(1, "삼성전자"));
        } else if (index == 2) {
            stockController.stock_list.get("테슬라").setOne_stock_money(stockController.calc_stock(1, "테슬라"));
        } else if (index == 3) {
            stockController.stock_list.get("애플").setOne_stock_money(stockController.calc_stock(-1, "애플"));
        } else if (index == 4) {
            stockController.stock_list.get("삼성전자").setOne_stock_money(stockController.calc_stock(-1, "삼성전자"));
        } else if (index == 5) {
            stockController.stock_list.get("테슬라").setOne_stock_money(stockController.calc_stock(-1, "테슬라"));
        }

        //Thread : 일꾼, 하나의 프로그램(프로세스)에서 생성되는 여러명의 일꾼(병렬처리 가능)
        //(전역)일꾼(서버 관리하는 관리자 업무 진행 중)은 업무를 진행 중에 5초 쉰다

        //(지역)일꾼
//        new Thread() {
//            @Override
//            public void run() {
//                System.out.println("지역변수 쓰레드 일꾼!");
//            }
//        }.start();
        Thread.sleep(5000);
    }
}
