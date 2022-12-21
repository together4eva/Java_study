package com.example.studySpringboot0001.temp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


@Controller
public class resourceController {


    //이미지 파일을 받기 위한 URL주소(요청)을 하면 이미지 파일을 다운(byte[]) 받을 것
    //MediaType.IMAGE_JPEG_VALUE : 요청한 내용은 이미지 값으로 전달되어야 한다 선언
    //@PathVariable : URL주소 중에 일부분을 변수로 받기 위한 속성
    //ResponseEntity : 요청에 대한 응답을 전달하기 위한 객체
    //{} : 변수 : 변하는 수
    @GetMapping(value = "image/{image_name}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> imageLoading(@PathVariable("image_name")String image_name) throws IOException {
        //path : 파일이 저장되어 있는 HDD(SSD)위치
        String path = "D://cleancode/studySpringboot0001/studySpringboot0001/src/main/resources/static/upload/"+image_name;
        //FileInputStream : Stream는 파일을 cpu에서 바로 읽을 수 있도록 하는 객체
        FileInputStream fis = new FileInputStream(path);
        //BufferedInputStream : Buffer : CPU의 빠른 속도 차이를 줄이기 위한 중간 계단(위치)
        BufferedInputStream bis = new BufferedInputStream(fis);
        //HDD(SSD)에 접근한 BufferedInputStream은 파일을 byte배열로 하나씩 읽어서 변수에 저장
        byte[] imgByteArr = bis.readAllBytes();
        //ResponseEntity : 요청한 클라이언트에게 이미지 byte배열을 리턴 전달
        //HttpStatus : 리턴 할 때 메타정보에 정상적으로 연산하고 리턴한다는 증표(확인문구)
        return new ResponseEntity<byte[]>(imgByteArr, HttpStatus.OK);
    }
}
