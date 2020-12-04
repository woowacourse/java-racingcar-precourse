package utils;

import java.util.ArrayList;
import java.util.Scanner;

public class InputUtils {

    private static final int EMPTY = 0;
    private static final int FIVE = 5;
    private static final String COMMA = ",";

    private InputUtils() {
    }

    public static ArrayList<String> inputCarNames(Scanner scanner) {
        String[] stringArray = scanner.nextLine().split(COMMA);
        checkEmpty(stringArray);

        ArrayList<String> carNames = new ArrayList<>();
        for (String carName : stringArray) {
            checkEmpty(carName);
            checkExcess(carName);
            carNames.add(carName);
        }

        return carNames;
    }

    public static int inputLoopTime(Scanner scanner) {
        int integer = checkInteger(scanner.nextLine());
        checkOverZero(integer);
        return integer;
    }

    private static void checkEmpty(String string) {
        if (string.replaceAll(" ", "").length() == EMPTY) {
            throw new IllegalArgumentException(ErrorCodes.CAN_NOT_EMPTY);
        }
    }

    private static void checkEmpty(String[] stringArray) {
        if (stringArray.length == EMPTY) {
            throw new IllegalArgumentException(ErrorCodes.CAN_NOT_EMPTY);
        }
    }

    private static void checkExcess(String string) {
        if (string.length() > FIVE) {
            throw new IllegalArgumentException(ErrorCodes.CAN_ONLY_LESS_THAN_FIVE);
        }
    }

    private static int checkInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCodes.CAN_ONLY_INTEGER);
        }
    }

    private static void checkOverZero(int integer) {
        if (integer < 0) {
            throw new IllegalArgumentException(ErrorCodes.CAN_NOT_UNDER_ZERO);
        }
    }
}
