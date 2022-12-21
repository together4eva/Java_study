package com.example.studySpringboot0001.temp.controller;

import com.example.studySpringboot0001.temp.entity.ExampleEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.example.studySpringboot0001.temp.component.RandomComponent.*;

//1. random으로 노란색, 빨간색, 파란색, 검정색 중에 하나를 뽑아서
//model에 들어갈 graphData0001 key값에 background-color 속성을 넣는 메서드를 완성하시오
//html를 새로고침할 때마다 색상이 랜덤으로 출력되게 만드시오

//2. grid의 2번째 item에 div그래프를 3개를 꽉차게 만들어 넣으시오
//item 안에 width 200px, height 200px이라고 하면,
//div 3개가 각각 50px, 100px, 50px 혹은 30px, 70px, 100px 등등
//item의 200px을 채워서 출력하도록 구성하시오 (랜덤으로)

//   action : @Conroller에 목적지인 위치 (@GetMapping)
//    <input type="text" name="inputdata"> name : KEY값이며 Controller에서 받는 @RequestParam의 Value값
//   attrappend : css 스타일을 덮어 씀 (기존에 있는 속성은 덮어씀)

//HTML(클라이언트)의 action목적지 = @GetMapping("목적지")
//@RequestParam : 클라이언트에서 받은 데이터를 연결 (KEY값 : value = name)
//model : 타임리프(HTML)에 데이터를 전달하는 장바구니

//todo 20221125
// 1. 자바스크립트와 타임리프 연동 (CSS와 타임리프 연동)
// <script th:inline="javascript">
//    /*<![CDATA[*/
// 2. 그래프 연동 (javascript)
// plotly.com/javascript/ 활용
// 3. css 구조 설계 : grid



@Controller
public class graphController {

//    @Autowired
//    ExampleEntity exampleEntity;

    //@GetMapping : 클라이언트가 요청하는 경로를 연결
    //public : 공개한다
    //String : 이 메서드가 종료되면 return하는 타입이 문자열이다
    @GetMapping("graph0001")
    public String graph0001(Model model) {
        //model은 장바구니 : 데이터 전달은 문자열이 기본
//        String graphData0001 = "background-color:blue; height:50px";
        String graphData0001 = inputGraphData();
        System.out.println(graphData0001);
        ExampleEntity exampleEntity = new ExampleEntity();
        System.out.println(exampleEntity.getId());
        model.addAttribute("graphData0001", graphData0001);

        String[] graphDataArray = thirdGraph("200");
        model.addAttribute("graphData0011", inputGraphDataThird(graphDataArray[0]));
        model.addAttribute("graphData0012", inputGraphDataThird(graphDataArray[1]));
        model.addAttribute("graphData0013", inputGraphDataThird(graphDataArray[2]));
        return "graph/graph0001";
    }

    //HTML(클라이언트)의 action목적지 = @GetMapping("목적지")
    //@RequestParam : 클라이언트에서 받은 데이터를 연결 (KEY값 : value = name)
    //required = false : NULL허용
    //model : 타임리프(HTML)에 데이터를 전달하는 장바구니
    @GetMapping("graph0002")
    public String graph0002(@RequestParam(value = "inputData", required = false)String inputData, Model model) {
        String resultGraphData = inputGraphData2(inputData);
//        String graphData = "background: conic-gradient(#3F8BC9 30%, #F2F2F2 30%)";
        model.addAttribute("graphData", resultGraphData);
        model.addAttribute("graphDadaCount", "30.2");
        return "graph/graph0002";
    }

    @GetMapping("graph0011")
    public String graph0011(
            @RequestParam(value = "xdata", required = false)String xdata,
            @RequestParam(value = "ydata", required = false)String ydata,
            Model model) {
        model.addAttribute("xdata1", xdata);
        model.addAttribute("ydata1", ydata);
        return "graph/graph0011";
    }

    @GetMapping("graph0012")
    public String graph0012(Model model) {
        int[] test = {
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10),
                randomInt(10)};
        model.addAttribute("test",test);
        return "graph/graph0012";
    }

    @GetMapping("graph0015")
    public String graph0015(Model model) {
        model.addAttribute("test", "test0001");
        return "graph/graph0015";
    }

    private String inputGraphData2(String data1) {
        String result= "background: conic-gradient(#3F8BC9 ";
        result += data1;
        result += "%, #F2F2F2 ";
        result += data1;
        result += "%)";
        return result;
    }

    //함수형 프로그래밍 : 함수를 매개체로 사용하여 교체하는 프로그래밍
    //객체지향 프로그래밍 : 객체(데이터 단위)를 매개체로 사용하여 프로그래밍 구조를 작성
    private String inputGraphData() {
        String result = "";
        result += "background-color:";
        result += randomColor();
        result += "; ";
        result += "height:";
        result += random(100);
        result += "px";
        return result;
    }

    private String inputGraphDataThird(String input) {
        String result = "";
        result += "background-color:";
        result += randomColor();
        result += "; ";
        result += "height:";
        result += input;
        result += "px";
        return result;
    }


}
