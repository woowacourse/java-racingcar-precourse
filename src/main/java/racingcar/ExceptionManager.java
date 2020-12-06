package racingcar;

import java.util.HashSet;
import java.util.regex.Pattern;

public class ExceptionManager {
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    private static final int MINUMUM_NUMBER_ROUND = 1;
    private static final int MAXIMUM_NUMBER_ROUND = Integer.MAX_VALUE;

    public enum GameStatus {
        OK("에러가 발생하지 않았습니다."), 
        DUPLICATED_NAME("중복된 이름이 존재하면 안됩니다."), 
        INVALID_NAME_LENGTH("이름의 길이가 " + ExceptionManager.MINIMUM_CAR_NAME_LENGTH + "이상 "
                + ExceptionManager.MAXIMUM_CAR_NAME_LENGTH
                + "이하여야 됩니다."), 
        INVALID_NUMBER_ROUND_TYPE("시도 횟수는 숫자여야 합니다."),
        INVALID_NUMBER_ROUND_RANGE("가능한 이동 회수는 " + ExceptionManager.MINUMUM_NUMBER_ROUND + "이상 "
                + ExceptionManager.MAXIMUM_NUMBER_ROUND + "이하여야 됩니다.");

        private static final String errorMessageFormat = "[ERROR] %s";
        private final String message;

        GameStatus(String message) {
            this.message = String.format(errorMessageFormat, message);
        }

        public String toString() {
            return this.message;
        }
    }

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

    public static GameStatus checkValidNumberRound(String input) {
        if (!isNumber(input)) {
            return GameStatus.INVALID_NUMBER_ROUND_TYPE;
        }
        if (!isValidNumberRoundRange(input)) {
            return GameStatus.INVALID_NUMBER_ROUND_RANGE;
        }
        return GameStatus.OK;
    }

    private static boolean isNumber(String input) {
        String numberPattern = "[+-]?[0-9]+";
        return Pattern.matches(numberPattern, input);
    }

    private static boolean isValidNumberRoundRange(String input) {
        try {
            int convertedNumber = Integer.parseInt(input);
            if (convertedNumber < MINUMUM_NUMBER_ROUND || convertedNumber > MAXIMUM_NUMBER_ROUND) {
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
