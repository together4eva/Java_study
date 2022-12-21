package com.example.studySpringboot0001.temp.entity;

import java.util.ArrayList;
import java.util.HashMap;
// : 단일 주석 : 자기 편할 때 쓰는 주석(코멘트)
/*
 /* : 블럭주석(여러줄 주석)
 */

/*
 *  /** : 설명주석 : 공식문서(클래스 설명)를 발췌하기 위한 주석 (javaDoc : 라이브러리에서 주석을 발췌하여 html문서 만듬)
 * @author js
 * @version 1.1.2 (a.b.c) a:메이저 버전(기능 혁변), b:마이너 버전(소소한 기능 업데이트), c:fix버전(수정 용도 버전표기)
 * @retrun 리턴 값 설명 (void때에는 제외)
 * @since 변경사항 또는 추가사항이 언제 되었는지 기술
 *
 * @param : 매개변수 설명 : 메서드 위에 매개변수가 어디서 받고, 어떤 용도 쓰는지 작성
 * @exception : 또는 @throws 예외적인 상황에 대해 기술 (ex) null값이 들어 올때 처리 방법, 숫자 데이터가 와야되는데 문자열 올경우
 * @see : 참조 메서드, URL, 인터페이스, 클래스에 대해 기술 (상속)
 * @serial 직렬화(byte 혹은 객체를 표기할 수 있는 유일 값) 클래스 기재
 * @deprecated 클래스 내부에 다음 버전에 폐기되는 메서드 기재
 */

/**
 * @author js
 * @since 회원정보 class
 */
public class Signup {
    //필드
    private String id;
    private String name;
    private Integer idx;
    private String pw;
    private String email;
    static private Integer count = 0;

    //5. 매개변수가 많을 경우 어떻게 데이터를 전달할까?
    //예1) HashMap으로 key value 값을 저장하여 전달 : 다양한 데이터를 유형과 상관없이 전달 가능
    //예2) Class를 하나 정의하여 필드에 데이터를 저장하고 전달 : 필드값이 한정되어 있기 때문에 보안성 유리
    //회원가입 signup.html에서 전달해주는 데이터를 갖고 signup.class 인스턴스를 만들어서 배열에 저장하시오,
    //단, 매개변수가 많으므로, hashMap 또는 class로 데이터를 뭉쳐서 인자값을 전달하고 생성자를 만드시오.
    //생성자
//    public Signup(String ipAdr, String resident, String id, String name, Integer idx) {
//        super(ipAdr, resident);
//        this.id = id;
//        this.name = name;
//        this.idx = idx;
//    }

    /**
     * @author js
     * @version 0.1.0
     * @param HashMap<String,String>
     * @since 회원가입 생성자
     */
    public Signup(HashMap<String,String> inputData) {
        super();
        this.id = inputData.get("id");
        this.name = inputData.get("name");
        this.pw = inputData.get("pw");
        this.email = inputData.get("email");
        this.idx = count;
    }
//    public Signup(Vo vo) {
//        super(vo.id, vo.name);
//        this.resident = vo.resident;
//    }

    //메서드

    /**
     * @author js
     * @version 0.1.0
     * @since 회원정보 출력
     * @return HashMap<String, String>
     */
    public HashMap<String, String> getInfo() {
        //HashMap<String, String> : map 타입으로 안에 key은 String, value는 String
        //returnData 라는 변수명에 새로운 인스턴스 (new HashMap<>()) 할당
        HashMap<String, String> returnData = new HashMap<>();
        //put() : 값을 넣는다
        //put(KEY, VALUE) : key를 호출하면 value를 출력하는 map 구조
        returnData.put("id", this.id);
        returnData.put("pw", this.pw);
        returnData.put("email", this.email);
        returnData.put("name", this.name);
        returnData.put("idx", Integer.toString(this.idx));
        return returnData;
    }

    /**
     * @author js
     * @version 0.1.0
     * @since static count변수 값 1증가
     */
    public static void setCount() {
        count++;
    }

    public String getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getName() {
        return this.name;
    }
    public String getPw() {
        return this.pw;
    }
}
