package com.example.studySpringboot0001.temp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.example.studySpringboot0001.component.exampleComponent;


//http://192.168.42.100:8080/hello
//http : 프로토콜 : 네트워크를 통해 컴퓨터에 접속하는 문
//192.168.42.100 : ip : 컴퓨터마다 고유의 식별자(네트워크 식별자)
//8080 : port : 프로그램에 접속하는 문
//  /hello : route : 프로그램에서 지정하는 경로

//외부 요청에 대해 응답하는 라우딩(경로) 제어
//localhost:8080 << 주소
//          / : 경로
@Controller
public class exampleController {
    
    //클라이언트의 요청에 따라 다음과 같은 순서로 springboot 실행
    //1. @Controller
    //2. @Mapping(경로) 경로에 맞는 메서드 실행
    //3. return "문자열" = HTML파일명으로 이동

    //클라이언트에서 특정 데이터를 전달하고 return 받는 흐름
    //1. 클라이언트 문자열을 목적지에 key와 value로 전달 : form tag의 name(key), 데이터(value)
    //2. @RequestParam(value 속성)의 key값을 통해 value값을 매개변수에 저장 >> 매개변수를 활용
    //3. model객체(장바구니)에 데이터를 넣고(key:value) HTML 타임리프 문법으로 전달 후 클라이언트에게 return

    // 문제1.
    // 1) 회원가입
    // ---- id, pw, email, name 을 클라이언트에게 받은 서버는 account라는 인스턴스를 만들어서
    // ---- accounts 배열(가변)에 순차적으로 저장
    // 2) 회원가입 목록 출력
    // ---- 목록보기 라는 버튼을 누르면, accountList.html 로 연결이 되어
    // ---- 회원 목록이 테이블로 출력되는 페이지를 만드시오 : <table> 타임리프의 반복문

//    @Autowired
//    exampleComponent test;

    @GetMapping("code20221123")
    public String code20221123(@RequestParam(value = "exampleKey", required = false)String exampleKey,Model model) {
        System.out.println(exampleKey);
        model.addAttribute("exampleReturn", exampleKey);
        return "code20221123";
    }


    @GetMapping("graph")
    public String graph(Model model) {
        model.addAttribute("graph0001", "500");
        model.addAttribute("graph0002", "300");
        model.addAttribute("graph0003", "200");

        model.addAttribute("graph0001_height", "50px");
        model.addAttribute("graph0002_height", "height : 30px; background-color:black");
        model.addAttribute("graph0003_height", "20px");
        return "graph/graph";
    }

    //          /값을 요청하면 코드 실행하는 메서드
    @GetMapping("/")
    public String index() {
        // index라는 문자열을 반환하고
        // 디스페처서블릿이 문자열과 동일한 html파일을 연결
        return "index";
    }

    //1. /rps 요청을 받으면,
    //클라이언트에서 form tag로 가위바위보 중에 하나의 string문자를 server에 전달하고 서버는 받을 수 있도록 구성
    //2. server에서 받은 가위,바위,보를 컴퓨터에서 랜덤으로 출력한 가위바위보와 비교하여
    //승리한 player가 컴퓨터인지 클라이언트인지 html파일에서 출력하시오.
    //예) html에서 컴퓨터 가 이겼습니다 혹은 유저 가 이겼습니다. 문구 출력

    //3. 버튼 형식으로 가위바위보 게임을 구성하시오
    //가위, 바위, 보 문자열을 입력하고 서버에 전달하는 방식에서
    //버튼을 누르면 서버에 가위바위보 문자열이 자동으로 전달하는 html코드를 작성하시오
    //4. submit버튼을 클릭시 check0001이라는 key값에 많은 텍스트가 전달되는 textarea를 활용하여
    //다량에 문자열 데이터를 전달하시오
    //--POST방식과 GET방식의 차이점
    //--GET : URL주소에 key:value형식으로 데이터 전달 : 간결하고 빠름 (255byte 이하)
    //--POST : body에 데이터를 담아서 서버에 전달 : 많은 문자열 및 데이터를 전달 가능 (4GB까지 전달 가능)
    //--GET방식은 URL에 정보가 표현되어 은닉이 불가능하지만, POST는 가려져 있어서 은닉성 있음.

    @GetMapping("/rps")
    public String rps(
            @RequestParam(value = "userRps", required = false)String rpsUser,
            @RequestParam(value = "check0001", required = false)String check0001,
            @RequestParam(value = "check", required = false)String check,
            Model model
    ) {
        System.out.println(rpsUser);
        System.out.println(check0001);
        System.out.println(check);
        if(rpsUser == null) {
            rpsUser = "not value";
        }
        //문자열 가위바위보를 int로 바꾸는 메서드
        int play1 = stringRpsToIntRps(rpsUser);
        int play2 = randomRPS();
        String result = matchPlayers(play1, play2);
        //model이라는 장바구니에 key값 resultKey에 result문자열 넣기
        model.addAttribute("resultKey", result);
        return "game/rps";
    }

    @PostMapping("/rps")
    public String rps1(
            @RequestParam(value = "userRps", required = false)String rpsUser,
            @RequestParam(value = "check0001", required = false)String check0001,
            @RequestParam(value = "check", required = false)String check,
            Model model
    ) {
        System.out.println(rpsUser);
        System.out.println(check0001);
        System.out.println(check);
        if(rpsUser == null) {
            rpsUser = "not value";
        }
        //문자열 가위바위보를 int로 바꾸는 메서드
        int play1 = Integer.parseInt(check);
        int play2 = randomRPS();
        String result = matchPlayers(play1, play2);
        //model이라는 장바구니에 key값 resultKey에 result문자열 넣기
        model.addAttribute("resultKey", result);
        return "game/rps";
    }

    private int stringRpsToIntRps(String rps) {
        //문자열을 가위바위보에 맞는 0,1,2로 리턴
        if(rps.equals("가위")) {
            return 0;
        }else if(rps.equals("바위")) {
            return 1;
        }else if(rps.equals("보")) {
            return 2;
        }else {
            return -1;
        }
    }

    //localhost:8080/hello?test=김준석
    //@RequestPram : client가 요청하는 값을 받는 객체
    //client가 test라는 key값과 value를 전달하면
    //@RequestParam이 key를 기준으로 데이터를 받음 >> 매개변수로 전달
    //Model : html에 이동하는 장바구니
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "test", required = false)String test, Model model) {
        String reqParam = test;
        System.out.println(reqParam);
        int play1 = randomRPS();
        int play2 = randomRPS();
        String result = matchPlayers(play1, play2);
        model.addAttribute("rps", result);
        //model.addAttribute(KEY, VALUE);
        //model에 key, value형식으로 장바구니 담음
        //html에서 ${KEY}값을 작성하면 VALUE값이 출력하여 client에 전달
        model.addAttribute("req", reqParam);
        return "hello";
    }

    private String matchPlayers(int play1, int play2) {
        String winPlayer = "";
        if(play1<play2) {
            winPlayer = "2번 플레이어가 이겼습니다";
        }
        if(play1>play2) {
            winPlayer = "1번 플레이어가 이겼습니다";
        }
        if(play1 == play2) {
            winPlayer = "무승부 입니다";
        }
        return winPlayer;
    }

    private int randomRPS() {
        return (int)(Math.random()*3);
    }

//    @PostMapping()
//    public Hello post(@RequestBody Param param) {
//        String msg = "Data1 : " + param.getData1() + ", Data2 : " + param.getData2();
//        Hello hello = new Hello(0, msg);
//        return hello;
//    }
}
