package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final String ERROR = "[ERROR] ";

    public static void validateCarNames(String[] carNames) {
        validateUniqueCarNames(carNames);

        for (String carName : carNames) {
            validateCarNameLength(carName);
            validateCarNameFormat(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() == 0) {
            throw new IllegalArgumentException(ERROR + "자동차명은 최소 1글자여야 한다.");
        }

        if (carName.length() >= 6) {
            throw new IllegalArgumentException(ERROR + "자동차명은 최대 5글자여야 한다.");
        }
    }

    private static void validateCarNameFormat(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ERROR + "자동차명에 공백이 포함되어서는 안 된다.");
        }
    }

    private static void validateUniqueCarNames(String[] carNames) {
        List<String> carNameList = Arrays.asList(carNames);
        Set<String> carNameSet = new HashSet<>(carNameList);

        if (carNameList.size() > carNameSet.size()) {
            throw new IllegalArgumentException(ERROR + "같은 자동차명을 중복 사용해서는 안 된다.");
        }
    }
}
