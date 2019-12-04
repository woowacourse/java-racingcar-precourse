package util;

import java.util.InputMismatchException;
import java.util.Scanner;

class ExceptionHandler {
    private static final int NAME_MAX_LENGTH = 5;

    static int askForTimesHandler(String input, Scanner scanner) {
        try {
            return timesExceptionThrower(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            InputOutputHandler.printLine("잘못된 형식입니다.");
            return InputOutputHandler.askForTimes(scanner);
        }
    }

    private static int timesExceptionThrower(int input) {
        if (input < 0) {
            throw new NumberFormatException();
        }
        return input;
    }

    static String[] askForNamesHandler(String input, Scanner scanner) {
        try {
            return namesExceptionThrower(input);
        } catch (InputMismatchException e) {
            InputOutputHandler.printLine("잘못된 형식입니다.");
            return InputOutputHandler.askForNames(scanner);
        }
    }

    private static String[] namesExceptionThrower(String input) {
        checkIfIsBlank(input);
        String[] names = input.split(",");
        checkIfSplitIsBlank(names);
        for (String name : names) {
            checkNameValidity(name);
        }
        return names;
    }

    private static void checkIfIsBlank(String input) {
        if (input.isEmpty()) {
            throw new InputMismatchException();
        }
    }

    private static void checkIfSplitIsBlank(String[] names) {
        if (names.length < 1) {
            throw new InputMismatchException();
        }
    }

    private static void checkNameValidity(String name) {
        if (name.length() < 1) {
            throw new InputMismatchException();
        }
        if (name.length() > NAME_MAX_LENGTH) {
            throw new InputMismatchException();
        }
        if (!name.matches("^[a-zA-Z]*$")) {
            throw new InputMismatchException();
        }
    }
}
