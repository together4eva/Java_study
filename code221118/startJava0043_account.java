public class startJava0043_account {
    //필드
    String id;
    String pw;
    String email;
    String name;
    int phoneNum;

    //생성자
    //this : 가장 가까운 객체를 가르킴
    //오버로딩 : 다양한 타입의 생성자를 활용하여 인스턴스 스타일 만들기 (매개변수 갯수에 따라 다름)
    startJava0043_account() {
        this.id = "none";
        this.pw = "1234";
        this.email = "a@a";
        this.name = "김준석";
    }
    startJava0043_account(String id, String input_pw, String input_email, String input_name) {
        this.id = id;
        this.pw = input_pw;
        this.email = input_email;
        this.name = input_name;
        this.phoneNum = 01011112222;
    }

    //메서드
    public void setPrivateInfoEmailAndName(String input_email, String input_name) {
        this.email = input_email;
        this.name = input_name;
        System.out.println("email, name 변경 완료");
    }
    public void getInfo() {
        System.out.println("Id = "+this.id);
        System.out.println("pw = "+this.pw);
        System.out.println("email = "+this.email);
        System.out.println("name = "+this.name);
        System.out.println("phoneNum = "+this.phoneNum);
    }
    public void setInfo() {

    }


}
