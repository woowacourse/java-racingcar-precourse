package racingcar;

public class Application {
    public static void main(String[] args) {
        RacingSystem s = new RacingSystem();
        s.input();
        s.racingStart();
        s.printWinners();
    }
}