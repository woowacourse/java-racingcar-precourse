package racingcar;

import enums.ErrorMessage;
import enums.GameHost;

import java.util.Scanner;

public class GamePlayer {

    protected String[] inputNamesOfCars(Scanner scanner) {
        System.out.println(GameHost.ASK_NAMES_OF_CARS.getMessage());
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(GameHost.DELIMITER_TO_SPLIT_NAMES.getMessage());
    }

    protected int inputTurnsToTry(Scanner scanner) {
        System.out.println(GameHost.ASK_TURNS.getMessage());
        String turnsToTry = scanner.nextLine();
        if (!isNumberFormat(turnsToTry)) {
            System.err.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            return inputTurnsToTry(scanner);
        }
        return getAbsoluteValue(turnsToTry);
    }

    private boolean isNumberFormat(String turnsToTry) {
        try {
            Integer.parseInt(turnsToTry);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public int getAbsoluteValue(String turnsToTry) {
        int turnsToTryInt = Integer.parseInt(turnsToTry);
        if (turnsToTryInt < 0) {
            System.err.println(ErrorMessage.NEGATIVE_NUMBER.getMessage());
            return Math.abs(turnsToTryInt);
        }
        return turnsToTryInt;
    }
}
