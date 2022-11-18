import java.util.ArrayList;
import java.util.Scanner;

public class startJava0043_accountlist {
    //static : 프로그램에서 한 개의 객체로 전역변수 혹은 공용데이터 저장 용도로 적합 (예: 주소..)
    //account와 같은 지속적으로 늘어나는 데이터를 담는 1개의 배열 용도
    private static ArrayList<startJava0043_account> accounts = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void inputAccount(startJava0043_account input) {
        accounts.add(input);
    }
    //일반 arrayList일 경우 메서드를 새로 만들어서 사용할 수 없으나,
    //클래스를 활용하여 배열을 쓸 경우, 아래와 같은 메서드를 커스텀하여 활용 가능
    public static void getAccounts() {
        //향상된 반복문 : 배열의 처음부터 끝까지 순회
        //startJava0043_account i = startJava0043_account 타입으로 꺼내온 i의 이름의 변수명
        //accounts 배열가져오기
        //(타입 변수명 : 배열명)
        int count = 0;
        for(startJava0043_account i : accounts) {
            System.out.println(count + " 번째 account");
            i.getInfo();
            count++;
        }
    }
    public static void setAccount() {
        accounts.set(Integer.parseInt(sc.nextLine()),initAccount());
        getAccounts();
    }
    public static startJava0043_account initAccount() {
        System.out.println("데이터를 입력하시오");
        return new startJava0043_account(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextLine());
    }
}
