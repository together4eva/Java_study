package com.example.studySpringboot0002.controller.project3;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WebDriverUtil {


    private WebDriver driver;
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver"; // Properties 설정
    public static String WEB_DRIVER_PATH = "D:/KIMJIHYEOK/chromedriver.exe"; // WebDriver 경로

    public WebDriverUtil() {
        chrome();
    }

    private void chrome() {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);

        // webDriver 옵션 설정.
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        options.addArguments("--lang=ko");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.setCapability("ignoreProtectedModeSettings", true);

        // weDriver 생성.
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public void useDriver(String url) {
        driver.get(url) ;
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);  // 페이지 불러오는 여유시간.
        log.info("++++++++++++++++++++++===================+++++++++++++ selenium : " + driver.getTitle());


        WebElement searchLabel = driver.findElement(By.id("label-text"));
        log.info("++++++++++++++++++++++===================+++++++++++++ searchLabel : " + searchLabel.getText());

//WebDriverUtil webDriverUtil = new webDriverUtil;
//webDriverUtil.userDriver(url = "https://www.youtube.com/c/youtubekorea/videos");
    }

    private void quitDriver() {
        driver.quit(); // webDriver 종료


    }


    public static void main(String[] args) {
        WebDriverUtil webDriverUtil = new WebDriverUtil();
        webDriverUtil.useDriver("https://www.youtube.com/c/youtubekorea/videos");
    }




}