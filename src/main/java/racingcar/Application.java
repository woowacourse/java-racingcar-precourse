package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingGameSystemMessageOut.printNameInput();
        String carNameInput = scanner.nextLine();

        RacingGameSystemMessageOut.printTimesInput();
        int playNum = scanner.nextInt();

        RacingGameSystemMessageOut.printResultMoves();
        RacingGameEmulator racingGameEmulator = new RacingGameEmulator(carNameInput, playNum);
        racingGameEmulator.startRacingGame();
        racingGameEmulator.startRacingGameWinner();

    }
}
