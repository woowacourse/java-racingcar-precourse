package racingcar.utils;

import static racingcar.constants.GameMessages.ERR_INVALID_NAMES;
import static racingcar.constants.GameMessages.ERR_INVALID_NUMBER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CarGameInputHandler {

    final private static int NAME_MAX_LENGTH = 5;
    final private static String DELIMITER = ",";
    private static final char DELIMITER_CHAR = ',';

    public static List<String> getCarNames() throws IllegalArgumentException {
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(DELIMITER));
        if (!isValidFormat(input) || !isValidNames(names)) {
            throw new IllegalArgumentException(ERR_INVALID_NAMES);
        }
        return names;
    }

    public static int getPlayCount() throws IllegalArgumentException {
        String number = Console.readLine();
        if (!isValidPlayCounts(number)) {
            throw new IllegalArgumentException(ERR_INVALID_NUMBER);
        }
        return Integer.parseInt(number);
    }

    private static boolean isValidPlayCounts(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isValidNames(List<String> names) {
        return isNonDuplicatedNames(names)
            && names.stream().allMatch(CarGameInputHandler::isValidName);
    }

    private static boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= NAME_MAX_LENGTH;
    }

    private static boolean isValidFormat(String name) {
        return name.chars()
            .filter(c -> c == DELIMITER_CHAR)
            .count() + 1 == name.split(DELIMITER).length;
    }

    private static boolean isNonDuplicatedNames(List<String> names) {
        return names.size() == names.stream().distinct().count();
    }

}
