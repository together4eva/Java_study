import java.util.ArrayList;
import java.util.Scanner;

public class startJava0043 {

    public static void main(String[] args) {
        System.out.println("hello world");

        //회원가입 인스턴스 만들기
        //startJava0043_account1 account1 : 타입선언(객체,클래스) 변수이름
        // = : 우측 heap메모리에 있는 실체하는 객체를 좌측 stack에 할당(연결)
        // new : 인스턴스 : 클래스라는 설계도를 토대로 실체하는 객체를 찍어냄
        // startJava0043_account1(인자1, 인자2) : 인자값 2개를 선물로 주고, 
        // 인스턴스를 새로 만들 때 초기 스타일을 바꿈
//        startJava0043_account account1 = new startJava0043_account();

        //객체지향으로 회원가입 모듈 만들기
        //1. startJava0043_account 클래스를 완성하여, 회원가입 정보를 받을 수 있는 클래스(설계도 완성)
        //매개변수 4개를 받는 생성자 완성 + 회원정보를 전부 볼 수 있는 메서드 완성
        //2. Scanner를 통해 값을 입력받고 회원가입 인스턴스를 생성할 때 인자값으로 전해주고 인스턴스 생성
        //3. ArrayList(또는 account객체를 담는 accountList클래스)에 account객체를 지속적으로 담는 코드를 작성하시오
        //4. startJava0043_accountlist에 특정 account의 값을 삭제 또는 수정하는 메서드를 만드시오


        //배열의 경우 하나의 타입으로 계속저장 <> 클래스의 경우 다양한 타입으로 필드 구성
        for (int i = 0;i<2;i++) {
            //startJava0043_account 타입으로 account변수 선언 : 메모리 stack에 변수 선언
            //heap메모리에 새로운 인스턴스를 만듬 (startJava0043_account 클래스(설계도) 기반으로 생성)
            //인자값 4개는 생성자에게 전달할 데이터 (생성자:인스턴스를 처음 만들 때 필드값 정의(스타일 정의))
            startJava0043_accountlist.inputAccount(startJava0043_accountlist.initAccount());
            startJava0043_accountlist.getAccounts();
        }
        System.out.println("변경하고 싶은 회원index를 입력하시오");
        startJava0043_accountlist.setAccount();
    }
}
