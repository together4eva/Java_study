package com.example.studySpringboot0002.controller.project3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class crawlingTest3 {
    private WebDriver driver;

//    private static final String url = "https://yourei.jp/腕を磨く";
    private static final String url = "https://www.youtube.com/c/youtubekorea/videos";
    public void process() {
        System.setProperty("webdriver.chrome.driver", "C:\\KIMJIHYEOK\\chromedriver.exe");
        //크롬 드라이버 셋팅 (드라이버 설치한 경로 입력)

        driver = new ChromeDriver();
        //브라우저 선택

        try {
            getDataList();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();	//탭 닫기
        driver.quit();	//브라우저 닫기
    }


    /**
     * data가져오기
     */
    private List<String> getDataList() throws InterruptedException {
        List<String> list = new ArrayList<>();

        driver.get(url);    //브라우저에서 url로 이동한다.
        Thread.sleep(1000); //브라우저 로딩될때까지 잠시 기다린다.

        //WebElement sentence = driver.findElement(By.cssSelector("#sentence-example-list .sentence-list li"));
        //System.out.println(sentence.getText());
        //この先腕を磨いていけば、いつかはこの男に勝てる日がくるのだろうか。 ...
        //ベニー松山『風よ。龍に届いているか(下)』
        // findElement (끝에 s없음) 는 해당되는 선택자의 첫번째 요소만 가져온다
        WebElement searchLabel = driver.findElement(By.id("label-text"));
        System.out.println(searchLabel.getText());

        List<WebElement> elements = driver.findElements(By.cssSelector("#sentence-example-list .sentence-list li"));

        for (WebElement element : elements) {
            System.out.println("----------------------------");
            System.out.println(element);	//⭐
        }

        return list;
    }

}
//
//package com.example.studySpringboot0002.component.scraping;
//        import org.jsoup.Jsoup;
//        import org.jsoup.nodes.Document;
//        import org.jsoup.nodes.Element;
//        import org.jsoup.select.Elements;
//
//        import java.io.IOException;
//
//public class scraping_example {
//    public static void main(String[] args) throws IOException {
//        String URL = "https://map.kakao.com/link/search/수원시청음식점";
//        Document doc;
//
//        try {
//            // 자료를 가져올 사이트에 연결하기
//            doc = Jsoup.connect(URL).get();
//            System.out.println(doc);
////            System.out.println(doc.data());
//            System.out.println("-------------");
//            Elements titles = doc.getElementsByClass("placelist");
//            System.out.println(titles);
//            for (int i = 0; i < titles.size(); i++) {
//
//                Element title = titles.get(i);
//                System.out.println(title.text());
//            }
//        }catch(IOException e){
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//}
//



