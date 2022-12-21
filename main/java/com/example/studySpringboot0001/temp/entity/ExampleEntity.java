package com.example.studySpringboot0001.temp.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class ExampleEntity {
    private String id;

    public ExampleEntity() {
        this.id = "abcd";
    }

    public String getId() {
        return this.id;
    }
}
