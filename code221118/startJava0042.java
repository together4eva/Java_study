public class startJava0042 {

    //클래스 class : 인스턴스(객체)를 만들기 위한 설계도
    //객체 : 모든 것(thing)

    public static void main(String[] args) {
        System.out.println("hello world");

        //Tv 사용하여 파워, 채널 외 볼륨을 추가하여 메서드를 완성하고 실행하시오

        //q0042_1
        //1. Tv에 연결할 수 있는 스피커, 게임기(Xbox등), 캠 객체 등등 추가하여 자유롭게 확장시키시오.
        //2. Tv의 필드 Power변수가 True일 경우에만 스피커, 게임기, 캠 등등 동작하도록 필드 연계코드를 작성하시오.
        //3. Tv필드를 임의로 더 추가하여 기능을 확장하시오
        //예) Tv에 vol변수를 추가하여 tv볼륨이 변경되면 스피커의 볼륨이 변경되도록 수정하시오.
        // // 스피커의 볼륨이 변경되면? tv의 볼륨을 어떻게 변경할지 구성하시오.
        //4. 배열

        Tv t;
        //new : 인스턴스(클래스 기반으로 새로 생성) : heap메모리에 실체하는 객체
        t = new Tv();
        Tv t1 = new Tv();
        Tv t2 = new Tv();
        t.channel = 7;
        t1.channel = 10;
        t2.channel = 20;
        t.channelDown();
        System.out.println("현재 채널은 "+t.channel+"입니다.");
        System.out.println("현재 채널은 "+t1.channel+"입니다.");
        System.out.println("현재 채널은 "+t2.channel+"입니다.");

        System.out.println("--------------------------");

        System.out.println("현재 채널은 "+t.channel+"입니다.");
        System.out.println("현재 power는 "+t.power+"입니다");
        System.out.println("현재 vol는 "+t.vol+"입니다");

        //1. 클래스는 설계도, 인스턴스는 실체하는 객체
        //2. 인스턴스를 통하여 다양한 객체를 찍어낼 수 있다
        //3. 객체는 필드, 메서드, 생성자로 구성되어 있으며,
        //4. 보통 메서드를 사용하여 필드(변수)값을 수정한다

//        t.power();
        t.channelUp();
        t.setColor("검정");
        System.out.println("현재 power는 "+t.power+"입니다");
        System.out.println("현재 채널은 "+t.channel+"입니다.");

        System.out.println("--------------------------");

        t.setGameTitle("철권7");
        t.gameStart("playStation");
        t.power();
        t.gameStart("playStation");

    }
}

