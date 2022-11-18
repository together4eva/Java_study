import java.util.ArrayList;
import java.util.Scanner;

public class startJava0012 {

    // q0032 회원가입 기능 추가
    // 삭제와 수정

    static String[] infoList = {"ID", "PW", "Email", "Name"};
    static ArrayList<String[]> accountList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello world");

        //회원가입 정보를 담는 배열


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
                System.out.println("수정하고 싶은 번호를 입력하시오");
                String temp = inputData();
                fixAccount(temp);
            }else if(result.equals("3")) {
                System.out.println("삭제하고 싶은 번호를 입력하시오");
                String temp = inputData();
                accountList.remove(temp);
            }else if(result.equals("4")) {
                infoView(accountList);
                break;
            }
        }
    }

    private static void fixAccount(String tempNum) {
        String[] account = new String[4];
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

        //Integer.parseInt(STRINGDATA) : STRINGDATA를 int로 형 변환
        //Integet.toString(INTDATA) : INTDATA를 String로 형 변환
        accountList.set(Integer.parseInt(tempNum), account);
    }

    private static void infoView(ArrayList<String[]> accountList) {
        for(int i = 0; i<accountList.size(); i++) {
            System.out.println(i+" 번 째 : ");
            for(int j = 0; j<accountList.get(i).length; j++) {
                System.out.println(infoList[j]+" : "+accountList.get(i)[j]);
            }
        }
    }

    private static void infoMenu() {
        System.out.println("1. 회원정보를 입력합니다");
        System.out.println("2. 회원정보를 수정합니다");
        System.out.println("3. 회원정보를 삭제합니다");
        System.out.println("4. 회원정보 입력을 종료합니다");
    }

    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static void infoAccount(int menuNum) {

        System.out.println(infoList[menuNum]+" 입력하시오");
    }
}