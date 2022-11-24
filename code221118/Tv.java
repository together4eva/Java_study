public class Tv {
    //전역변수, 필드, 맴버변수
    String color;
    boolean power;
    int channel;
    int vol;

    PlayStation playStation = new PlayStation();
    Xbox xbox = new Xbox();
    Camcorder camcorder = new Camcorder();
    Speaker speaker = new Speaker();

    //메서드 : 동적으로 동작하는 기능을 정의 : 행위
    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
    void setColor(String input_color) {
        color = input_color;
    }
    void startCam() {
        if(power) {
            camcorder.startCam();
        }else {
            System.out.println("Tv Power를 On시켜주세요");
        }
    }
    void setVol(int input_vol) {
        vol = input_vol;
        speaker.setVol(input_vol);
    }
    void gameStart(String gameMachine) {
        //TV에 붙어있는 인스턴스들(게임기, 스피커, 캠코더) 들은 TV파워가 켜져있는지 조건문을 확인하고 실행
        if(power) {
            switch (gameMachine) {
                case "playStation" : {
                    playStation.gameStart();
                    break;
                }
                case "xbox" : {
                    xbox.gameStart();
                    break;
                }
            }
        }else {
            System.out.println("Tv Power를 On시켜주세요");
        }
    }
    void setGameTitle(String gameTitle) {
        playStation.setGameTitle(gameTitle);
        System.out.println(playStation.getGameTitle());
    }


}
