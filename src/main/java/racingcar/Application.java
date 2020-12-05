package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingGameReader racingGameReader = new RacingGameReader(scanner);
        racingGameReader.startGameReader();

        RacingGameEmulator racingGameEmulator = new RacingGameEmulator(
            racingGameReader.getCarNameInput(), racingGameReader.getPlayNum());
        racingGameEmulator.startRacingGame();
        racingGameEmulator.startRacingGameWinner();

    }
}
