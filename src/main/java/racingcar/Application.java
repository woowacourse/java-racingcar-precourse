package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        String carNameInput;
        RacingGameSystemMessageOut.printNameInput();
        while (true) {
            try {
                 carNameInput = RacingGameException.checkNameInputException(scanner.nextLine().trim());
                 break;
            } catch (NullPointerException e) {
                RacingGameException.printNameInputMessage();
            }
        }

        RacingGameSystemMessageOut.printTimesInput();
        int playNum = 0;
        while(true) {
            try {
                playNum = RacingGameException.checkTimesInputException(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                RacingGameException.printInvalidInputMessage();
            } catch (IllegalAccessException e) {
                RacingGameException.printZeroInputMessage();
            } catch (Exception e) {
                RacingGameException.printMinusInputMessage();
            }
        }
        RacingGameSystemMessageOut.printResultMoves();
        RacingGameEmulator racingGameEmulator = new RacingGameEmulator(carNameInput, playNum);
        racingGameEmulator.startRacingGame();
        racingGameEmulator.startRacingGameWinner();

    }
}
