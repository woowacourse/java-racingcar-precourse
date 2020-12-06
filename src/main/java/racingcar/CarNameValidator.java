package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarNameValidator {
    private static final String CAR_NAME_REGEX = "[가-힣a-zA-Z0-9]+";
    private static final String DELIM = ",";
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private static List<String> carNames;

    public static List<String> validateCarName(String name) {
        carNames = new ArrayList<>();
        String[] nameTokens = name.split(DELIM);
        for (String eachName : nameTokens) {
            checkException(eachName);
            carNames.add(eachName);
        }
        return carNames;
    }

    private static void checkException(String eachName) {
        checkDuplication(eachName);
        checkNotOverLengthOf(eachName);
        checkRightFormatOf(eachName);
    }

    private static void checkDuplication(String eachName) {
        if (isSameName(eachName)) {
            throw new IllegalCarNameException("[ERROR] 동일한 자동차 이름이 있으면 안된다.\n");
        }
    }

    private static boolean isSameName(String eachName) {
        return carNames.contains(eachName);
    }

    private static void checkNotOverLengthOf(String eachName) {
        if (isLongerThanMax(eachName)) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 5자 이하여야 한다.\n");
        }
    }
    
    private static boolean isLongerThanMax(String eachName) {
        return eachName.length() > MAXIMUM_LENGTH_OF_NAME;
    }

    private static void checkRightFormatOf(String eachName) {
        if (!isMatchRightFormat(eachName)) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 한글, 알파벳, 숫자 조합으로만 이루어져야 한다.\n");
        }
    }
    
    private static boolean isMatchRightFormat(String eachName) {
        return eachName.matches(CAR_NAME_REGEX);
    }
}
