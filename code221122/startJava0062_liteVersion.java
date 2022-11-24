import java.util.ArrayList;
import java.util.Scanner;

/*
main()
--startGameUserVSCom();
----inputRPS();
----random();
----matchPlayers_lite(play1, play2);
--startGameComVSCom();
----random();
----random();
----matchPlayers_lite(play1, play2);
--getLog();
----startJava0052_liteVersion_log.setLog();
----startJava0052_liteVersion_log.getLog();
--startGameModelVSCom();
----random_model0001();
----random();
----matchPlayers_lite(play1, play2);
 */

public class startJava0062_liteVersion {

    static ArrayList<Integer> winRPS = new ArrayList<>();


    public static void main(String[] args) {
        
        //1. 유저와 컴퓨터와 가위바위보 하는 메서드를 만들고 추가하기 (최대한 기능을 구분하여(다수 메서드 생성) 코드구현)
        //2. 메뉴 중에 로그를 보는 기능을 완성하여 추가하기
        //3. log값 활용하기 (통계 적용)
        //1) 요구사항 : 가위바위보 승률을 높히는 알고리즘 만들어 적용하기 (승리)
        //2) 요구분석 : 보가 이긴 횟수가 2배가량 많다
        //3) 알고리즘 기획 : 보를 내면 이길 확률 높다 = 각각 이긴 횟수/이긴 횟수 로 가위바위보 내게 하여
        //"기존 기록을 토대로" 가장 승률높은 랜덤 가위바위보 모델 완성
        //4) 코드(모델링)구현 : 어떠한 코드로 보를 많이 내게 만들 것인가? (보만 내도록 한다)
        //4. 통계 적용한 모델의 결과 로그(기록)를 계산하는 클래스를 만들거나 수정하여 적용하시오

        for(;;) {
            viewInfo();
            Object choice = input();
            //intput()메서드로 Scanner로 문자열을 받고 구분하는 분기점
            if(choice.equals("1")) {
                //가위바위보 게임 실행 (유저)
                startGameUserVSCom();
            }else if(choice.equals("2")) {
                //가위바위보 게임 종료
                for (int i = 0 ; i<50000; i++) {
                    startGameComVSCom();
                }

            }else if(choice.equals("3")) {
                //기록 보기
                getLog();
                getModel0001Log();
            }else if(choice.equals("4")) {
                //가위바위보 게임 종료
                break;
            }else if(choice.equals("0")) {
                for (int i =0 ; i<10000; i++) {
                    startGameModelVSCom();
                }

            }
        }

    }

    private static void startGameModelVSCom() {
        //play1 통계기반으로 랜덤 출력
        int play1 = random_model0001();
        System.out.println("player1 은 "+play1);
        int play2 = random();

        boolean winPlayer1 = matchPlayers_lite(play1, play2);
        //모델링이 적용된 play1의 승리 횟수, 진 횟수를 계산, 무승부 일 경우 예외처리 & 메서드 따로 빼서
        //모델링 적용 게임에만 실행
        if (winPlayer1) {
            startJava0052_liteVersion_log.winModelPlayer ++;
        } else {
            startJava0052_liteVersion_log.loseModelPlayer ++;
        }
    }

