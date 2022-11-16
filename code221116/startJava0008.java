public class startJava0008 {

    //random = 랜덤으로 숫자를 뽑아내는 것
    // Math.Random()
    // Math.random() 메서드 : 0.? 소수점을 랜덤으로 표기
    // 1의 자리 랜덤으로 출력할려면 Math.random() 에 소수점을 좌측으로 한 번 옮기기
    // Math.random() * 10
    // 10의 자리 랜덤 출력은 * 100 ..

    // q0022
    // 로또 뽑기
    // 1~45번호 중 랜덤으로 6개의 숫자를 뽑는 기능을 구현
    // 1. 고정배열 6개 칸 만들기
    // Math.random() 0.0? ~0.9? 중에 하나를 출력
    // 2. Math.random() 메서드를 활용하여 1~45숫자 무작위 추출
    // 3. 추출된 값을 고정배열에 6개 채우기
    // int[] abc = new int[6];
    // 위 1~3 내용을 반복문으로 코드 구현하기
    // 4. 만일 같은 숫자가 뽑히면? 같은 숫자가 나오면 다시 랜덤으로 뽑는 기능 추가

    static int[] lottoList = new int[6];

    public static void main(String[] args) {

        System.out.println("hello world");

        for(int i = 0;lottoLastIndexCheck();i++) {
            // 1. 랜덤으로 숫자 뽑기
            int resultNum = randomNumberInit();
            resultNum = 10;
            // 1-2. 랜덤값이 배열에 중복되었는지 확인
            if(equalsNumberCheck(resultNum)) {
                i--;
                continue;
            }
            // 2. 뽑은 숫자 lottoList배열에 넣기
            lottoList[i] = resultNum;
        }


    }

    //랜덤으로 숫자 뽑기
    public static int randomNumberInit() {
        int num = (int)(Math.random()*45)+1;
        return num;
    }

    //반복문을 종료시키는 조건 : lottoList배열의 마지막 값 있는지 확인
    public static boolean lottoLastIndexCheck() {
        if(lottoList[5] == 0) {
            return true;
        }
        return false;
    }

    //같은 숫자 확인
    public static boolean equalsNumberCheck(int randomNum) {
        //배열에 넣기 전에 랜덤으로 뽑은 숫자가 배열에 안에 존재하는지 확인
        for(int i = 0; i<lottoList.length;i++ ) {
            if (lottoList[i] == randomNum) {
                return true;
            }
        }
        return false;
    }
}