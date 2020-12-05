package racingcar;

import enums.ErrorMessage;
import enums.GameHost;
import maintenance.Mechanic;

import java.util.Scanner;

public class CommandCenter {
    Mechanic mechanic;

    CommandCenter(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    protected String[] inputNamesOfCars(Scanner scanner) {
        mechanic.setNumberOfNamesOfCarsWithForeAndAftBlank(0);
        mechanic.setNumberOfNamesOfCarsOverMaxLength(0);
        System.out.println(GameHost.ASK_NAMES_OF_CARS.getMessage());
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(GameHost.DELIMITER_TO_SPLIT_NAMES.getMessage());
    }

    protected int inputTurnsToTry(Scanner scanner) {
        System.out.println(GameHost.ASK_TURNS.getMessage());
        String turnsToTry = scanner.nextLine();
        if (!mechanic.isNumberFormat(turnsToTry)) {
            System.err.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            return inputTurnsToTry(scanner);
        }
        return mechanic.getAbsoluteValue(turnsToTry);
    }
}
