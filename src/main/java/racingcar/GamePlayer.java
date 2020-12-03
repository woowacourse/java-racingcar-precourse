package racingcar;

import enums.ErrorMessage;
import enums.GameHost;

import java.util.Scanner;

public class GamePlayer {

    public String[] inputNamesOfCars(Scanner scanner) {
        System.out.println(GameHost.ASK_NAMES_OF_CARS.getMessage());
        String namesOfCars = scanner.nextLine();
        return namesOfCars.split(GameHost.DELIMITER_TO_SPLIT_NAMES.getMessage());
    }

    public int inputTurnsToTry(Scanner scanner) {
        System.out.println(GameHost.ASK_TURNS.getMessage());
        String turnsToTry = scanner.nextLine();
        int turnsToTryInt;
        try {
            turnsToTryInt = Integer.parseInt(turnsToTry);
        } catch (NumberFormatException nfe) {
            System.err.println(ErrorMessage.NUMBER_FORMAT.getMessage());
            turnsToTryInt = inputTurnsToTry(scanner);
        }
        return getAbsoluteValue(turnsToTryInt);
    }

    public int getAbsoluteValue(int turnsToTryInt) {
        if (turnsToTryInt < 0) {
            System.err.println(ErrorMessage.NEGATIVE_NUMBER.getMessage());
            return Math.abs(turnsToTryInt);
        }
        return turnsToTryInt;
    }
}
