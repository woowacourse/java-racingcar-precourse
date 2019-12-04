package util;

import java.util.Scanner;

class ExceptionHandler {
    static int askForTimesHandler(String input, Scanner scanner) {
        try {
            return parsedPositiveNumber(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            InputOutputHandler.printLine("잘못된 형식입니다.");
            return InputOutputHandler.askForTimes(scanner);
        }
    }

    private static int parsedPositiveNumber(int input) {
        if (input < 0) {
            throw new NumberFormatException();
        }
        return input;
    }
}
