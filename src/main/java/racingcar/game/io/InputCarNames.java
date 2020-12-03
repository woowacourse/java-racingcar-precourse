package racingcar.game.io;

import java.util.Scanner;
import racingcar.game.Cars;
import racingcar.game.io.error.CarNameInputErrorHandler;
import racingcar.game.io.print.InputPrint;

public class InputCarNames {
    public static final char INPUT_DELIMITER = ',';
    private final Cars cars;
    private final CarNameInputErrorHandler errorHandler;

    public InputCarNames() {
        this.cars = new Cars();
        this.errorHandler = new CarNameInputErrorHandler();
    }

    public Cars getInputFromUserAndStore(Scanner scanner) {
        String inputStr;
        do {
            InputPrint.printMessageForInputCarNames();
            inputStr = getInputCarNames(scanner);
        } while (!errorHandler.createAndStoreIfIsValidInput(inputStr, cars));
        return cars;
    }

    private String getInputCarNames(Scanner scanner) {
        return scanner.nextLine();
    }
}
