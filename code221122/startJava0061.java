import java.util.ArrayList;
import java.util.Scanner;

public class startJava0061 {

    //*가위바위보 게임에 *회원가입과 회원마다 *기록(log)를 남기고, log를 분석하여 맞춤형 가위바위보 모델을 적용하시오
    // [1] 클래스 안에 인스턴스 연결하여 하나의 객체 활용, 인스턴스 안에 인스턴스 연결하여 하나의 객체 활용
    // [2] 상속(extends)에 대한 개념을 이해하고 적용하기

    //1. 회원 account 클래스에 rps_log 클래스를 배열로 추가하시오
    //account의 필드에 ArrayList<startJava0061_rps_log> list; (필드)
    //list변수에 log 인스턴스를 지속적으로 추가하는 기능 구현 (메서드)
    //2. 가위바위보 게임을 본 startJava0061 메인메서드에 로그인 이후에 적용하시오

    //*본인이 구조를 짤 수 있도록 연습 (지문에 따라 구조만들기를 자유롭게 될 수 있도록 진행할 것!!!)
    //3. 로그인을 하면 어떤 로그인id가 적용되어 있는지 확인하는 메서드 만들기
    //로그인 = 프로그램이 실행되서 특정 USER의 정보를 갖고 있는 것 (전역변수, static, main에서 저장)
    //4. account의 id와 email이 다른 회원과 중복되지 않게 만들 것 (만든 메서드를 회원가입 시에 활용)
    //5. 회원가입할 때 FLASE라는 ID는 불가하게 설정할 것
    //6. pw를 변경할 수 있도록 메서드 만들 것

    //7. PW변경 기능 추가 (ID조회 기능이 필요)
    //8. 회원마다 들어있는 로그 정보를 각각 저장하기
    //기존 rps게임은 모든 회원의 가위바위보 통계 기반에서
    //User와 Com 게임에서는 로그인 된 User의 account의 log배열에 가위바위보 기록 저장
    //rps게임에 대해 다 이해하고, 객체지향 프로그래밍을 완수
    //[상속 적용할 것] (extends) : 클래스A의 모든 필드, 메서드를 물려받아서 클래스B가 사용할 수 있는 구조
    //*오전에 했던 list배열을 account_extends_log_ver 클래스에 옮겨서 구조를 확립하기

//    회원가입과 rps 게임 연동
//    1) 요구사항에 맞는 데이터 정리
//    --회원가입 : id, pw , email, name
//    --rps : 가위, 바위, 보, 이긴 횟수...
//    2) 컴퓨터 시점 흐름(플로우차트)
//    3)플로우 차트에 맞춰 클래스 구성(instance, static, extends....)






    //startjava0061 : 메인메서드
    //startJava0061_account : 회원1명의 정보
    //-- 필드 : id/pw/email/name
    //-- 생성자 : 4개의 변수값을 받아서 인스턴스 생성
    //-- 메서드 :
    //---- 1. id와 email이 다른 회원과 중복되지 않게 만들 것
    //---- 2. pw를 변경할 수 있도록 메서드 만들 것
    //---- 3. 회원가입할 때 FLASE라는 ID는 불가하게 설정할 것
    //---- 4. extends 부가 정보(기본정보 클래스 + 게임회원정보 클래스)
    //startJava0061_rps_log : 로그정보만 담는 class
    //startJava0061_rps : 가위바위보 게임을 위한 필드와 메서드

    //요구사항에 대해 코드 구조 작성법
    //1. 요구사항 분석
    //2. 스펙 (객체지향(인스턴스, static..), 상속, 전역/지역변수 관리, 사칙연산..)
    //3. 데이터를 객체화 1. 클래스(static 1개) 2.인스턴스(찍어내는 것)
    //3-1. main : static
    //3-2. account : instance
    //3-3. rps_log : instance(*회원마다 1개씩 갖고 있어야 하는 포함관계)
    //3-4. rps : static
    //4. 필요한 기능을 정리 (필드(데이터), 생성자(초기값), 메서드(동적기능,행위)의 각각 정의에 맞춰 기능을 기획)
    //4-1. account

