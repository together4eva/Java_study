package com.example.studySpringboot0002.service.search;

import com.example.studySpringboot0002.entity.search.searchHistory;
import com.example.studySpringboot0002.repository.search.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SearchServiceImpl implements SearchService{

    private final SearchRepository searchRepository;
//    SearchServiceImpl 클래스는 DB와 연동하기 위해서 SearchRepository JPA(DB연동드라이버)를 필드로 가짐
//    생성자의 초기값을 통해 필드값을 만듬(SearchRepository 만들고, SearchImpl
    @Autowired
    public SearchServiceImpl(SearchRepository searchRepository) {
        this.searchRepository = searchRepository;
    }

    @Override
    public void saveSearchHistory(searchHistory input){
        this.searchRepository.save(input);

    }

    @Override
    public List<?> getDataTemp() {
        return null;
    }
}
