package com.example.studySpringboot0001.temp.entity;


//왜 class? : 모든 데이터를 규격화 할 때 클래스(객체)로 만들어서 전달하기 때문에 객체지향 배움 (데이터 단위 기획)
//덤으로, 데이터를 전달 할 때 : HTML, CSS, Javascript를 포함하여 다른 포맷에 전달할 때도 객체기반으로 전달
//앞으로 mysql, flask(python), 다른 springboot에 데이터를 json포맷으로 데이터를 전달하는데 그것 또한 객체로 전달
// = 그러므로, 모든 데이터를 객체화 시키는 것을 능숙하게 해야 객체지향 프로그래밍을 할 수 있다 (특히, 빅데이터)
// entity = 인스턴스(자바) = 객체(객체지향 프로그래밍) = 튜플(DB) = object(자바스크립트)
public class StockLog {
    //필드
    private String time;
    private String company_name;
    private Integer buy_count;
    private Integer Buy_one_stock_price;

    //생성자 : 인스턴스를 처음 만들 때의 초기값(초기 스타일)지정.. 오버로딩(다양한 생성자(인스턴스)를 만드는 기술)
    public StockLog(String time, String company_name, Integer buy_count, Integer Buy_one_stock_price) {
        //this > "가장 가까운" stockLog라는 클래스
        //super > 부모 클래스 : 상속을 주는 대상 클래스(extends)이기 때문에 부모 클래스를 지칭하는 단어
        this.time = time;
        this.company_name = company_name;
        this.buy_count = buy_count;
        this.Buy_one_stock_price = Buy_one_stock_price;
    }
    //메서드 : 클래스(인스턴스)가 가지고 있는 행위 기능 (ACTIVATE함) : 호출하면 실행
    //public : 외부에서 접근 가능 <-> private(내부 클래스에서만 접근 가능)
    //String/Integer : 리턴 타입 : 메서드가 실행되고 난 뒤에 출력해주는 타입을 지칭
    public String getTime() {
        return this.time;
    }
    public String getCompany_name() {
        return this.company_name;
    }
    public Integer getBuy_count() {
        return this.buy_count;
    }
    public Integer getBuy_one_stock_price() {
        return this.Buy_one_stock_price;
    }

}
