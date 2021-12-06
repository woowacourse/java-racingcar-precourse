package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class UserInput {

    private static final String DELIMITER_NAME = ",";

    public static List<String> getValidCarNames() {
        return getValidInput(
            () -> {
                String input = Console.readLine();
                InputValidator.validateCarNames(input);
                return Arrays.asList(input.split(DELIMITER_NAME));
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

    private static <T> T getValidInput(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
