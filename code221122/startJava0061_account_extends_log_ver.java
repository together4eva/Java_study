//startJava0061_account 클래스의 모든 기능을 물려받아서 새로운 기능을 더하는 클래스
public class startJava0061_account_extends_log_ver extends startJava0061_account{

    //super : 부모클래스(superClass)를 지칭하는 단어 : 상속, 자원을 물려주는 대상의 클래스 : extends
    startJava0061_account_extends_log_ver(String id, String pw, String email, String name) {
        super(id, pw, email, name);
    }

    void getInfo() {
        System.out.println("id는 :"+super.id);
        for (startJava0061_rps_log item : super.list) {
            System.out.println(item.winRPS);
        }
    }
}