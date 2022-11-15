public class startJava0002 {


    public static void main(String[] args) {
//        System.out.println("hello world");
//        int[] numArray = {1,2,3,4,5};
//        String[] stringArray = {"김지혁","김지혁2","김지혁3"};
//
//        System.out.println(numArray[0]);
//        System.out.println(stringArray[1]);
//
//        stringArray[1]="김지혁22";
//        numArray[0]= numArray[0]+10;
//        System.out.println(stringArray[1]);
//        System.out.println(numArray[0]);

//        고정배열 크기 할당 : 배열의 크기가 지정
//        배열의 영역(메모리 영역)이 할당되어 있으므로
//        메모리를 읽고 쓰는데 속도가 빠름

        String[] studentName = {};
        String[] studentName_array = new String[5];
//        HTML, CSS , PYTHON, PANDAS 4가지 과목을 배웠고
//        자기 숙력도 5점 만점에 점수를 작성하고 출력하시오
//        예)1,2,3,4,5점의 점수를 할당하고 평균 점수를 출력
        int[] gradeArray = new int[4];
        String[] gradeName = new String[4];

        gradeName[0] ="HTML";
        gradeName[1] ="CSS";
        gradeName[2] ="PYTHON";
        gradeName[3] ="PANDAS";

        gradeArray[0]=2;
        gradeArray[1]=2;
        gradeArray[2]=3;
        gradeArray[3]=3;
        System.out.println(
                "과목은 :"+gradeName[0]+"이고 점수는 :" +gradeArray[0]+"\n"+
                "과목은 :"+gradeName[1]+"이고 점수는 :" +gradeArray[1]+"\n"+
                "과목은 :"+gradeName[2]+"이고 점수는 :" +gradeArray[2]+"\n"+
                "과목은 :"+gradeName[3]+"이고 점수는 :" +gradeArray[3]);
        System.out.println(
                "평균 점수는 :"+(gradeArray[0]+ gradeArray[1]+gradeArray[2]+gradeArray[3])/4);
    }
}
