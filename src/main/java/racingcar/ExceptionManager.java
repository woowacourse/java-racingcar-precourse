package racingcar;

import java.util.HashSet;
import java.util.regex.Pattern;

public class ExceptionManager {
    protected static final int MINIMUM_CAR_NAME_LENGTH = 1;
    protected static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    protected static final int MINUMUM_NUMBER_STAGE = 1;
    protected static final int MAXIMUM_NUMBER_STAGE = Integer.MAX_VALUE;

    public static GameStatus checkValidCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!isValidNameLength(carName)) {
                return GameStatus.INVALID_NAME_LENGTH;
            }
        }
        if (hasRedundancy(carNames)) {
            return GameStatus.DUPLICATED_NAME;
        }
        return GameStatus.OK;
    }

    public static GameStatus checkValidNumberStage(String input) {
        if (!isNumber(input)) {
            return GameStatus.INVALID_NUMBER_STAGE_TYPE;
        }
        if (!isValidNumberStageRange(input)) {
            return GameStatus.INVALID_NUMBER_STAGE_RANGE;
        }
        return GameStatus.OK;
    }

    private static boolean isNumber(String input) {
        String numberPattern = "[+-]?[0-9]+";
        return Pattern.matches(numberPattern, input);
    }

    private static boolean isValidNumberStageRange(String input) {
        try {
            int convertedNumber = Integer.parseInt(input);
            if (convertedNumber < MINUMUM_NUMBER_STAGE || convertedNumber > MAXIMUM_NUMBER_STAGE) {
                return false;
            }
        } catch (Exception exception) {
            return false;
        }
        return true;
    }

    private static boolean isValidNameLength(String carName) {
        int length = carName.length();
        if (length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH) {
            return false;
        }
        return true;
    }

    private static boolean hasRedundancy(String[] carNames) {
        HashSet<String> nameSet = new HashSet<String>();
        for (String carName : carNames) {
            nameSet.add(carName);
        }
        return (nameSet.size() != carNames.length);
    }
}
