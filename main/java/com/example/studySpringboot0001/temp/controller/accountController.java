package com.example.studySpringboot0001.temp.controller;


import com.example.studySpringboot0001.temp.entity.Signup;
import com.example.studySpringboot0001.temp.entity.account.AccountImpl;
//import com.example.studySpringboot0001.entity.testEntity;
//import com.example.studySpringboot0001.repository.TestEntityRepository;
import com.example.studySpringboot0001.temp.entity.testEntity;
import com.example.studySpringboot0001.temp.repository.TestEntityRepository;
import com.example.studySpringboot0001.temp.controller.tempSaveData.saveData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


//accounts.add(new Account(id1, pw1, email1, name1)); 배열에 새로운 인스턴스 계속 추가
//model.addAttribute("accountList", accounts); : model에 배열을 전달
//HTML에서 each 반복문 item : ${accountList} = (하나의 인스턴스 : ${배열명}) 데이터 하나씩 출력

//20221129 todo
//1. override : 메서드 재정의 : 동일한 메서드 명으로 다른 기능을 함으로써 메서드 명의 정의를 지속적으로 사용
//getInfo() : 인스턴스의 필드 조회라는 메서드 규칙(정의)를 계속 재정의(override)함으로써 기능 유지
//2. overloading(HashMap) : 생성자의 매개변수 갯수, 타입을 다양하게 함으로써 여러가지의 인스턴스 다양성를 생성
//3. CSS 상속 : header 만들기
//----CSS class는 하나의 tag에 속성 적용하되, 부모 속성이 동일할 경우 자식 속성이 덮어써서 적용됨
//----

@Controller
public class accountController {

//    static ArrayList<Account> accounts = new ArrayList<>();
    public static ArrayList<Signup> signups = new ArrayList<>();
    static int count = 0;

    //class이름을 대문자로 쓰면 변수명은 소문자로 하자! = 암묵적 룰 = 인텔리제이는 자동완성
    private final TestEntityRepository testEntityRepository;

    //외부에 있는 필드를 쓸려면, 인스턴스를 생성(주입받아야 하는데) 생성자가 반드시 있어야 한다
    //@Autowired : Spring이 controller 생성자를 필요할 때 알아서 작성(만든다)한다
    @Autowired
    public accountController(TestEntityRepository testEntityRepository) {
        this.testEntityRepository = testEntityRepository;
    }


//    private final TestEntityRepository testEntityRepository;
////
//    @Autowired
//    public accountController(TestEntityRepository testEntityRepository) {
//        this.testEntityRepository = testEntityRepository;
//    }

//    @GetMapping("insertAccount")
//    public String insertAccount(
//            @RequestParam(value = "id", required = false)String id1,
//            @RequestParam(value = "pw", required = false)String pw1,
//            @RequestParam(value = "email", required = false)String email1,
//            @RequestParam(value = "name", required = false)String name1,
//            Model model
//            ) {
//
//        //new Account() : 새로 인스턴스 생성 : heap메모리에 새로 만들어서 전달 >> accounts배열에 전달
//        //(id1, pw1, email1, name1) : 생성자에 선물에 4개의 인자값 전달하여 인스턴스 생성
//        accounts.add(new Account(id1, pw1, email1, name1));
//        //(타입 변수명 : 배열)
//        model.addAttribute("accountList", accounts);
//        return "account/insertAccount";
//    }

    @GetMapping("signup")
    public String signup() {
        return "account/signup";
    }

    @GetMapping("signup_list")
    public String signup_list(Model model) {
        model.addAttribute("signup_list", signups);
        return "account/signup_list";
    }

    @PostMapping("signup")
    public String signup_post(
            @RequestParam(value = "id", required = false)String id,
            @RequestParam(value = "name", required = false)String name,
            @RequestParam(value = "pw", required = false)String pw,
            @RequestParam(value = "email", required = false)String email,
            Model model
    ) throws NoSuchFieldException {
        System.out.println(id);
        System.out.println(pw);
        //@RequestParam(value="id"....
        //Signup signup = new Signup(매개변수);
        //*key값이 동일하면 value는 덮어써진다
//        HashMap<String, String> input = new HashMap<>();
//        input.put("id", id);
//        input.put("name", name);
//        input.put("pw", pw);
//        input.put("email", email);
//        Signup signup = new Signup(input);
        //* Map으로 생성자 매개변수 전달 <> Instance로 생성자 매개변수 전달
//        signups.add(signup);
//        Signup.setCount();

        saveData.accountImplList.add(new AccountImpl(id, pw, name, email, 2000));
        //testEntityRepository : controller에 접근했을 때 생성된 필드 testEntityRepository 인스턴스의 메서드 사용
        //save() : mysql DB의 table에 인스턴스를 넣어서 필드를 저장
        //new testEntity : 새로운 testEntity인스턴스 만들기
        //1L : 정수이지만 Long타입
//        testEntityRepository.save(new testEntity(10L, "abcde", "12345", "김준석"));

        //testEntityRepository.findAll() : testEntityRepository정의된 테이블의 모든 튜플을 꺼내오는 메서드
        //return 타입 list로 받음
        List<testEntity> result = testEntityRepository.findAll();

        for(testEntity item : result) {
            System.out.println(item.getId());
            System.out.println(item.getName());
        }

        apiResponseTest();

        model.addAttribute("list", result);


        return "login/login";
    }

    public Object apiResponseTest() {
        StringBuffer result = new StringBuffer();
        String jsonPrintString = null;

        try {
            String apiUrl = "http://localhost:8080/entityExample";
            URL url = new URL(apiUrl);
            HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
            urlConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));
            String returnLine;
            for(;(returnLine = bufferedReader.readLine()) != null;) {
                result.append(returnLine);
                System.out.println("------------------------------");
                System.out.println(returnLine);
            }
            bufferedReader.close();
            urlConnection.disconnect();
            System.out.println("------------------------------");
            System.out.println(result);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return null;
    }

}
