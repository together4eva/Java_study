public class PlayStation {
    String gameTitle;
    int vol;

    void setGameTitle(String input_gameTitle) {
        gameTitle = input_gameTitle;
    }
    void setVol(int input_vol) {
        vol = input_vol;
    }
    void gameStart() {
        System.out.println("게임 실행");
    }

    public String getGameTitle() {
        return gameTitle;
    }
}
