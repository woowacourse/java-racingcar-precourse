package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class CarGameInputHandler {

    final private static String DELIMITER = ",";

    public static List<String> getValidCarNames() {
        return getValidInput(CarGameInputHandler::getCarNames);
    }

    public static int getValidPlayCount() {
        return getValidInput(CarGameInputHandler::getPlayCount);
    }

    private static List<String> getCarNames() throws IllegalArgumentException {
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(DELIMITER));
        InputValidator.validateCarNames(input, names);
        return names;
    }

    private static int getPlayCount() throws IllegalArgumentException {
        String number = Console.readLine();
        InputValidator.validatePlayCount(number);
        return Integer.parseInt(number);
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
