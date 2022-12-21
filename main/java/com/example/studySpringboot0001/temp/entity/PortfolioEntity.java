package com.example.studySpringboot0001.temp.entity;

//extends Account : Account를 부모클래스로 상속받음
public class PortfolioEntity extends Account {
    //필드 : 데이터
    private String title;
    private String subject;
    private int category;
    private String date;
    private String link;
    //생성자 : 초기값 : 오버로딩(매개변수 갯수, 타입에 따라 다양한 초기값을 설정하여 인스턴스 생성)
    public PortfolioEntity() {
        super("id_default", "pw_default", "email_default", "name_default");
    };
    public PortfolioEntity(String title, String subject, int category,
                           String date, String link
                           ) {
        super("id_default", "pw_default", "email_default", "name_default");
        this.title = title;
        this.subject = subject;
        this.category = category;
        this.date = date;
        this.link = link;
    }
    //메서드
    public String getTitle() {
        return this.title;
    }
    public String getSubject() {
        return this.subject;
    }
    public int getCategory() {
        return this.category;
    }
    public String getDate() {
        return this.date;
    }
    public String getLink() {
        return this.link;
    }

    public String getSuper() {
        return "";
    }

    //@Override : 덮어쓰기 : 동일한 메서드 이름일 경우 @Override 선언하면 코드가 덮어 써져서 실행 됨
    //상속받은 클래스의 메서드 명을 통일하여 다른 메서드에서 사용할 때, 이름이 파편화 되는 것을 방지하고,
    //통일성있게 메서드명 규칙을 지정하기 위한 기능
    //예) getInfo() 라는 메서드는 몇 개를 상속받든 모든 필드를 조회하는 메서드로 사용함
    // = @Override 선언을 하여 계속 메서드 코드를 덮어써서 실행
    @Override
    public void getInfo() {
        System.out.println(super.getId());
        System.out.println(super.getPw());
        System.out.println(super.getEmail());
        System.out.println(super.getName());
        System.out.println(this.getTitle());
        System.out.println(this.getSubject());
    }
}
