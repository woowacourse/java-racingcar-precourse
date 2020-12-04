package racingcar;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        RacingGameSystemMessageIn messageReader = new RacingGameSystemMessageIn(scanner);

        String carNameInput;
        RacingGameSystemMessageOut.printNameInput();
        while (true) {
            try {
                carNameInput = RacingGameException
                    .checkNameInputException(messageReader.submitCarNames());
                break;
            } catch (ArrayStoreException e) {
                RacingGameException.printLongNameInputMessage();
            } catch (NullPointerException e) {
                RacingGameException.printNameInputMessage();
            } catch (ArrayIndexOutOfBoundsException e) {
                RacingGameException.printDuplicationInputMessage();
            } catch (Exception e) {
                RacingGameException.printNoNameInputMessage();
            }
        }

        RacingGameSystemMessageOut.printTimesInput();
        int playNum = 0;
        while (true) {
            try {
                playNum = RacingGameException.checkTimesInputException(messageReader.submitTimes());
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
