import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class startJava0013 {

    //q0033 가위바위보 게임 만들기
    //1. 보는 바위를 이기고, 바위는 가위를 이기고, 가위는 보를 이기는 게임을 제작
    //Scanner로 가위,바위,보 문자열을 받고 비교하여 이기는 게임 알고리즘 만들기
    //2. 랜덤지능? 메서드를 만들어서 가위바위보를 랜덤으로 출력하는 기능 추가 + 컴퓨터 끼리 대결 기능 추가
    //3. 랜덤으로 출력하는 것이 아니라 통계적으로 승리할 가능성이 높은 가위바위보를 출력하도록 기능 추가

    //MAP : key,value로 이루어진 쌍데이터 (딕셔너리와 유사)
    static final HashMap<Integer, String> rps_grobal = new HashMap<Integer, String>() {{
        put(0, "가위");
        put(1, "바위");
        put(2, "보");
    }};

    static final HashMap<Integer, String> result = new HashMap<Integer, String>() {{
        put(-1, "무승부");
        put(0, "1번 플레이어 승리");
        put(1, "2번 플레이어 승리");
    }};

    //로그 입력
    static ArrayList<Integer> logA = new ArrayList<>();
    static ArrayList<Integer> logB = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("hello world");

        for(;;) {
            System.out.println("가위 바위 보 중에 하나를 입력하시오");
            String playerUser = scannerRPS();
            String playerComputer1 = randomRPS();

            //가위, 바위, 보 끼리 비교해서 승리하는 쪽을 출력하는 메서드를 만드시오
            //가위 > 바위
            //1. 아스키코드 : 문자을 코드(숫자)로 인식 혹은 전역변수 rps_global를 사용해서 비교
            System.out.println(result.get(matchPlayers(playerUser, playerComputer1)));
        }
    }

    private static int matchPlayers(String playerUser, String playerComputer1) {
        int p0 = searchKey(playerUser);
        int p1 = searchKey(playerComputer1);
        System.out.println("플레이어 1은 "+rps_grobal.get(p0)+"를 냈습니다");
        System.out.println("플레이어 2은 "+rps_grobal.get(p1)+"를 냈습니다");
        if(p0 == 2 && p1 == 0) {
            return 1;
        } else if(p1 == 2 && p0 == 0) {
            return 0;
        }else if(p0 > p1) {
            return 0;
        }else if(p0 < p1) {
            return 1;
        }
        return -1;
    }

    private static int searchKey(String playerUser) {
//        for(int i = 0; i<rps_grobal.size();i++) {
//            if(playerUser.equals(rps_grobal.get(i))) {
//
//            }
//        }
        //향상된 for문 (단축 반복문) : 특정 배열의 처음부터 끝까지 순회
        for(int key : rps_grobal.keySet()) {
            if(playerUser.equals(rps_grobal.get(key))) {
                return key;
            }
        }
        return 0;
    }

    private static String randomRPS() {
        int randomNum = (int)(Math.random()*3);
        String rps = "";
        if(randomNum == 0) {
            rps = rps_grobal.get(0);
        } else if (randomNum == 1) {
            rps = rps_grobal.get(1);
        } else if (randomNum == 2) {
            rps = rps_grobal.get(2);
        }
        return rps;
    }

    private static String scannerRPS() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}