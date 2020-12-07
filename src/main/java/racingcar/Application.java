package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.inputInfoForPlayGame(scanner);

        playGame(racingCarGame);
    }

    private static void playGame(RacingCarGame racingCarGame) {
        racingCarGame.startCarRacing();
        racingCarGame.carRaceWinner();
    }
}
