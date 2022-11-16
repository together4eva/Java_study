import java.util.ArrayList;
import java.util.Scanner;

public class startJava0024 {

    // q0024 회원가입a
    // arrayList와 고정배열을 사용하여 회원목록을 저장하고 출력하는 시스템 구성

    // 1. 안내와 데이터받기 (id, pw, email, 이름..)
    // Scanner로 데이터를 받고,
    // 2. 받은 데이터를 배열에 저장
    // 3. 저장된 배열의 값을 출력하는 메서드 실행
    // 4. *회원가입을 여러명을 받기 위해서 어떤 구성을 해야할지 고민하기

    static String[] infoList = {"ID", "PW", "Email", "Name"};

    public static void main(String[] args) {
        System.out.println("hello world");

        //회원가입 정보를 담는 배열
        ArrayList<String[]> accountList = new ArrayList<>();

        for(;;) {
            //1사람의 id, pw, email, name.. 배열
            String[] account = new String[4];
            System.out.println("회원가입을 시작합니다.");
            infoMenu();
            String result = inputData();
            if (result.equals("1")) {
                for(int i = 0;;i++) {
                    //1. 안내
                    infoAccount(i);
                    //2. Scanner받기
                    String temp = inputData();
                    //3. 배열에 데이터 넣기
                    account[i] = temp;
                    //! true > false, false > true 반전연산자
                    if(!(account[account.length-1] == null)) {
                        System.out.println("회원정보 입력 완료");
                        break;
                    }
                }
                accountList.add(account);
            }else if(result.equals("2")) {
                infoView(accountList);
                break;
            }
        }
    }

    private static void infoView(ArrayList<String[]> accountList) {
        for(int i = 0; i<accountList.size(); i++) {
            for(int j = 0; j<accountList.get(i).length; j++) {
                System.out.println(infoList[j]+" : "+accountList.get(i)[j]);
            }
        }
    }

    private static void infoMenu() {
        System.out.println("1. 회원정보를 입력합니다");
        System.out.println("2. 회원정보 입력을 종료합니다");
    }

    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void infoAccount(int menuNum) {

        System.out.println(infoList[menuNum]+" 입력하시오");
    }
}
