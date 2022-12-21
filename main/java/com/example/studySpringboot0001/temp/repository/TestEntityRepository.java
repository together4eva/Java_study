package com.example.studySpringboot0001.temp.repository;

import com.example.studySpringboot0001.temp.entity.testEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//interface : 명세서 : 특정 class를 만들기 전에 핸들링하는 영역
//상속 챕터를 공부할 때, interface는 기능을 구현하는 가이드로 쓰임 = DB JPA를 쓰기 위한 가이드
//extends JpaRepository<?,?> : JpaRepository interface를 상속받아서 기능 씀, <Entity, PK_TYPE> : 매개변수로 쓰임
//Entity를 통해 어떤 테이블에 접속해서 DB를 활용할지 매개변수 필요
public interface TestEntityRepository extends JpaRepository<testEntity, Long> {
    //코드~코드~? 기본적으로 Select, Insert, Update, Delete는 이미 구현
}
