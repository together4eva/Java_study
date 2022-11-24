import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class startJava0041 {

    //todo 20221118
    //1. 클래스와 객체 개념 : tv와 채널 (메모리, 배열 복습)
    //2. 클래스의 데이터 저장과 기능 (다양한 타입의 구조체와 행위 메서드)
    //3. JVM 이론
    //4. static메서드와 인스턴스메서드
    //5. 생성자와 오버로딩과 객체 스타일


    //q0041 가위바위보 게임 만들기 part2
    //1. 컴퓨터 끼리 대결 기능 추가
    //3. 랜덤으로 출력하는 것이 아니라 통계적으로 승리할 가능성이 높은 가위바위보를 출력하도록 기능 추가
    
    //통계 알고리즘 아이디어
    //내가 가위 낼 때 바위보가위 낼 확률
    //무엇을 낼 때의 승률
    //가위-보-바위 등 특정 패턴이 있을 경우 다음 낼 내용 확률
    
    //가위의 승률 갯수, 바위의 승률 갯수, 보의 승률 갯수를 더한 뒤에 랜덤으로 수치를 뽑아서 내기

    public static void main(String[] args) {
        System.out.println("hello world");

        for(;;) {
            boolean breakCode = startJava0041_menu.menu();
            if(breakCode) {
                break;
            }

        }
    }


}
