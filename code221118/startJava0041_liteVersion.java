public class startJava0041_liteVersion {

    public static void main(String[] args) {
        //randomRPS와 유사
        int play1 = random();
        int play2 = random();
        
        //matchPlayers와 유사
        if(play1<play2) {
            System.out.println("player1 = "+play1+" // player2 = "+play2);
            System.out.println("player2 승리");
        } else if (play1>play2) {
            System.out.println("player1 = "+play1+" // player2 = "+play2);
            System.out.println("player1 승리");
        }else {
            System.out.println("player1 = "+play1+" // player2 = "+play2);
            System.out.println("무승부");
        }
    }
    static int random() {
        int result = (int)(Math.random()*3);
        return result;
    }
}
