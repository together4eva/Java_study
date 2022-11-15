public class startJava0001 {
    //필드 : 클래스의 자원 (데이터) /타입을 명시 해야 함
    //String : 타입
    //name : 변수이름
    // = 대입연산자
    // "김지혁" 값
    String name = "김지혁";

    // 생성자 : 객체를 만들 때 초기 스타일 지정
    //메서드 : 객체의 실행 가능 한 코드
    //main() : 메인 메서드는 딱 1개만 만듬
    //프로그램의 시작점을 표기하기 때문에 1개만 필요
    //public : 외부에서 접근 가능한 접근 제한자 <>private
    //static : 1개만 있다
    //void : return이 없다 <>String , int....
    //main(String[] args) : 변수이름과 ㅁ개ㅐ변수
    public static void main(String[] args) {
        System.out.println("Hello world!");

        String input_name = "김지혁";
        String job = "학생";
        String adr = "수원시 장안구";

        //int sum : int 타입으로
        //String job : String 보다 메모리 크기가 작기 때문에
        //String 타입 메모리 크기로 포함될 수 있음

        int sum = 20;

        int number0001 =10;
        int number0002 = 20;
        String number0003 = "30";

        System.out.println(number0001+number0002);
//        java에서 같은 타입으로 먼저 맞춘 뒤
//        연산 작업 실행
//        String 타입이 int 타입보다 더 크기 때문에
//        number0001이 String 10으로 형변환되어
//        "10"+"30"으로 "1030"이 됨
        System.out.println(number0001+number0003);

        //sout : System.out.println() 축약어
        System.out.println(input_name +" "+ job+" " + adr);
        System.out.println(job+sum);


    }
}
