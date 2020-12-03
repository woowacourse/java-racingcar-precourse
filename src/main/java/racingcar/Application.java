package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        RacingGameSystemMessageOut.printNameInput();
        String carNameInput = scanner.nextLine();
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