    static ArrayList<startJava0061_account> accounts = new ArrayList<>();
    static String loginUser = "";

    public static void main(String[] args) {
        System.out.println("hello world");
        for(;;) {
            menu();
            String choice = inputScanner();
            if(choice.equals("1")) {
                //로그인
                loginGame();
            }else if(choice.equals("2")) {
                //회원가입
                signUp();
            }//pw변경
        }
    }
    private static void changePw(){
        System.out.println("ID를 입력하시오");
        String input_id = inputScanner();
//        checkList : 중복값이 있으면 true 반환
        int arrayNum = checkList_array(input_id);
//        accounts 배열 안에 몇 번째 있는지 확인
        if(arrayNum>=0){
//            pw 변경
            accounts.get(arrayNum).pw=inputScanner();
        }else{
            System.out.println("pw변경 불가합니다(id값을 찾을 수 없습니다");
        }
    }
    private static int checkList_array(String input_id){
//        회원의 정보를 담는 accounts 배열을 순회
        for(int i =0; i<accounts.size(); i++){
//            찾고자 하는 id 값이 같다고 하면 몇 번째 배열에 있는지 i return
            if(accounts.get(i).equals(input_id)){
                return i;
            }
        }
//        같은 값이 없으면 -1
        return -1;
    }
    private static void menu() {
        System.out.println("1. 로그인");
        System.out.println("2. 회원가입");
    }
    private static void signUp() {
        infoMenu();
        String input_id = inputScanner();
        startJava0061_account ac1 = new startJava0061_account(
                input_id, inputScanner(), inputScanner(), inputScanner());
        if(!checkList(input_id)) {
            accounts.add(ac1);
        }else {
            System.out.println("회원가입을 실패했습니다");
        }
    }

    private static void loginGame() {
        System.out.println("ID를 입력하시오");
        String inputId = inputScanner();
        System.out.println("PW를 입력하시오");
        String inputPw = inputScanner();

        String result = equlasAccountsIdPw(inputId, inputPw);
        if(result.equals("FALSE")) {
            System.out.println("로그인이 실패했습니다");
        }else {
            //게임실행
            //로그인 할 경우 loginUser 전역변수에 저장 > 로그아웃일 경우 처리 필요
            loginUser = inputId;
            gameStart();
        }
    }

    private static void gameStart() {
        startJava0062_liteVersion.gameStart();
    }

    //accounts 배열 안에 있는 회원(account)를 조회하여 id/pw가 동일한지 확인
    private static String equlasAccountsIdPw(String inputId, String inputPw) {
        //처음부터 끝까지 확인해야 하는 배열이므로 향상된 반복문 사용
        //(배열안에있는타입 변수명 : 배열변수명)
        for(startJava0061_account item : accounts) {
            //회원의 id필드값과 매개변수 inputId와 비교하여 가입된 회원 중에 id가 있는지 확인
            if(item.id.equals(inputId)) {
                //id가 동일하면 그 회원에 pw가 동일한지 확인
                if(item.pw.equals(inputPw)) {
                    //로그인 정보 확인 > 로그인완료, 로그인된 id
                    return item.id;
                }else {
                    System.out.println("PW가 틀립니다");
                }
            }
        }
        //회원가입할 때 FLASE ID는 불가하게 설정할 것
        return "FALSE";
    }

    //회원가입을 위한 정보 출력
    static void infoMenu() {
        System.out.println("회원가입 필요한 정보를 입력하시오");
    }
    static String inputScanner() {
        //스캐너로 입력받을 주제에 대해 설명
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //main메서드에 있는 회원정보목록 acccounts의 배열을 순회하여
    //동일한 id가 있는지 확인 (중복 = true)
    static boolean checkList(String checkId) {
        //향상된 반복문으로 accounts배열을 처음부터 마지막까지 순회
        for(startJava0061_account item : startJava0061.accounts) {
            if(item.id.equals(checkId)) {
                return true;
            }
        }
        //Id의 값이 FALSE이면 회원가입 불가하게 만들 것
        if(checkId.equals("FALSE")) {
            return true;
        }
        return false;
    }

}