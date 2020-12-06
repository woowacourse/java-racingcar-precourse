package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarValidator {
    private static final String CAR_NAME_REGEX = "[가-힣a-zA-Z0-9]+";
    private static final String DELIM = ",";
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    public static void validateCarName(String name) {
        checkNotOverLengthOf(name);
        checkRightFormatOf(name);
    }

    private static void checkNotOverLengthOf(String name) {
        if (name.length() > MAXIMUM_LENGTH_OF_NAME) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
        }
    }

    private static void checkRightFormatOf(String name) {
        if (!name.matches(CAR_NAME_REGEX)) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 한글, 알파벳, 숫자 조합으로만 이루어져야 한다.");
        }
    }

    public static void validateDuplication(String name) {
        List<String> duplicationChecker = new ArrayList<>();
        String[] names = name.split(DELIM);

        for (String eachName : names) {
            checkSameName(duplicationChecker, eachName);
            duplicationChecker.add(eachName);
        }
    }

    private static void checkSameName(List<String> duplicationChecker, String eachName) {
        if (isSameName(duplicationChecker, eachName)) {
            throw new IllegalCarNameException("[ERROR] 동일한 자동차 이름이 있으면 안된다.");
        }
    }

    private static boolean isSameName(List<String> duplicationChecker, String eachName) {
        return duplicationChecker.contains(eachName);
    }
}
