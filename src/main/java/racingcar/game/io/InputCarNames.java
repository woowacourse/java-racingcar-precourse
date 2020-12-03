package racingcar.game.io;

import java.util.Scanner;
import racingcar.game.Cars;
import racingcar.game.io.error.CarNameInputErrorHandler;
import racingcar.game.io.print.InputPrint;

public class InputCarNames {
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
        } while (!errorHandler.isValidInput(inputStr));
        return cars;
    }

    private void createCars(String[] carNames) {
        for (String name : carNames) {
            cars.createCar(name);
        }
    }

    private String[] splitCarNames(String inputStr) {
        return inputStr.split(",");
    }

    private String getInputCarNames(Scanner scanner) {
        return scanner.nextLine();
    }
}
