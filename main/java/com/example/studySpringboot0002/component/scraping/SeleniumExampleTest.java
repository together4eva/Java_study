package com.example.studySpringboot0002.component.scraping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.List;

//selenium : 동적인 데이터 수집 가능 (직접 브라우저를 통제해서 사람처럼 브라우저 작동을 하여 데이터 수집) : chromeDriver
//jsoup : httpRequest 사용해서 정적인 데이터(HTML, CSS..)를 수집
@Service
public class SeleniumExampleTest {


    //selenum 드라이버 다운
    private static WebDriver driver;
    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver";

//    private static final String WEB_DRIVER_PATH = "/Users/js/Cleancode/lecture_spring_2_crudProject/src/main/resources/static/tool/chromedriver";
//    private static final String WEB_DRIVER_PATH = "D:/Cleancode/projectCovid19Server110/src/main/resources/static/tool/chromedriver.exe";
    private static final String WEB_DRIVER_PATH = "D:/KIMJIHYEOK/chromedriver.exe";
    //메서드 매개변수로 받아서 스크래핑 동작을 위한 변수 선언
    private static String base_url;

    public static void main(String[] args) {
        scraping();
    }

    public static void scraping() {
        //System.io : 개발한 자바 프로그램(런타임)에서 외부 프로그램을 작동하기 위한 객체
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        driver = new ChromeDriver();
        base_url = "https://map.kakao.com/link/search/수원시청음식점";
        driver.get(base_url);
        List<WebElement> elements_button;
        List<WebElement> elements_button1;
        List<WebElement> elements_button2;
        List<WebElement> elements_button3;
        try {
            Thread.sleep(10000);
//            List<WebElement> elements_span = driver.findElements(By.tagName("span"));
//            int checkNum1 = 0;
//            for(WebElement e : elements_span) {
//                System.out.println(checkNum1);
//                System.out.println(e.getText());
//                checkNum1++;
//            }
            //스크래핑할 페이지의 전체 데이터 출력
//            System.out.println(driver.getPageSource());

            //tag search
            elements_button = driver.findElements(By.className("link_name"));
//            elements_button1 = driver.findElements(By.className("num"));
            elements_button1 = driver.findElements(By.cssSelector("em[data-id='scoreNum']"));
            elements_button2 = driver.findElements(By.className("numberofscore"));
            elements_button3 = driver.findElements(By.cssSelector("em[data-id='numberofreview']"));

            for (int i = 0; i < elements_button.size(); i++) {

                String title = elements_button.get(i).getText();
                String num = elements_button1.get(i).getText();
                String numberofscore = elements_button2.get(i).getText();
                String numberofreview = elements_button3.get(i).getText();

                System.out.println("아아------------------------------------------");
                System.out.println("음식점명 :"+title);
                System.out.println("평점 :"+num);
                System.out.println("평점 리뷰 수 :"+numberofscore);
                System.out.println("리뷰 수 :"+numberofreview+"건");
                System.out.println("아아------------------------------------------");
            }

//            int checkNum = 0;
//
//            for(WebElement e : elements_button) {
//                List<WebElement> elements_span = e.findElements(By.tagName("span"));
//
//
//                checkNum = 0;
//                for(WebElement e_span : elements_span) {
//                    if(!e_span.getText().equals("")) {
//
//                        checkNum++;
//                    }
//                }
//
//            }

            //css 출력
//            List<WebElement> elements_canvas = driver.findElements(By.tagName("canvas"));
//            for(WebElement e : elements_canvas) {
//                System.out.println(e.getCssValue("width"));
//            }

            //css selector
//            List<WebElement> css_tag_test = driver.findElements(By.cssSelector(".name"));
//            for(WebElement e : css_tag_test) {
//                System.out.println(e.getText());
//            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //공식문서에서는 close()가 아니라 quit() 권장
            driver.quit();

        }

    }
}
