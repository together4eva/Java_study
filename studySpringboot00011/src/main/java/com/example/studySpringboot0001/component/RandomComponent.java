package com.example.studySpringboot0001.component;

import java.math.BigDecimal;

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
}
