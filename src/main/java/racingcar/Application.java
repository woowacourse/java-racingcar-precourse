package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO 구현 진행

        Cars cars = GameSystem.createCars(scanner);
        int numberOfRounds = GameSystem.getNumberOfRounds(scanner);

        RacingGame racingGame = new RacingGame();
        racingGame.startRacing(cars, numberOfRounds);

        GameSystem.replayOrQuit(scanner);
    }
}
