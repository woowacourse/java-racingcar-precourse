package racingcar.utils;

import static racingcar.constants.GameMessages.ERR_INVALID_NAMES;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class CarGameInputHandler {

    final private static int NAME_MAX_LENGTH = 5;
    final private static String DELIMITER = ",";

    public static List<String> getCarNames() throws IllegalArgumentException{
        List<String> names = Arrays.asList(Console.readLine().split(DELIMITER));
        if (!isValidNames(names)) {
            throw new IllegalArgumentException(ERR_INVALID_NAMES);
        }
        return names;
    }

    private static boolean isValidNames(List<String> names) {
        return names.stream().allMatch(CarGameInputHandler::isValidName);
    }

    private static boolean isValidName(String name) {
        return !name.isEmpty() && name.length() <= NAME_MAX_LENGTH;
    }

}
