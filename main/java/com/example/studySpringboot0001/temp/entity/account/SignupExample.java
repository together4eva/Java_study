package com.example.studySpringboot0001.temp.entity.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SignupExample {

    @Id
    private Long id;
    private String input_id;
    private String pw;
    private String email;
    private String name;
}
