package com.example.studySpringboot0001.temp.entity.account.abstact;

//lombok이라는 라이브러리를 써서 @Getter, @Setter를 선언하면 자동으로 필드값을 조회하고 수정하는 메서드 생성
//@AllArgsConstructor : 필드값을 모두 저장하는 생성자를 만드는 어노테이션
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//추상클래스 : 상속받아서 구현해야함 (인스턴스 불가)
@Getter
@Setter
@AllArgsConstructor
public abstract class Account {
    private String id;
    private String pw;
    private String email;
    private String name;
    private Integer coin;

}
