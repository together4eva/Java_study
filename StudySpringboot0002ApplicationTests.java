package com.example.studySpringboot0002;

import com.example.studySpringboot0002.component.scraping.Project3_kakaomap_scraping;
import com.example.studySpringboot0002.service.project3.Project3Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudySpringboot0002ApplicationTests {


	private Project3Service project3Service ;

	private Project3_kakaomap_scraping project3_kakaomap_scraping ;

	@Autowired
	public StudySpringboot0002ApplicationTests(Project3Service project3Service,
											   Project3_kakaomap_scraping project3_kakaomap_scraping) {
		this.project3Service = project3Service;
		this.project3_kakaomap_scraping = project3_kakaomap_scraping;
	}

	@Test
	void contextLoads() {
		project3Service.saveAllProject3db(this.project3_kakaomap_scraping.scraping());
	}

}