    private static int random_model0001() {
        //확률 측정 : 각각 이긴 횟수 / 전체승리 횟수 : 승률 : 승률을 토대로 가위바위보를 한다면 이길 확률이 가장 정확

        //전체 승리 횟수
        int totalCount = startJava0052_liteVersion_log.WinPaperCount +
                startJava0052_liteVersion_log.WinScissorsCount +
                startJava0052_liteVersion_log.WinRockCount;

//        int WinScissors = startJava0052_liteVersion_log.WinScissorsCount / totalCount;
//        int WinPaper = startJava0052_liteVersion_log.WinPaperCount / totalCount;
//        int WinRock = startJava0052_liteVersion_log.WinRockCount / totalCount;
        //가위바위보 랜덤에 적용(모델링 적용)
        int result = (int)(Math.random()*totalCount)+1;
        System.out.println("시작 : total count = "+totalCount);
        System.out.println("Paper count = "+startJava0052_liteVersion_log.WinPaperCount);
        System.out.println("Scissors count = "+startJava0052_liteVersion_log.WinScissorsCount);
        System.out.println("Rock count = "+startJava0052_liteVersion_log.WinRockCount);
        System.out.println("모델 측정 랜덤 수치 : "+result);
        //랜덤으로 값을 출력하고 그 값이 가위,바위,보 범위 안에 들어가면 0,1,2 값을 리턴하여 최적의 가위바위보를 출력
        if(result > 0 & result <= startJava0052_liteVersion_log.WinScissorsCount) {
            return 0;
        } else if (result > startJava0052_liteVersion_log.WinScissorsCount &
                result <= startJava0052_liteVersion_log.WinScissorsCount + startJava0052_liteVersion_log.WinRockCount) {
            return 1;
        }else if (result > startJava0052_liteVersion_log.WinScissorsCount + startJava0052_liteVersion_log.WinRockCount) {
            return 2;
        }
        return -1;
    }

    private static void startGameUserVSCom() {
        //randomRPS와 유사
        int play1 = inputRPS();
        int play2 = random();

        //int값 두 개 넣어서 어떤 플레이어가 이기지는 출력하는 메서드
        matchPlayers_lite(play1, play2);

    }

    private static boolean matchPlayers_lite(int play1, int play2) {
        int addResult = 0;
        boolean winPlayer1 = false;
        //matchPlayers와 유사
        //0~2숫자 사이에 큰 것이 이긴다
        if(play1<play2) {
            addResult = play2;
        }
        if (play1>play2) {
            addResult = play1;
            winPlayer1 = true;
        }
        //단, 0과 2가 매칭이 되면 0이 이긴다
        if (play1 == 2 & play2 == 0) {
            addResult = play2;
        }
        if (play1 == 0 & play2 == 2) {
            addResult = play1;
            winPlayer1 = true;
        }
        if (play1 == play2) {
            System.out.println("무승부");
        }
        System.out.println("player1 = "+play1+" // player2 = "+play2);
        winRPS.add(addResult);

        return winPlayer1;
    }

    private static int inputRPS() {
        System.out.println("가위, 바위, 보 중에 하나를 입력하시오");
        Object input = input();
        if(input.equals("가위")) {
            return 0;
        }else if(input.equals("바위")) {
            return 1;
        }else if(input.equals("보")) {
            return 2;
        }
        return -1;
    }

    private static void viewInfo() {
        System.out.println("1. 게임 실행(User VS Com)");
        System.out.println("2. 게임 실행(Com VS Com)");
        System.out.println("3. 기록 보기");
        System.out.println("4. 게임 종료");
        System.out.println("0. 모델링 적용 게임(기록보기 진행 후 눌러주세요)");
    }

    private static void startGameComVSCom() {
        //randomRPS와 유사
        int play1 = random();
        int play2 = random();

        matchPlayers_lite(play1, play2);
    }

    private static Object input() {
        //Scanner타입으로 sc변수명 선언(stack영역)
        //Scanner인스턴스를 만들고 (System객체로 매개변수 전달) heap영역에 할당
        Scanner sc = new Scanner(System.in);
        Object test = sc.nextLine();
        System.out.println(test);
        return test;
    }

    private static void getLog() {
        startJava0052_liteVersion_log.setLog();
        startJava0052_liteVersion_log.getLog();
    }

    private static void getModel0001Log() {
        startJava0052_liteVersion_log.setModel0001Log();;
        startJava0052_liteVersion_log.getsetModel0001Log();;
    }

    static int random() {
        int result = (int)(Math.random()*3);
        return result;
    }


    public static void gameStart() {
    }
}
