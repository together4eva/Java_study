package com.example.studySpringboot0001.temp.controller.restController;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

// 복습 check : 네트워크 통신 return
// http://localhost:8080/entityExample의 경우에는 @RestController는 객체 또는 문자열 등으로 return을 줍니다.
// 만일, HTML로 연결된 URL이라면 어떤 값이 return 받는지 한 번 확인해보세요 (예) http://localhost:8090/signup

//scraping : 스크랩하는 중

@RestController
public class responseController {

    @GetMapping("/testJson")
    public void testJson() throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1262000/NoticeService2/getNoticeList2"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=서비스키"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("returnType","UTF-8") + "=" + URLEncoder.encode("JSON", "UTF-8")); /*XML 또는 JSON*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지 번호*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

    }

    @GetMapping("/responseJson")
    public void responseJson() {
        StringBuffer result = new StringBuffer();
        try {
            URL url = new URL("https://bigdata.gwangju.go.kr/gjAPI/trafficCard/trafficCard.rd?apiSrvCd=0049&pageNo=2&numOfRow=1");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();

            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            String returnLine = bufferedReader.readLine();
            System.out.println(returnLine);
//            String returnLine;
//            for(;(returnLine = bufferedReader.readLine()) != null;) {
//                result.append(returnLine);
//            }

            bufferedReader.close();
            urlConnection.disconnect();

        }catch (Exception e) {
            System.out.println(e);
        }
//        String word = result.toString();
//        JSONObject jObject = new JSONObject(word);

//        JSONObject response = jObject.getJSONObject("response");
//        JSONObject header = response.getJSONObject("header");
//        JSONObject body = response.getJSONObject("body");
//        System.out.println(response);
//        System.out.println(body);

    }

    @GetMapping("/responseTest")
    public Object responseTest() {

        //String : 수정할 수 없는 문자열 : String 문자열은 2진수 변환 및 연산 문제로 새로 메모리에 문자열을 만들고 연결하는 것이 빠름
        //StringBuffer : char[] : 수정할 수 있는 문자열이지만 불안함 : 메모리 주소가 변경되면 안되거나, 메모리 공간이 부족할 경우 쓰는 String타입
        //StringBuilder : 수정할 수 있는 문자열이지만 안전함 : StringBuffer + lock(뮤텍스) : 다른 명령 또는 객체가 변경하지 못하도록 막아버리는 String타입
        StringBuffer result = new StringBuffer();

        //HTTP URL 호출해서 return 문자열을 해석하기
        //http://localhost:8080/entityExample 호출해서 "김준석0001" 받아오기
        //https://bigdata.gwangju.go.kr/gjAPI/trafficCard/trafficCard.rd?apiSrvCd=0049&pageNo=2&numOfRow=1 JSON 파싱

        //JAVA코드 실행하다가 문제생기면 대처하는 코드 영역 : try{} 코드영역에서 에러나면 catch{}코드로 이동
        // : JVM에서 대처할 수 없는 (상정할 수 없는) 에러가 날 경우를 대비하기 위한 코드 영역
        try {
            //URL로 HTTP프로토콜로 요청하면 결과 내용을 받을 수 있는 class : 크롬 브라우저를 대체하는 수신기
            URL url = new URL("http://localhost:8090/signup");
            //HttpURLConnection : http프로토콜로 접속해주는 클래스(객체) + class가 다르기 때문에 형변환 필수
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //urlConnection 객체로 HTTP 통신 시작! >> 다른 서버에 접속
            urlConnection.connect();

            //BufferedInputStream HTTP프로토콜로 외부 서버와 접속을 하면 데이터를 받아오는데 방식이 byte[]배열이므로,
            //순차적으로 하나씩 받는 클래스
            BufferedInputStream bufferedInputStream = new BufferedInputStream(urlConnection.getInputStream());

            //BufferedReader : BufferedInputStream으로 byte[]배열로 데이터를 받아 온 것을 일반 문자열로 조합시켜주는 클래스
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedInputStream));

            String returnLine;
            //bufferedReader.readLine() : 조합한 문자열을 가지고 있는 bufferedReader라는 인스턴스에
            //readLine() 메서드를 사용하여 한 줄씩 읽어옴
            //읽어온 값을 returnLine이라는 String 변수에 저장
            for(;(returnLine = bufferedReader.readLine()) != null;) {
                result.append(returnLine);
            }

            //연결을 했으면 끊어주는 작업도 필수
            //HTTP로 받아온 데이터를 순차적으로 받아오는 bufferReader 객체가 다 읽는 작업을 완료하면 종료 명령 실행
            bufferedReader.close();
            //urlConnection 는 통신을 위한 통로로써 작업을 완료하면 외부 침입의 문제가 있을 수 있으므로 닫아야 함
            urlConnection.disconnect();
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("------11111-------");
        System.out.println(result);

        //toString() : Object에서 상속받은 메서드로 모든 값을 String으로 변환
        String word = result.toString();
        //split(기준점) : 분해 = StringTokenizer
        String[] wordList = word.split("<body>");

        String[] wordList_div = wordList[1].split("<div");
        for(String item : wordList_div) {
            System.out.println(item);
        }


        return null;
    }
}
