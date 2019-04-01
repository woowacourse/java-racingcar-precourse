package domain;

public class Main {
    public static void main(String[] args) {
        Control control = new Control();

        control.userInputCarNames();
        control.userInputLimitTime();
        control.gameStart();
        control.gameEnd();
    }
}