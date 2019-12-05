package domain;

public class main {
    public static void main(String[] args) {
        gameMc Mc = new gameMc();
        Mc.gameStart();
        Mc.setCarList();
        Mc.gameProcess();
        Mc.scoring();
        Mc.awarding();

    }
}
