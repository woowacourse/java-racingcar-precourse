package view;

import utils.NameValidator;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> inputPlayerName(Scanner scanner) {
        List<String> inputs = InputParser.splitStringByComma(scanner.next());

        checkLengthName(inputs);

        return inputs;
    }

    public static int inputTryTimes(Scanner scanner) {
        int tryTimes = scanner.nextInt();

        return tryTimes;
    }

    private static void checkLengthName(List<String> inputs) {
        for (String input : inputs) {
            NameValidator.checkInputLengthLessThanValue(input);
            NameValidator.checkInputLengthNotZero(input);
        }
    }
}
