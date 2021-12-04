package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Input {

    private final static String CAR_NAME_SEPARATOR = ",";
    private Printer printer = new Printer();
    private Validator validator = new Validator();

    public List<String> inputCarNames() {
        try {
            String carNames = Console.readLine();
            validator.validateCarName(carNames);

            return Arrays.asList(carNames.split(CAR_NAME_SEPARATOR));

        } catch (IllegalArgumentException exception) {
            printer.printException(exception);

            return inputCarNames();
        }
    }

    public int inputRoundNumber() {
        try {
            String roundNumber = Console.readLine();
            validator.validateRoundNumber(roundNumber);

            return Integer.parseInt(roundNumber);

        } catch (IllegalArgumentException exception) {
            printer.printException(exception);

            return inputRoundNumber();
        }
    }
}
