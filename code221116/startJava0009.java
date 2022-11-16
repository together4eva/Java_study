import java.util.ArrayList;
import java.util.Scanner;

public class startJava0009 {

    //가변배열 : 길이가 늘어나거나 줄드는 변화가 있는 배열
    //ArrayList : 컬렉션 프레임워크의 일종 List 안에 있는 타입
    //컬렉션 프레임워크 란? 자바에서 기본적으로 제공하는 고정적인 타입 외에
    //연산속도, 개발의 편의를 위한 타입을 모아둔 패키지
    //예) List, Map, Tree, vector가 있음.
    //Map의 경우 파이썬의 딕셔너리, 슬라이드와 대응
    //List는 Pandas와 같은 배열과 대응

    public static void main(String[] args) {
        System.out.println("hello world");

        String[] arrFixed = new String[5];
        arrFixed[0] = "김준석";
        arrFixed[1] = "박준석";
        ArrayList<String> arr0001 = new ArrayList<>();
        arr0001.add("김준석");
        arr0001.add("박준석");

        //get(INDEX) : 값을 출력
        System.out.println(arr0001.get(0));

        //set(INDEX, VALUE) : INDEX위치에 값(VALUE)을 덮어쓰기
        arr0001.set(0, "이준석");
        System.out.println(arr0001.get(0));

        //contains(VALUE) : VALUE의 값이 존재하는 출력 (true, false)
        //indexOf(VALUE) : VAlUE값이 어느 위치에 있는 출력
        System.out.println(arr0001.contains("이준석"));
        System.out.println(arr0001.indexOf("박준석"));

        // remove(INDEX) : INDEX 배열의 칸 삭제하고 뒤에 있는 배열을 한칸씩 당겨옴
        arr0001.remove(0);
        System.out.println(arr0001.get(0));
        // size() : 가변배열의 길이를 출력 = length()
        System.out.println(arr0001.size());

    }
}