package view;

import utils.NameValidator;
import utils.NumberValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> inputPlayerName(Scanner scanner) {
        List<String> inputs = InputParser.splitStringByComma(scanner.next());

        checkLengthName(inputs);

        return inputs;
    }

    public static int inputTryTimes(Scanner scanner) {
        String tryTimes = scanner.next();

        checkLengthTryTimes(tryTimes);

        return Integer.parseInt(tryTimes);
    }

    private static void checkLengthName(List<String> inputs) {
        for (String input : inputs) {
            NameValidator.checkInputLengthLessThanValue(input);
            NameValidator.checkInputLengthNotZero(input);
        }
    }

    private static void checkLengthTryTimes(String input) {
        NumberValidator.checkNumber(input);
        NumberValidator.checkNumberOverZero(Integer.parseInt(input));
    }
}
