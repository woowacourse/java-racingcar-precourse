package racingcar;

import java.util.Scanner;

public class RacingGameReader {

    private String carNameInput;
    private int playNum = 0;
    RacingGameSystemMessageIn messageReader;

    public RacingGameReader(Scanner scanner) {
        messageReader = new RacingGameSystemMessageIn(scanner);
    }

    public void startGameReader() {
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
    }

    public String getCarNameInput() {
        return this.carNameInput;
    }

    public int getPlayNum() {
        return this.playNum;
    }
}
