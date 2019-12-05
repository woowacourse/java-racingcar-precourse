package domain;

public class main {
    public static void main(String[] args) {
        gameMc Mc = new gameMc();
        Mc.gameStart(); //경주할 자동차, 시동할 횟수 입력
        Mc.setCarList();
        Mc.gameProcess();
        Mc.scoring();
        Mc.awarding();
    }
}
