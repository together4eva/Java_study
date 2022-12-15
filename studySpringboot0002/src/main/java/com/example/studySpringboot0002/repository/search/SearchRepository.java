package com.example.studySpringboot0002.repository.search;

import com.example.studySpringboot0002.entity.search.searchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchRepository extends JpaRepository<searchHistory, Long> {
}
