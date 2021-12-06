package racingcar;

public class Application {
    public static void main(String[] args) {
        RaceGame raceGame = new RaceGame(new DefaultChecker());
        raceGame.startGame();
    }
}
