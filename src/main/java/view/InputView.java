package view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> inputPlayerName(Scanner scanner) {
        List<String> inputs = InputParser.splitStringByComma(scanner.next());

        return inputs;
    }

    public static int inputTryTimes(Scanner scanner) {
        int tryTimes = scanner.nextInt();

        return tryTimes;
    }
}
