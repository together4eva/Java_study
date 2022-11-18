import java.util.Scanner;

/*
    예) API설명
    randomRPS = 랜덤으로 가위바위보 출력하기
    searchKey = map의 value를 key값으로 바꾸기
    matchPlayers = key값 숫자가 크면 이긴다 (단, 보(2) 경우에 상대방이 가위(0)일 경우 거꾸로 결과 출력)
 */

public class startJava0041_menu {

    static boolean menu() {
        menuView();
        String input = inputData();
        switch (input) {
            case "1": {
                gameStartUserVSCom();
                return false;
            }
            case "2": {
                gameStartComVSCom();
                return false;
            }
            case "3": {
                gameModelingComVSCom();
                return false;
            }
            case "4": {
                viewLog();
                return false;
            }
            case "5": {
                endGame();
                return true;
            }
        }
        return false;
    }

    private static void gameModelingComVSCom() {
        startJava0041_rps_object.getLog();
    }

    private static void endGame() {
    }

    private static void viewLog() {
    }

    private static void gameStartComVSCom() {
        System.out.println("가위 바위 보 중에 하나를 입력하시오");
        String playerComputer1 = randomRPS();
        String playerComputer2 = randomRPS();

        System.out.println(startJava0041_rps_object.result.get(matchPlayers(playerComputer1, playerComputer2)));
    }

    private static void gameStartUserVSCom() {
        System.out.println("가위 바위 보 중에 하나를 입력하시오");
        String playerUser = inputData();
        String playerComputer1 = randomRPS();

        //가위, 바위, 보 끼리 비교해서 승리하는 쪽을 출력하는 메서드를 만드시오
        System.out.println(startJava0041_rps_object.result.get(matchPlayers(playerUser, playerComputer1)));
    }
    private static void menuView() {
        System.out.println("메뉴를 선택하시오");
        System.out.println("1. 게임 (유저 vs 컴퓨터)를 시작합니다");
        System.out.println("2. 게임 (컴퓨터 vs 컴퓨터)를 시작합니다");
        System.out.println("3. 모델링 적용된 (컴퓨터 vs 컴퓨터)를 시작합니다 (통계출력)");
        System.out.println("4. 기록을 봅니다");
        System.out.println("5. 게임을 종료합니다");
    }

    private static String inputData() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    private static int matchPlayers(String playerUser, String playerComputer1) {
        int p0 = searchKey(playerUser);
        int p1 = searchKey(playerComputer1);
        int result =  -1;
        System.out.println("플레이어 1은 "+startJava0041_rps_object.rps_grobal.get(p0)+"를 냈습니다");
        System.out.println("플레이어 2은 "+startJava0041_rps_object.rps_grobal.get(p1)+"를 냈습니다");

        if(p0 == 2 && p1 == 0) {
            result =  1;
        } else if(p1 == 2 && p0 == 0) {
            result =  0;
        }else if(p0 > p1) {
            result =  0;
        }else if(p0 < p1) {
            result =  1;
        }
        startJava0041_rps_object.addLog(result, p0);
        startJava0041_rps_object.addLog((result<1)?1:0, p1);
        return result;
    }

    private static int searchKey(String playerUser) {
        for(int i = 0; i<startJava0041_rps_object.rps_grobal.size();i++) {
            if(playerUser.equals(startJava0041_rps_object.rps_grobal.get(i))) {
                return i;
            }
        }
        return 0;
    }

    private static String randomRPS() {
        int randomNum = (int)(Math.random()*3);
        String rps = "";
        if(randomNum == 0) {
            //가위
            rps = startJava0041_rps_object.rps_grobal.get(0);
        } else if (randomNum == 1) {
            //바위
            rps = startJava0041_rps_object.rps_grobal.get(1);
        } else if (randomNum == 2) {
            //보
            rps = startJava0041_rps_object.rps_grobal.get(2);
        }
        return rps;
    }
}
