package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarValidator {
    public static void validateCarName(String name) {
        checkNotOverLengthOf(name);
        checkRightFormatOf(name);
    }

    public static void checkNotOverLengthOf(String name) {
        if (name.length() > 5) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 5자 이하여야 한다.");
        }
    }

    public static void checkRightFormatOf(String name) {
        if (!name.matches("[가-힣a-zA-Z0-9]+")) {
            throw new IllegalCarNameException("[ERROR] 자동차 이름은 한글, 알파벳, 숫자 조합으로만 이루어져야 한다.");
        }
    }

    public static void validateDuplication(String name) {
        List<String> duplicationChecker = new ArrayList<>();
        String[] names = name.split(",");

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
