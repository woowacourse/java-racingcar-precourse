package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        CarRacingGame carRacingGame = new CarRacingGame();
        carRacingGame.inputInfoForPlayGame(scanner);
        playGame(carRacingGame);
    }

    private static void playGame(CarRacingGame carRacingGame) {
        carRacingGame.inputTest();
        carRacingGame.startCarRacing();
    }
}
