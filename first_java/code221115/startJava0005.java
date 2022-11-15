public class startJava0005 {
/*
todo 221115
1. for/if
2. scanner와 버퍼 흐름

 */
         /*
        Q.0001
        숫자 1부터 30까지 순회하면서
        2로 나누어서 나머지가 없는 숫자(나머지0)을 출력하시오


         */

    public static void q0001() {
    for(int i =1;i<=30; i++){
        if(i%2==0) {
            System.out.println(i);
        }
    }
}
/*
Q.0002
1048을 지속적으로 1/2로 줄인다면 몇번에 걸쳐서 줄여야
2보다 작게 되는지 알 수 있는 코드를 작성하시오
*/
public static void q0002(){
    int a =0;
    for (int f=1048;f>1;f=f/2) {
        if (f % 2 == 0) {
            a = a + 1;
            System.out.println("횟수는" + a + "이고 나머지는" + f);
        }
    }

}
public static void q0002a(){
    int count = 0;
    for(int i = 1048;i>=1 ;i=i/2){
        if(i<=2){
            System.out.println(count+"회 줄였습니다");
        }
        count = count+1;
    }
}
    public static void main(String[] args0) {
        System.out.println("hello world");
//        q0001();
        q0002();
        q0002a();
//        int i = 0;
////        for(;;) //무한 반복
////        for (;i<10;i=i+2){
////            System.out.println(i);
////        }
////        for (int i =0; i<10; i++);
//        if (i == 0){
//            System.out.println("i=0 입니다");
//        }else if(i==1){
//            System.out.println("else if");
//        }else{
//            System.out.println("else");
//        }
//        if (i != 0){
//            System.out.println("i=0 아입니다");
//        }
//        if(true){
//            System.out.println("true");
//        }
//        if(2%2 ==0){
//            System.out.println("dd");
//        }



    }





}


