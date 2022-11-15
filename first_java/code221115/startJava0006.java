import java.util.Scanner;

public class startJava0006 {

    public static void main(String[] args0) {
        System.out.println("hello world");

/*
좌측 : 타입 변수명 (Scanner 타입 sc 변수명)
= : 대입 연산자
우측 : 값(실행코드)

heap 메모리 영역

 */

        Scanner sc = new Scanner(System.in);

//        String abc = new String("김지혁");
//        String abcd = "김지혁";
        System.out.println("이름을 입력하시오");
        String inputData = sc.nextLine();
        System.out.println(inputData);
    }
}
