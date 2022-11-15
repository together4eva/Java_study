public class startJava0004 {
//    계산기 만들기 _part1
//    덧셈, 뺄셈, 나눗셈, 곱셈 메서드를 만들고,
//    n이라는 숫자에 덧셈 2회(10,20), 뺄셈 2회(14)
//    곱셈 2회(11,13), 나눗셈1회(12)을 하는 메서드를 만들고
//    실행하시오
static double n =0.0;

    public static void main(String[] args) {
        System.out.println("hello world");
        calc_operation();
        System.out.println("n의 값은 : "+n);


    }
    public static void calc_plus(double input){
        n= n+ input;
    }
    public static void calc_minus(double input){
        n= n- input;
    }
    public static void calc_division(double input){
        n= n* input;
    }
    public static void calc_multiplication(double input){
        n= n/ input;
    }
    public static void calc_operation(){
        calc_plus(10);
        calc_plus(20);
        calc_minus(14);
        calc_multiplication(11);
        calc_multiplication(13);
        calc_division(12);
    }

//    n이라는 숫자에 덧셈 2회(10,20), 뺄셈 2회(14)
    //    곱셈 2회(11,13), 나눗셈1회(12)을 하는 메서드를 만들고
//    실행하시오
}
