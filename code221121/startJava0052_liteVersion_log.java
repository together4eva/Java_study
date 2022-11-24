import java.util.ArrayList;

public class startJava0052_liteVersion_log {
    static int WinRockCount = 0;
    static int WinPaperCount = 0;
    static int WinScissorsCount = 0;

    static int Model0001RockCount = 0;
    static int Model0001WinPaperCount = 0;
    static int Model0001WinScissorsCount = 0;
    static int winModelPlayer = 0;
    static int loseModelPlayer = 0;

    static void setLog() {
        for(int item : startJava0052_liteVersion.winRPS) {
            if(item == 0) {
                WinScissorsCount++;
            } else if (item == 1) {
                WinRockCount++;
            } else if (item == 2) {
                WinPaperCount++;
            }
        }
    }

    static void getLog() {
        System.out.println("보 가 이긴 횟수 : "+WinPaperCount);
        System.out.println("바위 가 이긴 횟수 : "+WinRockCount);
        System.out.println("가위 가 이긴 횟수 : "+WinScissorsCount);
    }

    static void setModel0001Log() {
        //모델 적용 전 승리 횟수도 적용되는 문제 있음
        for(int item : startJava0052_liteVersion.winRPS) {
            if(item == 0) {
                Model0001WinScissorsCount++;
            } else if (item == 1) {
                Model0001RockCount++;
            } else if (item == 2) {
                Model0001WinPaperCount++;
            }
        }
    }

    static void getsetModel0001Log() {
        System.out.println("보 가 이긴 횟수 : "+Model0001WinPaperCount);
        System.out.println("바위 가 이긴 횟수 : "+Model0001RockCount);
        System.out.println("가위 가 이긴 횟수 : "+Model0001WinScissorsCount);
        System.out.println("모델 적용된 player가 이긴 횟수 "+winModelPlayer);
        System.out.println("모델 적용된 player가 진 횟수 "+loseModelPlayer);
    }
}
