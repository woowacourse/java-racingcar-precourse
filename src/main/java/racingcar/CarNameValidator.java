package racingcar;

import java.util.List;

public class CarNameValidator {
    private static final int NAME_SIZE = 5;
    private static final String NAME_SIZE_ERROR_MESSAGE = "[ERROR] 이름은 1자 이상 5자 이하여야 한다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "[ERROR] 이름은 중복될 수 없다.";

    public static void checkException(List<String> carNameList) {
        if (!checkCarNameLength(carNameList)) {
            throw new IllegalArgumentException(NAME_SIZE_ERROR_MESSAGE);
        }
        if (!checkDuplicateName(carNameList)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }

    public static boolean checkCarNameLength(List<String> carNameList) {
        return carNameList.stream()
                .filter(carName -> carName.length() > 0 && carName.length() <= NAME_SIZE)
                .count() == carNameList.size();
    }

    public static boolean checkDuplicateName(List<String> carNameList) {
        return carNameList.stream()
                .distinct()
                .count() == carNameList.size();
    }
}
