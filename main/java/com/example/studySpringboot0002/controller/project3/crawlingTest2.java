package com.example.studySpringboot0002.controller.project3;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class crawlingTest2 {
    public static void main(String[] args) throws IOException {
        String URL = "https://map.kakao.com/link/search/수원시청음식점";
        Document doc;
        try {
        // 자료를 가져올 사이트에 연결하기
        doc = Jsoup.connect(URL).get();
//        System.out.println(doc.data());

        Elements titles = doc.getElementsByClass("link_name");
//        Elements titles = doc.select("strong.tit_name > a .link_name");
        for (int i = 0; i < titles.size(); i++) {

            Element title = titles.get(i);
            System.out.println(title.text());

            CrawlingExample crawlingExample = new CrawlingExample();

            System.out.println(crawlingExample);


        }


    }catch(IOException e){
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}




}
