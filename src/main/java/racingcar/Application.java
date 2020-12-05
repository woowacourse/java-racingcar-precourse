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
            } catch (LongNameException e) {
                RacingGameException.printLongNameInputMessage(e);
            } catch (NameInputEmptyException e) {
                RacingGameException.printNameInputMessage(e);
            } catch (DuplicationException e) {
                RacingGameException.printDuplicationInputMessage(e);
            } catch (NoNameException e) {
                RacingGameException.printNoNameInputMessage(e);
            }
        }

        RacingGameSystemMessageOut.printTimesInput();
        int playNum = 0;
        while (true) {
            try {
                playNum = RacingGameException.checkTimesInputException(messageReader.submitTimes());
                break;
            } catch (NoNumberException e) {
                RacingGameException.printNoNumberInputMessage(e);
            } catch (ZeroNumberException e) {
                RacingGameException.printZeroInputMessage(e);
            } catch (MinusNumberException e) {
                RacingGameException.printMinusInputMessage(e);
            }
        }
        RacingGameSystemMessageOut.printResultMoves();
        RacingGameEmulator racingGameEmulator = new RacingGameEmulator(carNameInput, playNum);
        racingGameEmulator.startRacingGame();
        racingGameEmulator.startRacingGameWinner();

    }
}
