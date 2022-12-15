package com.example.studySpringboot0002.entity.search;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class searchHistory {

    @Id
    private Long id;
    private String textHistory;
    private String ipAddress;
    private String updateTime;
}