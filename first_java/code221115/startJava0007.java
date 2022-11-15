import java.util.Scanner;

public class startJava0007 {
//    static int sum_global = 0;
//    static String menu_list_array;
//    public static void main(String[] args) {
//
//        for (; ; ) {
//            menu_list();
//            System.out.println("메뉴를 입력하세요");
//            String temp =input_scanner();
//            System.out.println("메인 메서드의 값 : "+temp);
//            if(calcAndExit(temp)){
//                System.out.println("총금액은 : " + sum_global + "원 입니다");
//                break;
//            }
//            System.out.println("총금액은 : " + sum_global + "원 입니다");
//        }
//    }
//    public static void menu_list() {
//        System.out.println("매떡 2000원");
//        System.out.println("마떡 4000원");
//        System.out.println("엽떡 4500원");
//    }
//    public static String input_scanner() {
//        Scanner sc = new Scanner(System.in);
//        /*
//        string 문자열을 입력받고 한 줄 띄움
//        sc.nextLine()
//
//        Int 정수 입력 받기
//        sc.nextInt()
//
//        String 문자열을 입력받기
//        sc.next()
//
//        next(), nextInt() 메서드를 사용하면 buffer에 enter키값이 남아 있어서
//        다음 Scanner 입력 값이 enter 키 값이 입력되는 현상 발생
//        이럴 때는 nextLine()메서드로 enter키 값을 buffer에서 삭제
//         */
//        String choice_menu = sc.nextLine();
//
//        System.out.println("input_scanner 메서드의 값 : "+choice_menu);
//        return choice_menu;
//    }
//    public static boolean calcAndExit(String input) {
//        System.out.println("calc 메서드의 값 :" + input);
//        int sum = 0;
//        int 매떡 = 2000;
//        int 마떡 = 4000;
//        int 엽떡 = 4500;
//
//        if (input.equals("매떡")) {
//            System.out.println("매떡 : 2000원입니다");
//            sum_global  = sum_global  + 매떡;
//        } else if (input.equals("마떡")) {
//            System.out.println("마떡 : 4000원입니다");
//            sum_global  = sum_global  + 마떡;
//        } else if (input.equals("엽떡")) {
//            System.out.println("엽떡 : 4500원입니다");
//            sum_global  = sum_global  + 엽떡;
//        }else{
//            System.out.println("메뉴판의 메뉴를 골라주세요");
//            return true;
//        }
//        return true;
//    }
//}
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

/*
break : 가장 가까운 반복문에서 탈출

Q0003
당신은 떡볶이 집 운영자 입니다
주문을 자동화 하기 위해 키오스크 시스템을 만들려고 합니다
다음과 같은 떡볶이 메뉴를 출력하고
결제 시스템을 구축하시오
메뉴)
매 떡 2000원
마 떡 4000원
엽 떡 4500원
1) 떡볶이 메뉴를 계속 받도록 구조 짜기 = 무한 반복문과 break활용
2) sysout으로 메뉴 출력
3) Scanner로 메뉴 이름 또는 번호 입력받기
4) 입력 받은 번호로 결제금액 합산
//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
sum_global = sum_global -(sum_global/10)
 */
// q0004
//당신 옆 가게 떡볶이 집이 잘되는 것을 부러워하는 돈가스 집의 오너입니다.
//다음과 같은 메뉴를 가진 키오스크 시스템을 구축하시오.
//1. 안심 돈가스 : 9000원
//2. 등심 돈가스 : 8000원
//(단, 고객을 확보하기하기 위해
//만원이상이면 10%할인, 2만원이상이면 20%할인을 하는
//만원 단위별로 10%씩 증가하는
//최대 50%할인 대박세일을 진행하려 합니다)
//sum_grobal = sum_grobal - (sum_grobal /10)

    static int sum_global = 0;
    static String menu_list_array;
    public static void main(String[] args) {

        for (; ; ) {
            menu_list();
            System.out.println("메뉴 번호를 입력하세요");
            String temp =input_scanner();
            
            System.out.println("메인 메서드의 값 : "+temp);
            discount();
            if(calcAndExit(temp)){
                System.out.println("총금액은 : " + sum_global + "원 입니다");
                break;
            }
            System.out.println("총금액은 : " + sum_global + "원 입니다");

        }
    }
    public static void menu_list() {
        System.out.println("1. 등심 8000원");
        System.out.println("2. 안심 9000원");
        System.out.println("3. 종료");
    }
    public static String input_scanner() {
        Scanner sc = new Scanner(System.in);
        String choice_menu = sc.nextLine();
        System.out.println("input_scanner 메서드의 값 : "+choice_menu);
        return choice_menu;
    }
    public static boolean calcAndExit(String input) {
        System.out.println("calc 메서드의 값 :" + input);
        int 등심 = 8000;
        int 안심 = 9000;

        if (input.equals("1")) {
            System.out.println("등심 : 8000원입니다");
            sum_global  = sum_global  + 등심;
        } else if (input.equals("2")) {
            System.out.println("안심 : 9000원입니다");
            sum_global  = sum_global  + 안심;
        } else if (input.equals("3")) {
            System.out.println("종료하겠습니다");
            return true;
        }else{
            System.out.println("*메뉴판의 메뉴를 골라주세요*");
        }
        return false;
    }
    public static  void discount(){
        if(sum_global >=10000){
            sum_global=sum_global - (sum_global /10);
        }
        else if(sum_global >=20000){
            sum_global=sum_global - (sum_global /20);
        }
        else if(sum_global >=30000){
            sum_global=sum_global - (sum_global /30);
        }
        else if(sum_global >=40000){
            sum_global=sum_global - (sum_global /40);
        }
        else if(sum_global >=50000){
            sum_global=sum_global - (sum_global /50);
        }
    }
}
//만원이상이면 10%할인, 2만원이상이면 20%할인을 하는
//만원 단위별로 10%씩 증가하는
//최대 50%할인 대박세일을 진행하려 합니다)
//sum_grobal = sum_grobal - (sum_grobal /10)