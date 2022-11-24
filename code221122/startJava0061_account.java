import java.util.ArrayList;

//1명의 회원정보에 id, pw, email, name의 데이터가 하나씩 갖고 있다
public class startJava0061_account {
    //필드
    String id;
    String pw;
    String email;
    String name;
    ArrayList<startJava0061_rps_log> list = new ArrayList<>();

    //생성자 : 초기스타일 : 필드값 4개 모두 적용필요
    //startJava0061_account 기반으로 1명의 회원(instance)를 찍어낼 때마다 정보를 생성(4개 필드값 넣기)
    startJava0061_account(String id, String pw, String email, String name) {
        this.id = id;
        this.pw = pw;
        this.email = email;
        this.name = name;
    }

    //메서드
    void setList(startJava0061_rps_log log) {
        list.add(log);
    }
    void setPw(String input_pw) {
        this.pw = input_pw;
    }

}