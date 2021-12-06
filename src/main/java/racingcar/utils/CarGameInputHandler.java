package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class CarGameInputHandler {

    final private static String DELIMITER_NAME = ",";

    public static List<String> getValidCarNames() {
        return getValidInput(
            () -> {
                String input = Console.readLine();
                List<String> names = Arrays.asList(input.split(DELIMITER_NAME));
                InputValidator.validateCarNames(input, names);
                return names;
            }
        );
    }

    public static int getValidPlayCount() {
        return getValidInput(
            () -> {
                String number = Console.readLine();
                InputValidator.validatePlayCount(number);
                return Integer.parseInt(number);
            }
        );
    }

    private static <T> T getValidInput(Supplier<T> sup) {
        while (true) {
            try {
                return sup.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
