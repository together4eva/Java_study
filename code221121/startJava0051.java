import java.math.BigDecimal;

public class startJava0051 {

    //todo 20221121
    //6. 가위바위보 게임을 객체지향 코드를 리팩토링하고 로그 기능 추가
    //4. 가위바위보 게임을 객체지향으로 변형 및 통계분석하고 예측하기

    public static void main(String[] args) {

        //2진수 계산법에 관한 이야기
        System.out.println("hello world");
        System.out.println(2.0*2.0); //4.0

        double a = 2;
        double b = 2;
        System.out.println(a*b); //4.0
        
        System.out.println("--------정확한 실수 표기---------");
        double result = 0;
        //E : 소수점 표기
        //f : 실수
        for (int i =0; i< 10000; i++) {
            result = result + 0.1;
        }
        System.out.println(result);
        System.out.println("-------2진수의 계산방식-------");


        int apple = 1;
        double pieceUnit = 0.1; // 0.1 * 10 = 1

        //10진수의 1의 숫자를 1/10 = 1.000000000000001
        //1)소수점의 마지막 표기는 짝수로 표기 되기 때문 : 2진수는 짝수 0,1 : 0.5만 표기 > 2.5 > 1.25 >....
        //2)2진수 > 8진수 > 16진수 (2의 제곱승)
        int num = 7;
        System.out.println(pieceUnit*num);
        double resultCheck = apple - (pieceUnit*num); // 0.3? //소수점의 근사치 표현 / 2진수의 오류
        System.out.println(resultCheck);

        System.out.println("-------컴퓨터 2진수의 덧셈 오류-------");
        double val1 = 10.23;
        double val2 = 34.45;
        System.out.println(val1 + val2);


        System.out.println("------BigDecimal 연산------");
        //정확한 값 표현
        //new BigDecimal(STRINGTYPE);
        BigDecimal num1 = new BigDecimal("0.1");
        BigDecimal num2 = new BigDecimal("7");
//        System.out.println(num1.add(num2));
        System.out.println(num1.multiply(num2));

//        double deg = Math.toDegrees(1.5);
//        System.out.println(deg);
        //1 : 10, 15
        //2 : 5, 3
        //3 : 20, ?
        double resultGre = (10.0 - 5.0) / (15.0- 3.0);
        System.out.println(resultGre);

        System.out.println(20.0/resultGre);

    }

    void result() {

    }
}
