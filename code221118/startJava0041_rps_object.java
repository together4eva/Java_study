import java.util.ArrayList;
import java.util.HashMap;

public class startJava0041_rps_object {
    //필드
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
    static ArrayList<startJava0041_log> log = new ArrayList<>();

    //생성자
    //메서드
    public static void addLog(int result, int rps) {
        log.add(new startJava0041_log(result, rps));
    }
    public static void getLog() {
        for(startJava0041_log item : log) {
            System.out.println("가위바위보 중에 "+rps_grobal.get(item.getRps())+" 내어서");
            System.out.println("결과는 "+result.get(item.getResult()));
        }
        for(startJava0041_log item : log) {
            System.out.println(item.getResult());
        }
    }
}
